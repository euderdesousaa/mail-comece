package net.comece.smtpmailcomece.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.comece.smtpmailcomece.model.UserSender;
import net.comece.smtpmailcomece.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"https://engix.tech", "http://localhost:3000"}, maxAge = 3600)
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping("/send-email")
    public HttpStatus sender(@RequestBody @Valid UserSender user) {
        if (service.isEmailPresent(user.getEmail())) {
            return HttpStatus.ACCEPTED;
        } else {
            service.handleRequest(user);
            return HttpStatus.OK;
        }
    }
}
