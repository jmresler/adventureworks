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
@Table(name = "ProductCostHistory", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCostHistory.findAll", query = "SELECT p FROM ProductCostHistory p"),
    @NamedQuery(name = "ProductCostHistory.findByProductID", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.productID = :productID"),
    @NamedQuery(name = "ProductCostHistory.findByStartDate", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "ProductCostHistory.findByEndDate", query = "SELECT p FROM ProductCostHistory p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "ProductCostHistory.findByStandardCost", query = "SELECT p FROM ProductCostHistory p WHERE p.standardCost = :standardCost"),
    @NamedQuery(name = "ProductCostHistory.findByModifiedDate", query = "SELECT p FROM ProductCostHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductCostHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductCostHistoryPK productCostHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "StandardCost")
    private BigDecimal standardCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductCostHistory() {
    }

    public ProductCostHistory(ProductCostHistoryPK productCostHistoryPK) {
        this.productCostHistoryPK = productCostHistoryPK;
    }

    public ProductCostHistory(ProductCostHistoryPK productCostHistoryPK, BigDecimal standardCost, Date modifiedDate) {
        this.productCostHistoryPK = productCostHistoryPK;
        this.standardCost = standardCost;
        this.modifiedDate = modifiedDate;
    }

    public ProductCostHistory(int productID, Date startDate) {
        this.productCostHistoryPK = new ProductCostHistoryPK(productID, startDate);
    }

    public ProductCostHistoryPK getProductCostHistoryPK() {
        return productCostHistoryPK;
    }

    public void setProductCostHistoryPK(ProductCostHistoryPK productCostHistoryPK) {
        this.productCostHistoryPK = productCostHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
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
        hash += (productCostHistoryPK != null ? productCostHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCostHistory)) {
            return false;
        }
        ProductCostHistory other = (ProductCostHistory) object;
        if ((this.productCostHistoryPK == null && other.productCostHistoryPK != null) || (this.productCostHistoryPK != null && !this.productCostHistoryPK.equals(other.productCostHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductCostHistory[ productCostHistoryPK=" + productCostHistoryPK + " ]";
    }
    
}
