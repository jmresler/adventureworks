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

/**
 *
 * @author John
 */
@Entity
@Table(name = "ProductVendor", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
    @NamedQuery(name = "ProductVendor.findAll", query = "SELECT p FROM ProductVendor p"),
    @NamedQuery(name = "ProductVendor.findByProductID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.productID = :productID"),
    @NamedQuery(name = "ProductVendor.findByBusinessEntityID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "ProductVendor.findByAverageLeadTime", query = "SELECT p FROM ProductVendor p WHERE p.averageLeadTime = :averageLeadTime"),
    @NamedQuery(name = "ProductVendor.findByStandardPrice", query = "SELECT p FROM ProductVendor p WHERE p.standardPrice = :standardPrice"),
    @NamedQuery(name = "ProductVendor.findByLastReceiptCost", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptCost = :lastReceiptCost"),
    @NamedQuery(name = "ProductVendor.findByLastReceiptDate", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptDate = :lastReceiptDate"),
    @NamedQuery(name = "ProductVendor.findByMinOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.minOrderQty = :minOrderQty"),
    @NamedQuery(name = "ProductVendor.findByMaxOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.maxOrderQty = :maxOrderQty"),
    @NamedQuery(name = "ProductVendor.findByOnOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.onOrderQty = :onOrderQty"),
    @NamedQuery(name = "ProductVendor.findByUnitMeasureCode", query = "SELECT p FROM ProductVendor p WHERE p.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "ProductVendor.findByModifiedDate", query = "SELECT p FROM ProductVendor p WHERE p.modifiedDate = :modifiedDate")})
public class ProductVendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductVendorPK productVendorPK;
    @Basic(optional = false)
    @Column(name = "AverageLeadTime")
    private int averageLeadTime;
    @Basic(optional = false)
    @Column(name = "StandardPrice")
    private BigDecimal standardPrice;
    @Column(name = "LastReceiptCost")
    private BigDecimal lastReceiptCost;
    @Column(name = "LastReceiptDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReceiptDate;
    @Basic(optional = false)
    @Column(name = "MinOrderQty")
    private int minOrderQty;
    @Basic(optional = false)
    @Column(name = "MaxOrderQty")
    private int maxOrderQty;
    @Column(name = "OnOrderQty")
    private Integer onOrderQty;
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendor vendor;

    public ProductVendor() {
    }

    public ProductVendor(ProductVendorPK productVendorPK) {
        this.productVendorPK = productVendorPK;
    }

    public ProductVendor(ProductVendorPK productVendorPK, int averageLeadTime, BigDecimal standardPrice, int minOrderQty, int maxOrderQty, String unitMeasureCode, Date modifiedDate) {
        this.productVendorPK = productVendorPK;
        this.averageLeadTime = averageLeadTime;
        this.standardPrice = standardPrice;
        this.minOrderQty = minOrderQty;
        this.maxOrderQty = maxOrderQty;
        this.unitMeasureCode = unitMeasureCode;
        this.modifiedDate = modifiedDate;
    }

    public ProductVendor(int productID, int businessEntityID) {
        this.productVendorPK = new ProductVendorPK(productID, businessEntityID);
    }

    public ProductVendorPK getProductVendorPK() {
        return productVendorPK;
    }

    public void setProductVendorPK(ProductVendorPK productVendorPK) {
        this.productVendorPK = productVendorPK;
    }

    public int getAverageLeadTime() {
        return averageLeadTime;
    }

    public void setAverageLeadTime(int averageLeadTime) {
        this.averageLeadTime = averageLeadTime;
    }

    public BigDecimal getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    public BigDecimal getLastReceiptCost() {
        return lastReceiptCost;
    }

    public void setLastReceiptCost(BigDecimal lastReceiptCost) {
        this.lastReceiptCost = lastReceiptCost;
    }

    public Date getLastReceiptDate() {
        return lastReceiptDate;
    }

    public void setLastReceiptDate(Date lastReceiptDate) {
        this.lastReceiptDate = lastReceiptDate;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public int getMaxOrderQty() {
        return maxOrderQty;
    }

    public void setMaxOrderQty(int maxOrderQty) {
        this.maxOrderQty = maxOrderQty;
    }

    public Integer getOnOrderQty() {
        return onOrderQty;
    }

    public void setOnOrderQty(Integer onOrderQty) {
        this.onOrderQty = onOrderQty;
    }

    public String getUnitMeasureCode() {
        return unitMeasureCode;
    }

    public void setUnitMeasureCode(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productVendorPK != null ? productVendorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductVendor)) {
            return false;
        }
        ProductVendor other = (ProductVendor) object;
        if ((this.productVendorPK == null && other.productVendorPK != null) || (this.productVendorPK != null && !this.productVendorPK.equals(other.productVendorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductVendor[ productVendorPK=" + productVendorPK + " ]";
    }
    
}
