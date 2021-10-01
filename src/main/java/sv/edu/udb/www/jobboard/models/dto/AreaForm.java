package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Validated
@Getter
@Setter
public class AreaForm {

    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    @Max(200)
    private String name;
}
