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

/**
 *
 * @author John
 */
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

    public Password() {
    }

    public Password(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public Password(Integer businessEntityID, String passwordHash, String passwordSalt, String rowguid, Date modifiedDate) {
        this.businessEntityID = businessEntityID;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPreviousPassword1() {
		return previousPassword1;
	}

	public void setPreviousPassword1(String previousPassword1) {
		this.previousPassword1 = previousPassword1;
	}

	public String getPreviousPassword2() {
		return previousPassword2;
	}

	public void setPreviousPassword2(String previousPassword2) {
		this.previousPassword2 = previousPassword2;
	}

	public String getPreviousPassword3() {
		return previousPassword3;
	}

	public void setPreviousPassword3(String previousPassword3) {
		this.previousPassword3 = previousPassword3;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(businessEntityID, 
							loginAttempts, 
							modifiedDate, 
							passwordHash, 
							passwordSalt, 
							person,
							previousPassword1, 
							previousPassword2, 
							previousPassword3, 
							rowguid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Password))
			return false;
		Password other = (Password) obj;
		return Objects.equals(businessEntityID, other.businessEntityID) 
				&& loginAttempts == other.loginAttempts
				&& Objects.equals(modifiedDate, other.modifiedDate) 
				&& Objects.equals(passwordHash, other.passwordHash)
				&& Objects.equals(passwordSalt, other.passwordSalt) 
				&& Objects.equals(person, other.person)
				&& Objects.equals(previousPassword1, other.previousPassword1)
				&& Objects.equals(previousPassword2, other.previousPassword2)
				&& Objects.equals(previousPassword3, other.previousPassword3) 
				&& Objects.equals(rowguid, other.rowguid);
	}

	
	@Override
	public String toString() {
		return "Password [businessEntityID=" + businessEntityID 
				+ ", passwordHash=" + passwordHash 
				+ ", passwordSalt=" + passwordSalt 
				+ ", rowguid=" + rowguid 
				+ ", modifiedDate=" + modifiedDate 
				+ ", person=" + person
				+ ", previousPassword1=" + previousPassword1 
				+ ", previousPassword2=" + previousPassword2
				+ ", previousPassword3=" + previousPassword3 
				+ ", loginAttempts=" + loginAttempts + "]";
	}
}
