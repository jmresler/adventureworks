package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author John
 */
@Embeddable
public class PersonPhonePK implements Serializable {

	private static final long serialVersionUID = -264351552079013978L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "PhoneNumberTypeID")
    private int phoneNumberTypeID;

    public PersonPhonePK() {
    }

    public PersonPhonePK(int businessEntityID, int phoneNumberTypeID) {
        this.businessEntityID = businessEntityID;
        this.phoneNumberTypeID = phoneNumberTypeID;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public int getPhoneNumberTypeID() {
        return phoneNumberTypeID;
    }

    public void setPhoneNumberTypeID(int phoneNumberTypeID) {
        this.phoneNumberTypeID = phoneNumberTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (int) phoneNumberTypeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonPhonePK)) {
            return false;
        }
        PersonPhonePK other = (PersonPhonePK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if (this.phoneNumberTypeID != other.phoneNumberTypeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PersonPhonePK[ businessEntityID=" + businessEntityID + ", phoneNumberTypeID=" + phoneNumberTypeID + " ]";
    }
    
}
