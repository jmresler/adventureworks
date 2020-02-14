package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "PersonPhone", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "PersonPhone.findAll", query = "SELECT p FROM PersonPhone p"),
    @NamedQuery(name = "PersonPhone.findByBusinessEntityID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "PersonPhone.findByPhoneNumberTypeID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.phoneNumberTypeID = :phoneNumberTypeID"),
    @NamedQuery(name = "PersonPhone.findByModifiedDate", query = "SELECT p FROM PersonPhone p WHERE p.modifiedDate = :modifiedDate")})
public class PersonPhone implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonPhonePK personPhonePK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "PhoneNumberTypeID", referencedColumnName = "PhoneNumberTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhoneNumberType phoneNumberType;

    public PersonPhone() {
    }

    public PersonPhone(PersonPhonePK personPhonePK) {
        this.personPhonePK = personPhonePK;
    }

    public PersonPhone(PersonPhonePK personPhonePK, Date modifiedDate) {
        this.personPhonePK = personPhonePK;
        this.modifiedDate = modifiedDate;
    }

    public PersonPhone(int businessEntityID, int phoneNumberTypeID) {
        this.personPhonePK = new PersonPhonePK(businessEntityID, phoneNumberTypeID);
    }

    public PersonPhonePK getPersonPhonePK() {
        return personPhonePK;
    }

    public void setPersonPhonePK(PersonPhonePK personPhonePK) {
        this.personPhonePK = personPhonePK;
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

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personPhonePK != null ? personPhonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPhone)) {
            return false;
        }
        PersonPhone other = (PersonPhone) object;
        if ((this.personPhonePK == null && other.personPhonePK != null) || (this.personPhonePK != null && !this.personPhonePK.equals(other.personPhonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PersonPhone[ personPhonePK=" + personPhonePK + " ]";
    }
    
}
