package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Validated
@Getter
@Setter
public class TagForm {

    //Hidden
    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    @Max(value = 50,message = "El máximo son 50 caracteres")
    private String name;
}
