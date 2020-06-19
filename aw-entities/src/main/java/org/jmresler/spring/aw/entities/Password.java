package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Password", catalog = "AdventureWorks2017", schema = "Person")

@NamedQueries({
    @NamedQuery(name = "Password.findAll", query = "SELECT p FROM Password p"),
    @NamedQuery(name = "Password.findByBusinessEntityID", query = "SELECT p FROM Password p WHERE p.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Password.findByPasswordHash", query = "SELECT p FROM Password p WHERE p.passwordHash = :passwordHash"),
    @NamedQuery(name = "Password.findByPasswordSalt", query = "SELECT p FROM Password p WHERE p.passwordSalt = :passwordSalt"),
    @NamedQuery(name = "Password.findByRowguid", query = "SELECT p FROM Password p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "Password.findByModifiedDate", query = "SELECT p FROM Password p WHERE p.modifiedDate = :modifiedDate")})
public class Password implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Basic(optional = false)
    @Column(name = "PasswordSalt")
    private String passwordSalt;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @Basic
    @Column(name = "PreviousPassword1")
    private String previousPassword1;
    @Basic
    @Column(name = "PreviousPassword2")
    private String previousPassword2;
    @Basic
    @Column(name = "PreviousPassword3")
    private String previousPassword3;
    @Basic
    @Column(name = "LoginAttempts")
    private int loginAttempts;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
