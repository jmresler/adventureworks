package org.jmresler.spring.aw.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author John
 */
@Entity
@Table(name = "Address", catalog = "AdventureWorks2017", schema = "Person")

@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "Address.findByAddressLine1", query = "SELECT a FROM Address a WHERE a.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Address.findByAddressLine2", query = "SELECT a FROM Address a WHERE a.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Address.findByModifiedDate", query = "SELECT a FROM Address a WHERE a.modifiedDate = :modifiedDate")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressID")
    private Integer addressID;
    @Basic(optional = false)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private String postalCode;
    // need to fix this converter to work with byte[] conversion
    @Basic(optional = true)
    @Column(name = "SpatialLocation")
    // @Converter(name = "geographyConverter", converterClass = GeographyConverter.class)
    private byte[] spatialLocation;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JsonIgnore
    @JoinColumn(name = "StateProvinceID", referencedColumnName = "StateProvinceID")
    @ManyToOne(optional = false)
    private StateProvince stateProvinceID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

    public Address() {
    }

    public Address(Integer addressID) {
        this.addressID = addressID;
    }

    public Address(Integer addressID, String addressLine1, String city, String postalCode, String rowguid, Date modifiedDate) {
        this.addressID = addressID;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.postalCode = postalCode;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public byte[] getSpatialLocation() {
        return spatialLocation;
    }

    public void setSpatialLocation(byte[] spatialLocation) {
        this.spatialLocation = spatialLocation;
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

    public StateProvince getStateProvinceID() {
        return stateProvinceID;
    }

    public void setStateProvinceID(StateProvince stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }

    public Collection<BusinessEntityAddress> getBusinessEntityAddressCollection() {
        return businessEntityAddressCollection;
    }

    public void setBusinessEntityAddressCollection(Collection<BusinessEntityAddress> businessEntityAddressCollection) {
        this.businessEntityAddressCollection = businessEntityAddressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("addressID -> ")
               .append(this.addressID)
                .append("\n addressLine1 -> ")
                .append(this.addressLine1)
                .append("\n addressLine2 -> ")
                .append(this.addressLine2)
                .append("\n city -> ")
                .append(this.city)
                .append("\n state -> ")
                .append(this.stateProvinceID)
                .append('\n');
        return buffer.toString();
    }
    
}
