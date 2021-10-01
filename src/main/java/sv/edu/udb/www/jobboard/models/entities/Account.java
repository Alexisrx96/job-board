package sv.edu.udb.www.jobboard.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "account")
@Entity
@Getter
@Setter
public class Account implements Serializable {
    @Id
    @Column(name = "email", nullable = false)
    private String id;

    @Column(name = "pwrd", nullable = false)
    private String pwrd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type", nullable = false)
    private AccountType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state", nullable = false)
    private AccountState state;

    @Column(name = "confirm_code", nullable = false, length = 6)
    private String confirmCode;

}