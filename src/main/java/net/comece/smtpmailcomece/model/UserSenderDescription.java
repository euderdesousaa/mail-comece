package net.comece.smtpmailcomece.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSenderDescription {

    @Schema(example = "Necessito de coisas assim assim e assim...")
    @Lob
    private String description;

}
