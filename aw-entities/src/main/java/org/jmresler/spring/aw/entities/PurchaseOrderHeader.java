package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
@Table(name = "PurchaseOrderHeader", catalog = "AdventureWorks2017", schema = "Purchasing")

@NamedQueries({
    @NamedQuery(name = "PurchaseOrderHeader.findAll", query = "SELECT p FROM PurchaseOrderHeader p"),
    @NamedQuery(name = "PurchaseOrderHeader.findByPurchaseOrderID", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.purchaseOrderID = :purchaseOrderID"),
    @NamedQuery(name = "PurchaseOrderHeader.findByRevisionNumber", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.revisionNumber = :revisionNumber"),
    @NamedQuery(name = "PurchaseOrderHeader.findByStatus", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.status = :status"),
    @NamedQuery(name = "PurchaseOrderHeader.findByEmployeeID", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.employeeID = :employeeID"),
    @NamedQuery(name = "PurchaseOrderHeader.findByOrderDate", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.orderDate = :orderDate"),
    @NamedQuery(name = "PurchaseOrderHeader.findByShipDate", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.shipDate = :shipDate"),
    @NamedQuery(name = "PurchaseOrderHeader.findBySubTotal", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.subTotal = :subTotal"),
    @NamedQuery(name = "PurchaseOrderHeader.findByTaxAmt", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.taxAmt = :taxAmt"),
    @NamedQuery(name = "PurchaseOrderHeader.findByFreight", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.freight = :freight"),
    @NamedQuery(name = "PurchaseOrderHeader.findByTotalDue", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.totalDue = :totalDue"),
    @NamedQuery(name = "PurchaseOrderHeader.findByModifiedDate", query = "SELECT p FROM PurchaseOrderHeader p WHERE p.modifiedDate = :modifiedDate")})
public class PurchaseOrderHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PurchaseOrderID")
    private Integer purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "RevisionNumber")
    private short revisionNumber;
    @Basic(optional = false)
    @Column(name = "Status")
    private short status;
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private int employeeID;
    @Basic(optional = false)
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Basic(optional = false)
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Basic(optional = false)
    @Column(name = "TaxAmt")
    private BigDecimal taxAmt;
    @Basic(optional = false)
    @Column(name = "Freight")
    private BigDecimal freight;
    @Basic(optional = false)
    @Column(name = "TotalDue")
    private BigDecimal totalDue;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderHeader")
    private Collection<PurchaseOrderDetail> purchaseOrderDetailCollection;
    @JoinColumn(name = "ShipMethodID", referencedColumnName = "ShipMethodID")
    @ManyToOne(optional = false)
    private ShipMethod shipMethodID;
    @JoinColumn(name = "VendorID", referencedColumnName = "BusinessEntityID")
    @ManyToOne(optional = false)
    private Vendor vendorID;

    public PurchaseOrderHeader() {
    }

    public PurchaseOrderHeader(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public PurchaseOrderHeader(Integer purchaseOrderID, short revisionNumber, short status, int employeeID, Date orderDate, BigDecimal subTotal, BigDecimal taxAmt, BigDecimal freight, BigDecimal totalDue, Date modifiedDate) {
        this.purchaseOrderID = purchaseOrderID;
        this.revisionNumber = revisionNumber;
        this.status = status;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.taxAmt = taxAmt;
        this.freight = freight;
        this.totalDue = totalDue;
        this.modifiedDate = modifiedDate;
    }

    public Integer getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public short getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(short revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        this.taxAmt = taxAmt;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<PurchaseOrderDetail> getPurchaseOrderDetailCollection() {
        return purchaseOrderDetailCollection;
    }

    public void setPurchaseOrderDetailCollection(Collection<PurchaseOrderDetail> purchaseOrderDetailCollection) {
        this.purchaseOrderDetailCollection = purchaseOrderDetailCollection;
    }

    public ShipMethod getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(ShipMethod shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public Vendor getVendorID() {
        return vendorID;
    }

    public void setVendorID(Vendor vendorID) {
        this.vendorID = vendorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderID != null ? purchaseOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderHeader)) {
            return false;
        }
        PurchaseOrderHeader other = (PurchaseOrderHeader) object;
        if ((this.purchaseOrderID == null && other.purchaseOrderID != null) || (this.purchaseOrderID != null && !this.purchaseOrderID.equals(other.purchaseOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PurchaseOrderHeader[ purchaseOrderID=" + purchaseOrderID + " ]";
    }
    
}
