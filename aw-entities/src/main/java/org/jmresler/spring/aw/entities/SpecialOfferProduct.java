package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SpecialOfferProduct", catalog = "AdventureWorks2017", schema = "Sales")

@NamedQueries({
    @NamedQuery(name = "SpecialOfferProduct.findAll", query = "SELECT s FROM SpecialOfferProduct s"),
    @NamedQuery(name = "SpecialOfferProduct.findBySpecialOfferID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.specialOfferID = :specialOfferID"),
    @NamedQuery(name = "SpecialOfferProduct.findByProductID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.productID = :productID"),
    @NamedQuery(name = "SpecialOfferProduct.findByRowguid", query = "SELECT s FROM SpecialOfferProduct s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SpecialOfferProduct.findByModifiedDate", query = "SELECT s FROM SpecialOfferProduct s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOfferProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SpecialOfferProductPK specialOfferProductPK;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOfferProduct")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;
    @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpecialOffer specialOffer;

    public SpecialOfferProduct() {
    }

    public SpecialOfferProduct(SpecialOfferProductPK specialOfferProductPK) {
        this.specialOfferProductPK = specialOfferProductPK;
    }

    public SpecialOfferProduct(SpecialOfferProductPK specialOfferProductPK, String rowguid, Date modifiedDate) {
        this.specialOfferProductPK = specialOfferProductPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public SpecialOfferProduct(int specialOfferID, int productID) {
        this.specialOfferProductPK = new SpecialOfferProductPK(specialOfferID, productID);
    }

    public SpecialOfferProductPK getSpecialOfferProductPK() {
        return specialOfferProductPK;
    }

    public void setSpecialOfferProductPK(SpecialOfferProductPK specialOfferProductPK) {
        this.specialOfferProductPK = specialOfferProductPK;
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

    public Collection<SalesOrderDetail> getSalesOrderDetailCollection() {
        return salesOrderDetailCollection;
    }

    public void setSalesOrderDetailCollection(Collection<SalesOrderDetail> salesOrderDetailCollection) {
        this.salesOrderDetailCollection = salesOrderDetailCollection;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialOfferProductPK != null ? specialOfferProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialOfferProduct)) {
            return false;
        }
        SpecialOfferProduct other = (SpecialOfferProduct) object;
        if ((this.specialOfferProductPK == null && other.specialOfferProductPK != null) || (this.specialOfferProductPK != null && !this.specialOfferProductPK.equals(other.specialOfferProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SpecialOfferProduct[ specialOfferProductPK=" + specialOfferProductPK + " ]";
    }
    
}
