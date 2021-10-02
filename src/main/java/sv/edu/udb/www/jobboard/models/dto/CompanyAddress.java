package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
public class CompanyAddress {

    //Hidden input
    private int id;

    //Hidden input
    @NotNull
    private int company;

    @NotNull
    @Max(value = 500, message = "Demasiado largo")
    private String address;

}
