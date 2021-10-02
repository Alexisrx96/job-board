package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "profesional_profile", indexes = {
        @Index(name = "email", columnList = "email", unique = true)
})
@Entity
@Getter
@Setter
@ToString
public class ProfesionalProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "email", nullable = false)
    private Account email;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;
}