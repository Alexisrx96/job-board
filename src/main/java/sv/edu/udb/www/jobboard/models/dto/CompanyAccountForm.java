package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
@Getter
@Setter
public class CompanyAccountForm {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Dirección email no válida")
    @Max(value = 255, message = "El máximo son 255 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Max(200)
    private String name;

    @NotBlank(message = "El nombre es obligatorio")
    @Max(1000)
    private String about;
}
