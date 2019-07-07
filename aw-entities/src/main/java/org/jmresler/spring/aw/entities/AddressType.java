/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "AddressType", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a"),
    @NamedQuery(name = "AddressType.findByAddressTypeID", query = "SELECT a FROM AddressType a WHERE a.addressTypeID = :addressTypeID"),
    @NamedQuery(name = "AddressType.findByRowguid", query = "SELECT a FROM AddressType a WHERE a.rowguid = :rowguid"),
    @NamedQuery(name = "AddressType.findByModifiedDate", query = "SELECT a FROM AddressType a WHERE a.modifiedDate = :modifiedDate")})
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AddressTypeID")
    private Integer addressTypeID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

    public AddressType() {
    }

    public AddressType(Integer addressTypeID) {
        this.addressTypeID = addressTypeID;
    }

    public AddressType(Integer addressTypeID, String rowguid, Date modifiedDate) {
        this.addressTypeID = addressTypeID;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getAddressTypeID() {
        return addressTypeID;
    }

    public void setAddressTypeID(Integer addressTypeID) {
        this.addressTypeID = addressTypeID;
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

    @XmlTransient
    public Collection<BusinessEntityAddress> getBusinessEntityAddressCollection() {
        return businessEntityAddressCollection;
    }

    public void setBusinessEntityAddressCollection(Collection<BusinessEntityAddress> businessEntityAddressCollection) {
        this.businessEntityAddressCollection = businessEntityAddressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressTypeID != null ? addressTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressType)) {
            return false;
        }
        AddressType other = (AddressType) object;
        if ((this.addressTypeID == null && other.addressTypeID != null) || (this.addressTypeID != null && !this.addressTypeID.equals(other.addressTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.AddressType[ addressTypeID=" + addressTypeID + " ]";
    }
    
}
