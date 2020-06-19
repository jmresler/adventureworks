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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PurchaseOrderDetail", catalog = "AdventureWorks2017", schema = "Purchasing")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
