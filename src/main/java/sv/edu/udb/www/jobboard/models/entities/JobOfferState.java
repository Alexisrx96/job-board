package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "job_offer_state")
@Entity
@Getter
@Setter
@ToString
public class JobOfferState implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;
}