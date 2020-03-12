package org.jmresler.spring.aw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

/**
 *
 * @author John
 */
@Entity
@Table(name = "BusinessEntityAddress", catalog = "AdventureWorks2017", schema = "Person")

@NamedQueries({
    @NamedQuery(name = "BusinessEntityAddress.findAll", query = "SELECT b FROM BusinessEntityAddress b"),
    @NamedQuery(name = "BusinessEntityAddress.findByBusinessEntityID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "BusinessEntityAddress.findByAddressID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressID = :addressID"),
    @NamedQuery(name = "BusinessEntityAddress.findByAddressTypeID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressTypeID = :addressTypeID"),
    @NamedQuery(name = "BusinessEntityAddress.findByRowguid", query = "SELECT b FROM BusinessEntityAddress b WHERE b.rowguid = :rowguid"),
    @NamedQuery(name = "BusinessEntityAddress.findByModifiedDate", query = "SELECT b FROM BusinessEntityAddress b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntityAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessEntityAddressPK businessEntityAddressPK;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JsonIgnore
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Address address;
    @JsonIgnore
    @JoinColumn(name = "AddressTypeID", referencedColumnName = "AddressTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AddressType addressType;
    @JsonIgnore
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BusinessEntity businessEntity;

    public BusinessEntityAddress() {
    }

    public BusinessEntityAddress(BusinessEntityAddressPK businessEntityAddressPK) {
        this.businessEntityAddressPK = businessEntityAddressPK;
    }

    public BusinessEntityAddress(BusinessEntityAddressPK businessEntityAddressPK, String rowguid, Date modifiedDate) {
        this.businessEntityAddressPK = businessEntityAddressPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public BusinessEntityAddress(int businessEntityID, int addressID, int addressTypeID) {
        this.businessEntityAddressPK = new BusinessEntityAddressPK(businessEntityID, addressID, addressTypeID);
    }

    public BusinessEntityAddressPK getBusinessEntityAddressPK() {
        return businessEntityAddressPK;
    }

    public void setBusinessEntityAddressPK(BusinessEntityAddressPK businessEntityAddressPK) {
        this.businessEntityAddressPK = businessEntityAddressPK;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessEntityAddressPK != null ? businessEntityAddressPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessEntityAddress)) {
            return false;
        }
        BusinessEntityAddress other = (BusinessEntityAddress) object;
        if ((this.businessEntityAddressPK == null && other.businessEntityAddressPK != null) || (this.businessEntityAddressPK != null && !this.businessEntityAddressPK.equals(other.businessEntityAddressPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.BusinessEntityAddress[ businessEntityAddressPK=" + businessEntityAddressPK + " ]";
    }
    
}
