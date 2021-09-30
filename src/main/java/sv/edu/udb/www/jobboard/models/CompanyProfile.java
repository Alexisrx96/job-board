package sv.edu.udb.www.jobboard.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "company_profile", indexes = {
        @Index(name = "email", columnList = "email", unique = true)
})
@Entity
@Getter
@Setter
@Validated
public class CompanyProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "email", nullable = false)
    private Account email;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "about", nullable = false, length = 1000)
    private String about;
}