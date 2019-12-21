package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "SalesOrderDetail", catalog = "AdventureWorks2017", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrderDetail.findAll", query = "SELECT s FROM SalesOrderDetail s"),
    @NamedQuery(name = "SalesOrderDetail.findBySalesOrderID", query = "SELECT s FROM SalesOrderDetail s WHERE s.salesOrderDetailPK.salesOrderID = :salesOrderID"),
    @NamedQuery(name = "SalesOrderDetail.findBySalesOrderDetailID", query = "SELECT s FROM SalesOrderDetail s WHERE s.salesOrderDetailPK.salesOrderDetailID = :salesOrderDetailID"),
    @NamedQuery(name = "SalesOrderDetail.findByCarrierTrackingNumber", query = "SELECT s FROM SalesOrderDetail s WHERE s.carrierTrackingNumber = :carrierTrackingNumber"),
    @NamedQuery(name = "SalesOrderDetail.findByOrderQty", query = "SELECT s FROM SalesOrderDetail s WHERE s.orderQty = :orderQty"),
    @NamedQuery(name = "SalesOrderDetail.findByUnitPrice", query = "SELECT s FROM SalesOrderDetail s WHERE s.unitPrice = :unitPrice"),
    @NamedQuery(name = "SalesOrderDetail.findByUnitPriceDiscount", query = "SELECT s FROM SalesOrderDetail s WHERE s.unitPriceDiscount = :unitPriceDiscount"),
    @NamedQuery(name = "SalesOrderDetail.findByLineTotal", query = "SELECT s FROM SalesOrderDetail s WHERE s.lineTotal = :lineTotal"),
    @NamedQuery(name = "SalesOrderDetail.findByRowguid", query = "SELECT s FROM SalesOrderDetail s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesOrderDetail.findByModifiedDate", query = "SELECT s FROM SalesOrderDetail s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesOrderDetailPK salesOrderDetailPK;
    @Column(name = "CarrierTrackingNumber")
    private String carrierTrackingNumber;
    @Basic(optional = false)
    @Column(name = "OrderQty")
    private short orderQty;
    @Basic(optional = false)
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @Column(name = "UnitPriceDiscount")
    private BigDecimal unitPriceDiscount;
    @Basic(optional = false)
    @Column(name = "LineTotal")
    private BigDecimal lineTotal;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumns({
        @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID"),
        @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")})
    @ManyToOne(optional = false)
    private SpecialOfferProduct specialOfferProduct;

    public SalesOrderDetail() {
    }

    public SalesOrderDetail(SalesOrderDetailPK salesOrderDetailPK) {
        this.salesOrderDetailPK = salesOrderDetailPK;
    }

    public SalesOrderDetail(SalesOrderDetailPK salesOrderDetailPK, short orderQty, BigDecimal unitPrice, BigDecimal unitPriceDiscount, BigDecimal lineTotal, String rowguid, Date modifiedDate) {
        this.salesOrderDetailPK = salesOrderDetailPK;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.unitPriceDiscount = unitPriceDiscount;
        this.lineTotal = lineTotal;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public SalesOrderDetail(int salesOrderID, int salesOrderDetailID) {
        this.salesOrderDetailPK = new SalesOrderDetailPK(salesOrderID, salesOrderDetailID);
    }

    public SalesOrderDetailPK getSalesOrderDetailPK() {
        return salesOrderDetailPK;
    }

    public void setSalesOrderDetailPK(SalesOrderDetailPK salesOrderDetailPK) {
        this.salesOrderDetailPK = salesOrderDetailPK;
    }

    public String getCarrierTrackingNumber() {
        return carrierTrackingNumber;
    }

    public void setCarrierTrackingNumber(String carrierTrackingNumber) {
        this.carrierTrackingNumber = carrierTrackingNumber;
    }

    public short getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(short orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPriceDiscount() {
        return unitPriceDiscount;
    }

    public void setUnitPriceDiscount(BigDecimal unitPriceDiscount) {
        this.unitPriceDiscount = unitPriceDiscount;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
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

    public SalesOrderHeader getSalesOrderHeader() {
        return salesOrderHeader;
    }

    public void setSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
        this.salesOrderHeader = salesOrderHeader;
    }

    public SpecialOfferProduct getSpecialOfferProduct() {
        return specialOfferProduct;
    }

    public void setSpecialOfferProduct(SpecialOfferProduct specialOfferProduct) {
        this.specialOfferProduct = specialOfferProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesOrderDetailPK != null ? salesOrderDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderDetail)) {
            return false;
        }
        SalesOrderDetail other = (SalesOrderDetail) object;
        if ((this.salesOrderDetailPK == null && other.salesOrderDetailPK != null) || (this.salesOrderDetailPK != null && !this.salesOrderDetailPK.equals(other.salesOrderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesOrderDetail[ salesOrderDetailPK=" + salesOrderDetailPK + " ]";
    }
    
}
