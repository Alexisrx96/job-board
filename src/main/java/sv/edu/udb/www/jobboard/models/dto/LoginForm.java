package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Getter
@Setter
public class LoginForm {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
