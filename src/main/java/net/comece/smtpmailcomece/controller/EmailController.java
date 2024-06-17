package net.comece.smtpmailcomece.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.comece.smtpmailcomece.model.UserSender;
import net.comece.smtpmailcomece.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping("/send-email")
    public ResponseEntity<Void> sender(@RequestBody @Valid UserSender user) {
        service.handleRequest(user);
        return ResponseEntity.ok().build();
    }
}
