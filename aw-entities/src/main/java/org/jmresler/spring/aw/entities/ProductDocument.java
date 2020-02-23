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
@Table(name = "ProductDocument", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "ProductDocument.findAll", query = "SELECT p FROM ProductDocument p"),
    @NamedQuery(name = "ProductDocument.findByProductID", query = "SELECT p FROM ProductDocument p WHERE p.productDocumentPK.productID = :productID"),
    @NamedQuery(name = "ProductDocument.findByModifiedDate", query = "SELECT p FROM ProductDocument p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductDocumentPK productDocumentPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DocumentNode", referencedColumnName = "DocumentNode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductDocument() {
    }

    public ProductDocument(ProductDocumentPK productDocumentPK) {
        this.productDocumentPK = productDocumentPK;
    }

    public ProductDocument(ProductDocumentPK productDocumentPK, Date modifiedDate) {
        this.productDocumentPK = productDocumentPK;
        this.modifiedDate = modifiedDate;
    }

    public ProductDocument(int productID, byte[] documentNode) {
        this.productDocumentPK = new ProductDocumentPK(productID, documentNode);
    }

    public ProductDocumentPK getProductDocumentPK() {
        return productDocumentPK;
    }

    public void setProductDocumentPK(ProductDocumentPK productDocumentPK) {
        this.productDocumentPK = productDocumentPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDocumentPK != null ? productDocumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDocument)) {
            return false;
        }
        ProductDocument other = (ProductDocument) object;
        if ((this.productDocumentPK == null && other.productDocumentPK != null) || (this.productDocumentPK != null && !this.productDocumentPK.equals(other.productDocumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductDocument[ productDocumentPK=" + productDocumentPK + " ]";
    }
    
}
