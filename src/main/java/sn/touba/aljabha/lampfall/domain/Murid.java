package sn.touba.aljabha.lampfall.domain;

/**
 *
 * @author xadimouSALIH
 */
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "murid")
@EntityListeners(AuditingEntityListener.class)
public class Murid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String civilite;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String password;
    private String photo;
    private String lieuNaissance;
    private String titre;
    private String prenomPere;
    private String prenomMere;
    private String nomMere;
    private String complementsInformations;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Murid serigne;
    @OneToMany(mappedBy = "serigne", cascade = CascadeType.ALL)
    private Set<Murid> talibes = new HashSet<>();

    @ManyToOne
    @JoinColumn
    private Bereup muridBereup;
    @ManyToOne
    @JoinColumn
    private KeurSerigne muridKeurSerigne;

    @OneToMany(mappedBy = "muridFormation", cascade = CascadeType.ALL)
    private Set<Formation> mesFormations;
    @OneToMany(mappedBy = "muridExperience", cascade = CascadeType.ALL)
    private Set<Experience> mesExperiences;
    @OneToMany(mappedBy = "muridSpecialite", cascade = CascadeType.ALL)
    private Set<Specialite> mesSpecialites;
    @OneToMany(mappedBy = "muridCentreInteret", cascade = CascadeType.ALL)
    private Set<CentreInteret> mesCentresInterets;
    @OneToMany(mappedBy = "muridDahira", cascade = CascadeType.ALL)
    private Set<Dahira> mesDahiras;

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
