package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
@Getter
@Setter
public class TagForm {

    //Hidden
    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 1, max = 50, message = "El máximo son 50 caracteres")
    private String name;
}
