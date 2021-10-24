package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
public class ProfesionalProfileTagId implements Serializable {
    private static final long serialVersionUID = 6537179792400146898L;
    @Column(name = "profesional_profile_id", nullable = false)
    private Integer profesionalProfileId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;


    @Override
    public int hashCode() {
        return Objects.hash(tagId, profesionalProfileId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfesionalProfileTagId entity = (ProfesionalProfileTagId) o;
        return Objects.equals(this.tagId, entity.tagId) &&
                Objects.equals(this.profesionalProfileId, entity.profesionalProfileId);
    }
}