package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Getter
@Setter
public class JobOfferForm {
    private int id;
    @NotBlank
    @Size(max = 200)
    private String title;
    @NotBlank
    @Size(max = 65535)
    private String description;
    @NotNull
    private int company;
    @NotNull
    private int state;
    @NotNull
    private int area;
}
