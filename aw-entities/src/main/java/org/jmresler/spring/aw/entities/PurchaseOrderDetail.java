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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PurchaseOrderDetail", schema = "Purchasing")
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
    @Column(name = "DueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "OrderQty", nullable = false)
    private short orderQty;
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @Column(name = "LineTotal", nullable = false, precision = 19, scale = 4)
    private BigDecimal lineTotal;
    @Basic(optional = false)
    @Column(name = "ReceivedQty", nullable = false, precision = 8, scale = 2)
    private BigDecimal receivedQty;
    @Basic(optional = false)
    @Column(name = "RejectedQty", nullable = false, precision = 8, scale = 2)
    private BigDecimal rejectedQty;
    @Basic(optional = false)
    @Column(name = "StockedQty", nullable = false, precision = 9, scale = 2)
    private BigDecimal stockedQty;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "PurchaseOrderID", referencedColumnName = "PurchaseOrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrderHeader purchaseOrderHeader;

    public PurchaseOrderDetail(PurchaseOrderDetailPK purchaseOrderDetailPK) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
    }
    
}
