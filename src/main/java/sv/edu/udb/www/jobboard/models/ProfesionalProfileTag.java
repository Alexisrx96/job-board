package sv.edu.udb.www.jobboard.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "profesional_profile_tag")
@Entity
@Getter
@Setter
@Validated
public class ProfesionalProfileTag implements Serializable {
    @EmbeddedId
    private ProfesionalProfileTagId id;

}