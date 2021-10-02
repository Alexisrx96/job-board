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
public class JobOfferForm {
    private int id;
    @NotBlank
    @Max(200)
    private String title;
    @NotBlank
    @Max(65535)
    private String description;
    @NotNull
    private int company;
    @NotNull
    private int state;
    @NotNull
    private int area;
}
