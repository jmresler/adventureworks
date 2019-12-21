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
@Table(name = "PurchaseOrderDetail", catalog = "AdventureWorks2017", schema = "Purchasing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderDetail.findAll", query = "SELECT p FROM PurchaseOrderDetail p"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderDetailPK.purchaseOrderID = :purchaseOrderID"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderDetailID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderDetailPK.purchaseOrderDetailID = :purchaseOrderDetailID"),
    @NamedQuery(name = "PurchaseOrderDetail.findByDueDate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "PurchaseOrderDetail.findByOrderQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.orderQty = :orderQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByProductID", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.productID = :productID"),
    @NamedQuery(name = "PurchaseOrderDetail.findByUnitPrice", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "PurchaseOrderDetail.findByLineTotal", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.lineTotal = :lineTotal"),
    @NamedQuery(name = "PurchaseOrderDetail.findByReceivedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.receivedQty = :receivedQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByRejectedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.rejectedQty = :rejectedQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByStockedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.stockedQty = :stockedQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByModifiedDate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.modifiedDate = :modifiedDate")})
public class PurchaseOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseOrderDetailPK purchaseOrderDetailPK;
    @Basic(optional = false)
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "OrderQty")
    private short orderQty;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @Column(name = "LineTotal")
    private BigDecimal lineTotal;
    @Basic(optional = false)
    @Column(name = "ReceivedQty")
    private BigDecimal receivedQty;
    @Basic(optional = false)
    @Column(name = "RejectedQty")
    private BigDecimal rejectedQty;
    @Basic(optional = false)
    @Column(name = "StockedQty")
    private BigDecimal stockedQty;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "PurchaseOrderID", referencedColumnName = "PurchaseOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrderHeader purchaseOrderHeader;

    public PurchaseOrderDetail() {
    }

    public PurchaseOrderDetail(PurchaseOrderDetailPK purchaseOrderDetailPK) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
    }

    public PurchaseOrderDetail(PurchaseOrderDetailPK purchaseOrderDetailPK, Date dueDate, short orderQty, int productID, BigDecimal unitPrice, BigDecimal lineTotal, BigDecimal receivedQty, BigDecimal rejectedQty, BigDecimal stockedQty, Date modifiedDate) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
        this.dueDate = dueDate;
        this.orderQty = orderQty;
        this.productID = productID;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
        this.receivedQty = receivedQty;
        this.rejectedQty = rejectedQty;
        this.stockedQty = stockedQty;
        this.modifiedDate = modifiedDate;
    }

    public PurchaseOrderDetail(int purchaseOrderID, int purchaseOrderDetailID) {
        this.purchaseOrderDetailPK = new PurchaseOrderDetailPK(purchaseOrderID, purchaseOrderDetailID);
    }

    public PurchaseOrderDetailPK getPurchaseOrderDetailPK() {
        return purchaseOrderDetailPK;
    }

    public void setPurchaseOrderDetailPK(PurchaseOrderDetailPK purchaseOrderDetailPK) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public short getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(short orderQty) {
        this.orderQty = orderQty;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    public BigDecimal getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(BigDecimal receivedQty) {
        this.receivedQty = receivedQty;
    }

    public BigDecimal getRejectedQty() {
        return rejectedQty;
    }

    public void setRejectedQty(BigDecimal rejectedQty) {
        this.rejectedQty = rejectedQty;
    }

    public BigDecimal getStockedQty() {
        return stockedQty;
    }

    public void setStockedQty(BigDecimal stockedQty) {
        this.stockedQty = stockedQty;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public PurchaseOrderHeader getPurchaseOrderHeader() {
        return purchaseOrderHeader;
    }

    public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
        this.purchaseOrderHeader = purchaseOrderHeader;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderDetailPK != null ? purchaseOrderDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetail)) {
            return false;
        }
        PurchaseOrderDetail other = (PurchaseOrderDetail) object;
        if ((this.purchaseOrderDetailPK == null && other.purchaseOrderDetailPK != null) || (this.purchaseOrderDetailPK != null && !this.purchaseOrderDetailPK.equals(other.purchaseOrderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PurchaseOrderDetail[ purchaseOrderDetailPK=" + purchaseOrderDetailPK + " ]";
    }
    
}
