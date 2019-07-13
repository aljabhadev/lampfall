package sn.touba.aljabha.lampfall.domain;

/**
 *
 * @author xadimouSALIH
 */
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "experience")
@EntityListeners(AuditingEntityListener.class)
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String intitule;
    private boolean actuelOuPas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String description;
    private String fileToUpload;

    @ManyToOne
    @JoinColumn
    private Murid muridExperience;

    @ManyToOne
    @JoinColumn
    private Bereup experienceBereup;
    //Auditing
    @CreatedDate
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;

}
