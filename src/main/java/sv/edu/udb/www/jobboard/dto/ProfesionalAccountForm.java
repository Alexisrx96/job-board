package sv.edu.udb.www.jobboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
@Getter
@Setter
public class ProfesionalAccountForm {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Dirección email no válida")
    @Max(255)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
}
