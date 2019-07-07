/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class BusinessEntityContactPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "PersonID")
    private int personID;
    @Basic(optional = false)
    @Column(name = "ContactTypeID")
    private int contactTypeID;

    public BusinessEntityContactPK() {
    }

    public BusinessEntityContactPK(int businessEntityID, int personID, int contactTypeID) {
        this.businessEntityID = businessEntityID;
        this.personID = personID;
        this.contactTypeID = contactTypeID;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(int contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (int) personID;
        hash += (int) contactTypeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessEntityContactPK)) {
            return false;
        }
        BusinessEntityContactPK other = (BusinessEntityContactPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if (this.personID != other.personID) {
            return false;
        }
        if (this.contactTypeID != other.contactTypeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.BusinessEntityContactPK[ businessEntityID=" + businessEntityID + ", personID=" + personID + ", contactTypeID=" + contactTypeID + " ]";
    }
    
}
