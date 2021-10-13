package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
@Getter
@Setter
public class AdminAccountForm {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Dirección email no válida")
    @Size(max = 255, message = "El máximo son 255 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6,max = 30)
    private String password;
}
