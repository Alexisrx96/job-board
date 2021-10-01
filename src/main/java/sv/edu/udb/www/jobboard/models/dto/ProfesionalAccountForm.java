package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Validated
@Getter
@Setter
public class ProfesionalAccountForm {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Dirección email no válida")
    @Max(message = "Demasiado largo", value = 255)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[\\p{L} .'-]+$")
    @Max(100)
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[\\p{L} .'-]+$")
    @Max(100)
    private String lastName;

    @NotNull(message = "El área es obligatoria")
    private int area;
}
