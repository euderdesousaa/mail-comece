package net.comece.smtpmailcomece.model;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.comece.smtpmailcomece.model.enums.Segment;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_email", schema = "public")
public class UserSender extends UserSenderDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Email
    @NotBlank
    @Schema(example = "exemplo@exemplo.com")
    private String email;

    @NotBlank
    @Schema(description = "Fullname a pessoa pode colocar o primeiro nome ou o nome completo é da escolha, importante é ela colocar o nome",
            example = "Gabriel Toledo")
    private String fullName;

    @Pattern(regexp = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}")
    @NotBlank
    @Schema(description = "Aqui tem um pattern que padroniza o numero do usuario indepedente da forma que ele colocar vai sair da mesma forma",
            example = "(99) 91234 5678")
    private String phoneNumber;

    @Hidden
    private LocalDate dateAtCreate;

    @Enumerated(EnumType.STRING)
    private Segment segment;


}
