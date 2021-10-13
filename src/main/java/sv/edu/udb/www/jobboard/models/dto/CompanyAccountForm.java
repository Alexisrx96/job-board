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
    @Size(max = 255, message = "El máximo son 255 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 200, message = "El máximo son 200 caracteres")
    private String name;

    @NotBlank(message = "La información es obligatoria")
    @Size(max = 1000, message = "El máximo son 200 caracteres")
    private String about;
}
