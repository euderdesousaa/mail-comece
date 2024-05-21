package net.comece.smtpmailcomece.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.comece.smtpmailcomece.model.UserSenderEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSenderImpl mailSender;

    private final TemplateEngine templateEngine;

    @Value("${COMECE.MAIL.USERNAME}")
    private String emailSender;

    @Value("${COMECE.MAIL.EMAIL}")
    private String toEmail;

    private void sendEmail(UserSenderEmail sender, String templateName, String subject, String toEmail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        Context context = new Context();
        context.setVariable("user", sender);

        String htmlContent = templateEngine.process(templateName, context);
        helper.setFrom(emailSender);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
        log.info("Email sent to {}", toEmail);
    }

    @Async
    public void emailsSender(UserSenderEmail sender) {
        try {
            sendEmail(sender, "template.html", "Welcome " + sender.getFullName(), sender.getEmail());
            sendEmail(sender, "comeceTemplate.html", sender.getFullName() + " está a nossa espera", toEmail);
        } catch (MessagingException e) {
            log.error("Error sending email: {}", e.getMessage());
        }
    }


}

