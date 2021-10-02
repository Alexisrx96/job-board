package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "job_offer")
@Entity
@Getter
@Setter
public class JobOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyProfile company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_id", nullable = false)
    private JobOfferState state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;
}