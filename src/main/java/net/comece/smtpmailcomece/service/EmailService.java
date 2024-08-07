package net.comece.smtpmailcomece.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.comece.smtpmailcomece.model.UserSender;
import net.comece.smtpmailcomece.repository.UserSenderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSenderImpl mailSender;

    private final TemplateEngine templateEngine;

    private final UserSenderRepository repository;
    @Value("${COMECE.MAIL.USERNAME}")
    private String emailSender;

    @Value("${COMECE.MAIL.EMAIL}")
    private String toEmail;

    private final Configuration freemarkerConfig;

    private final Queue<UserSender> requestQueue = new ConcurrentLinkedQueue<>();

    private final DatabaseHealthService databaseHealthService;

    @Async
    public void handleRequest(UserSender requestData) {
        if (databaseHealthService.isDatabaseUp()) {
            saveEmail(requestData);
        } else {
            emailsSender(requestData);
            requestQueue.add(requestData);
        }
    }

    @Scheduled(fixedRate = 60000)
    public void processQueue() {
        if (databaseHealthService.isDatabaseUp()) {
            while (!requestQueue.isEmpty()) {
                UserSender requestData = requestQueue.poll();
                waitEmailDbBack(requestData);
            }
        }
    }

    private void sendEmail(UserSender sender, String linkTemplate,String subject, String toEmail) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,"UTF-8");

        Template template = freemarkerConfig.getTemplate(linkTemplate);
        StringWriter writer = new StringWriter();
        template.process(sender, writer);

        Context context = new Context();
        context.setVariable("user", sender);

        String htmlContent = writer.toString();
        helper.setFrom(emailSender);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
        log.info("Email sent to {}", toEmail);
    }

    protected void emailsSender(UserSender sender) {
        try {
            sendEmail(sender, "template.ftl","Bem Vindo a Engix, " + sender.getFullName(), sender.getEmail());
            sendEmail(sender, "templateEnvio.ftl", sender.getFullName() + " está a nossa espera", toEmail);
        } catch (MessagingException | TemplateException | IOException e) {
            log.error("Error sending email: {}", e.getMessage());
        }
    }

    private void saveEmail(UserSender user) {
        emailsSender(user);
        user.setDateAtCreate(LocalDate.now());
        user.setSegment(user.getSegment());
        repository.save(user);
    }

    private void waitEmailDbBack(UserSender sender) {
        sender.setDateAtCreate(LocalDate.now());
        repository.save(sender);

    }

    public boolean isEmailPresent(String email) {
        Optional<UserSender> user = repository.findByEmail(email);
        return user.isPresent();
    }

}

