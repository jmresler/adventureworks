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
@Table(name = "PersonCreditCard", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "PersonCreditCard.findAll", query = "SELECT p FROM PersonCreditCard p"),
    @NamedQuery(name = "PersonCreditCard.findByBusinessEntityID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "PersonCreditCard.findByCreditCardID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.creditCardID = :creditCardID"),
    @NamedQuery(name = "PersonCreditCard.findByModifiedDate", query = "SELECT p FROM PersonCreditCard p WHERE p.modifiedDate = :modifiedDate")})
public class PersonCreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonCreditCardPK personCreditCardPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CreditCard creditCard;

    public PersonCreditCard() {
    }

    public PersonCreditCard(PersonCreditCardPK personCreditCardPK) {
        this.personCreditCardPK = personCreditCardPK;
    }

    public PersonCreditCard(PersonCreditCardPK personCreditCardPK, Date modifiedDate) {
        this.personCreditCardPK = personCreditCardPK;
        this.modifiedDate = modifiedDate;
    }

    public PersonCreditCard(int businessEntityID, int creditCardID) {
        this.personCreditCardPK = new PersonCreditCardPK(businessEntityID, creditCardID);
    }

    public PersonCreditCardPK getPersonCreditCardPK() {
        return personCreditCardPK;
    }

    public void setPersonCreditCardPK(PersonCreditCardPK personCreditCardPK) {
        this.personCreditCardPK = personCreditCardPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personCreditCardPK != null ? personCreditCardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonCreditCard)) {
            return false;
        }
        PersonCreditCard other = (PersonCreditCard) object;
        if ((this.personCreditCardPK == null && other.personCreditCardPK != null) || (this.personCreditCardPK != null && !this.personCreditCardPK.equals(other.personCreditCardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PersonCreditCard[ personCreditCardPK=" + personCreditCardPK + " ]";
    }
    
}
