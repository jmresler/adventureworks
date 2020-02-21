package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ProductListPriceHistory", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductListPriceHistory.findAll", query = "SELECT p FROM ProductListPriceHistory p"),
    @NamedQuery(name = "ProductListPriceHistory.findByProductID", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.productID = :productID"),
    @NamedQuery(name = "ProductListPriceHistory.findByStartDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "ProductListPriceHistory.findByEndDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "ProductListPriceHistory.findByListPrice", query = "SELECT p FROM ProductListPriceHistory p WHERE p.listPrice = :listPrice"),
    @NamedQuery(name = "ProductListPriceHistory.findByModifiedDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductListPriceHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductListPriceHistoryPK productListPriceHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "ListPrice")
    private BigDecimal listPrice;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductListPriceHistory() {
    }

    public ProductListPriceHistory(ProductListPriceHistoryPK productListPriceHistoryPK) {
        this.productListPriceHistoryPK = productListPriceHistoryPK;
    }

    public ProductListPriceHistory(ProductListPriceHistoryPK productListPriceHistoryPK, BigDecimal listPrice, Date modifiedDate) {
        this.productListPriceHistoryPK = productListPriceHistoryPK;
        this.listPrice = listPrice;
        this.modifiedDate = modifiedDate;
    }

    public ProductListPriceHistory(int productID, Date startDate) {
        this.productListPriceHistoryPK = new ProductListPriceHistoryPK(productID, startDate);
    }

    public ProductListPriceHistoryPK getProductListPriceHistoryPK() {
        return productListPriceHistoryPK;
    }

    public void setProductListPriceHistoryPK(ProductListPriceHistoryPK productListPriceHistoryPK) {
        this.productListPriceHistoryPK = productListPriceHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productListPriceHistoryPK != null ? productListPriceHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductListPriceHistory)) {
            return false;
        }
        ProductListPriceHistory other = (ProductListPriceHistory) object;
        if ((this.productListPriceHistoryPK == null && other.productListPriceHistoryPK != null) || (this.productListPriceHistoryPK != null && !this.productListPriceHistoryPK.equals(other.productListPriceHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductListPriceHistory[ productListPriceHistoryPK=" + productListPriceHistoryPK + " ]";
    }
    
}
