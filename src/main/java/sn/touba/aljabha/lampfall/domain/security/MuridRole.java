package sn.touba.aljabha.lampfall.domain.security;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import sn.touba.aljabha.lampfall.domain.Murid;

@Data
@Entity
@Table(name = "murid_role")
@EntityListeners(AuditingEntityListener.class)
public class MuridRole implements Serializable {

    private static final long serialVersionUID = 890345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Murid murid;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

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
