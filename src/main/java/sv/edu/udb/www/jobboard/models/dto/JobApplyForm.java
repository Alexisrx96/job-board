package sv.edu.udb.www.jobboard.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
public class JobApplyForm {
    private int id;
    private int jobOffer;
    private int resume;
}
