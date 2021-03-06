package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "profesional_profile_tag")
@Entity
@Getter
@Setter
@ToString
public class ProfesionalProfileTag implements Serializable {
    @EmbeddedId
    private ProfesionalProfileTagId id;

}