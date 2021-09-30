package sv.edu.udb.www.jobboard.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfesionalProfileTagId implements Serializable {
    private static final long serialVersionUID = 6537179792400146898L;
    @Column(name = "profesional_profile_id", nullable = false)
    private Integer profesionalProfileId;
    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getProfesionalProfileId() {
        return profesionalProfileId;
    }

    public void setProfesionalProfileId(Integer profesionalProfileId) {
        this.profesionalProfileId = profesionalProfileId;
    }

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