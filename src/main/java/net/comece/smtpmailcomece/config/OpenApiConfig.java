package net.comece.smtpmailcomece.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Euder de Sousa",
                        email = "euderdesousaaaa@gmail.com",
                        url = "https://github.com/euderdesousaa"
                ),
                description = "Documentação do sistema de email da Comece",
                title = "Comece Email API - Euder",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "PROD ENV",
                        url = "https://mail-comece.onrender.com"
                )
        }

)

public class OpenApiConfig {
}
