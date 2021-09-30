package sv.edu.udb.www.jobboard.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "resume", indexes = {
        @Index(name = "file_address", columnList = "file_address", unique = true)
})
@Entity
@Getter
@Setter
@Validated
public class Resume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profesional_profile_id", nullable = false)
    private ProfesionalProfile profesionalProfile;

    @Column(name = "file_address", nullable = false, length = 500)
    private String fileAddress;

}