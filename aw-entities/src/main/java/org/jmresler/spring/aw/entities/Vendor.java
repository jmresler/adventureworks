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

/**
 *
 * @author John
 */
@Entity
@Table(name = "Vendor", catalog = "AdventureWorks2017", schema = "Purchasing")

@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByBusinessEntityID", query = "SELECT v FROM Vendor v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Vendor.findByCreditRating", query = "SELECT v FROM Vendor v WHERE v.creditRating = :creditRating"),
    @NamedQuery(name = "Vendor.findByPurchasingWebServiceURL", query = "SELECT v FROM Vendor v WHERE v.purchasingWebServiceURL = :purchasingWebServiceURL"),
    @NamedQuery(name = "Vendor.findByModifiedDate", query = "SELECT v FROM Vendor v WHERE v.modifiedDate = :modifiedDate")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "CreditRating")
    private short creditRating;
    @Column(name = "PurchasingWebServiceURL")
    private String purchasingWebServiceURL;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Collection<ProductVendor> productVendorCollection;

    public Vendor() {
    }

    public Vendor(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public Vendor(Integer businessEntityID, short creditRating, Date modifiedDate) {
        this.businessEntityID = businessEntityID;
        this.creditRating = creditRating;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public short getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(short creditRating) {
        this.creditRating = creditRating;
    }

    public String getPurchasingWebServiceURL() {
        return purchasingWebServiceURL;
    }

    public void setPurchasingWebServiceURL(String purchasingWebServiceURL) {
        this.purchasingWebServiceURL = purchasingWebServiceURL;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<PurchaseOrderHeader> getPurchaseOrderHeaderCollection() {
        return purchaseOrderHeaderCollection;
    }

    public void setPurchaseOrderHeaderCollection(Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection) {
        this.purchaseOrderHeaderCollection = purchaseOrderHeaderCollection;
    }

    public Collection<ProductVendor> getProductVendorCollection() {
        return productVendorCollection;
    }

    public void setProductVendorCollection(Collection<ProductVendor> productVendorCollection) {
        this.productVendorCollection = productVendorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessEntityID != null ? businessEntityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.businessEntityID == null && other.businessEntityID != null) || (this.businessEntityID != null && !this.businessEntityID.equals(other.businessEntityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Vendor[ businessEntityID=" + businessEntityID + " ]";
    }
    
}
