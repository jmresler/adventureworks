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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "ProductModelIllustration", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductModelIllustration.findAll", query = "SELECT p FROM ProductModelIllustration p"),
    @NamedQuery(name = "ProductModelIllustration.findByProductModelID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModelIllustration.findByIllustrationID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.illustrationID = :illustrationID"),
    @NamedQuery(name = "ProductModelIllustration.findByModifiedDate", query = "SELECT p FROM ProductModelIllustration p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelIllustration implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductModelIllustrationPK productModelIllustrationPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "IllustrationID", referencedColumnName = "IllustrationID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Illustration illustration;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;

    public ProductModelIllustration() {
    }

    public ProductModelIllustration(ProductModelIllustrationPK productModelIllustrationPK) {
        this.productModelIllustrationPK = productModelIllustrationPK;
    }

    public ProductModelIllustration(ProductModelIllustrationPK productModelIllustrationPK, Date modifiedDate) {
        this.productModelIllustrationPK = productModelIllustrationPK;
        this.modifiedDate = modifiedDate;
    }

    public ProductModelIllustration(int productModelID, int illustrationID) {
        this.productModelIllustrationPK = new ProductModelIllustrationPK(productModelID, illustrationID);
    }

    public ProductModelIllustrationPK getProductModelIllustrationPK() {
        return productModelIllustrationPK;
    }

    public void setProductModelIllustrationPK(ProductModelIllustrationPK productModelIllustrationPK) {
        this.productModelIllustrationPK = productModelIllustrationPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Illustration getIllustration() {
        return illustration;
    }

    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
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
        hash += (productModelIllustrationPK != null ? productModelIllustrationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModelIllustration)) {
            return false;
        }
        ProductModelIllustration other = (ProductModelIllustration) object;
        if ((this.productModelIllustrationPK == null && other.productModelIllustrationPK != null) || (this.productModelIllustrationPK != null && !this.productModelIllustrationPK.equals(other.productModelIllustrationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductModelIllustration[ productModelIllustrationPK=" + productModelIllustrationPK + " ]";
    }
    
}
