package net.comece.smtpmailcomece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@ComponentScan({"net.comece.smtpmailcomece.controller", "net.comece.smtpmailcomece.repository", "net.comece.smtpmailcomece.service" })
public class SmtpMailComeceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmtpMailComeceApplication.class, args);
	}

}
