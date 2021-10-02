package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
public class ResumeForm {

    private int id;

    @NotNull
    private int profile;

    @NotBlank(message = "El archivo es obligatorio")
    @Max(value = 500, message = "El nombre del archivo es demasiado largo")
    private String address;
}
