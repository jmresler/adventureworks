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

/**
 *
 * @author John
 */
@Entity
@Table(name = "ProductModelProductDescriptionCulture", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findAll", query = "SELECT p FROM ProductModelProductDescriptionCulture p"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductModelID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductDescriptionID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productDescriptionID = :productDescriptionID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByCultureID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.cultureID = :cultureID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByModifiedDate", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelProductDescriptionCulture implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CultureID", referencedColumnName = "CultureID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Culture culture;
    @JoinColumn(name = "ProductDescriptionID", referencedColumnName = "ProductDescriptionID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductDescription productDescription;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;

    public ProductModelProductDescriptionCulture() {
    }

    public ProductModelProductDescriptionCulture(ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK) {
        this.productModelProductDescriptionCulturePK = productModelProductDescriptionCulturePK;
    }

    public ProductModelProductDescriptionCulture(ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK, Date modifiedDate) {
        this.productModelProductDescriptionCulturePK = productModelProductDescriptionCulturePK;
        this.modifiedDate = modifiedDate;
    }

    public ProductModelProductDescriptionCulture(int productModelID, int productDescriptionID, String cultureID) {
        this.productModelProductDescriptionCulturePK = new ProductModelProductDescriptionCulturePK(productModelID, productDescriptionID, cultureID);
    }

    public ProductModelProductDescriptionCulturePK getProductModelProductDescriptionCulturePK() {
        return productModelProductDescriptionCulturePK;
    }

    public void setProductModelProductDescriptionCulturePK(ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK) {
        this.productModelProductDescriptionCulturePK = productModelProductDescriptionCulturePK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productModelProductDescriptionCulturePK != null ? productModelProductDescriptionCulturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModelProductDescriptionCulture)) {
            return false;
        }
        ProductModelProductDescriptionCulture other = (ProductModelProductDescriptionCulture) object;
        if ((this.productModelProductDescriptionCulturePK == null && other.productModelProductDescriptionCulturePK != null) || (this.productModelProductDescriptionCulturePK != null && !this.productModelProductDescriptionCulturePK.equals(other.productModelProductDescriptionCulturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductModelProductDescriptionCulture[ productModelProductDescriptionCulturePK=" + productModelProductDescriptionCulturePK + " ]";
    }
    
}
