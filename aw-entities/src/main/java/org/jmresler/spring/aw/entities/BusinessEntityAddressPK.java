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
public class BusinessEntityAddressPK implements Serializable {

	private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "AddressID")
    private int addressID;
    @Basic(optional = false)
    @Column(name = "AddressTypeID")
    private int addressTypeID;

    public BusinessEntityAddressPK() {
    }

    public BusinessEntityAddressPK(int businessEntityID, int addressID, int addressTypeID) {
        this.businessEntityID = businessEntityID;
        this.addressID = addressID;
        this.addressTypeID = addressTypeID;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getAddressTypeID() {
        return addressTypeID;
    }

    public void setAddressTypeID(int addressTypeID) {
        this.addressTypeID = addressTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (int) addressID;
        hash += (int) addressTypeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessEntityAddressPK)) {
            return false;
        }
        BusinessEntityAddressPK other = (BusinessEntityAddressPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if (this.addressID != other.addressID) {
            return false;
        }
        if (this.addressTypeID != other.addressTypeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.BusinessEntityAddressPK[ businessEntityID=" + businessEntityID + ", addressID=" + addressID + ", addressTypeID=" + addressTypeID + " ]";
    }
    
}
