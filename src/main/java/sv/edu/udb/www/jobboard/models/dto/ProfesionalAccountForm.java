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
    @Max(value = 255,message = "El máximo son 255 caracteres")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Min(value = 6,message = "El mínimo son 6 caracteres")
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[\\p{L} .'-]+$")
    @Max(value = 100,message = "El máximo son 100 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[\\p{L} .'-]+$")
    @Max(value = 100,message = "El máximo son 100 caracteres")
    private String lastName;

    //ComboBox
    @NotNull(message = "El área es obligatoria")
    private int area;
}
