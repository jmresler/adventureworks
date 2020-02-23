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
@Table(name = "ProductProductPhoto", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "ProductProductPhoto.findAll", query = "SELECT p FROM ProductProductPhoto p"),
    @NamedQuery(name = "ProductProductPhoto.findByProductID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productID = :productID"),
    @NamedQuery(name = "ProductProductPhoto.findByProductPhotoID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productPhotoID = :productPhotoID"),
    @NamedQuery(name = "ProductProductPhoto.findByModifiedDate", query = "SELECT p FROM ProductProductPhoto p WHERE p.modifiedDate = :modifiedDate")})
public class ProductProductPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductProductPhotoPK productProductPhotoPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ProductPhotoID", referencedColumnName = "ProductPhotoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductPhoto productPhoto;

    public ProductProductPhoto() {
    }

    public ProductProductPhoto(ProductProductPhotoPK productProductPhotoPK) {
        this.productProductPhotoPK = productProductPhotoPK;
    }

    public ProductProductPhoto(ProductProductPhotoPK productProductPhotoPK, Date modifiedDate) {
        this.productProductPhotoPK = productProductPhotoPK;
        this.modifiedDate = modifiedDate;
    }

    public ProductProductPhoto(int productID, int productPhotoID) {
        this.productProductPhotoPK = new ProductProductPhotoPK(productID, productPhotoID);
    }

    public ProductProductPhotoPK getProductProductPhotoPK() {
        return productProductPhotoPK;
    }

    public void setProductProductPhotoPK(ProductProductPhotoPK productProductPhotoPK) {
        this.productProductPhotoPK = productProductPhotoPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPhoto getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(ProductPhoto productPhoto) {
        this.productPhoto = productPhoto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productProductPhotoPK != null ? productProductPhotoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductProductPhoto)) {
            return false;
        }
        ProductProductPhoto other = (ProductProductPhoto) object;
        if ((this.productProductPhotoPK == null && other.productProductPhotoPK != null) || (this.productProductPhotoPK != null && !this.productProductPhotoPK.equals(other.productProductPhotoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductProductPhoto[ productProductPhotoPK=" + productProductPhotoPK + " ]";
    }
    
}
