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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "SalesOrderHeader", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SalesOrderHeader.findAll", query = "SELECT s FROM SalesOrderHeader s"),
    @NamedQuery(name = "SalesOrderHeader.findBySalesOrderID", query = "SELECT s FROM SalesOrderHeader s WHERE s.salesOrderID = :salesOrderID"),
    @NamedQuery(name = "SalesOrderHeader.findByRevisionNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.revisionNumber = :revisionNumber"),
    @NamedQuery(name = "SalesOrderHeader.findByOrderDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.orderDate = :orderDate"),
    @NamedQuery(name = "SalesOrderHeader.findByDueDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.dueDate = :dueDate"),
    @NamedQuery(name = "SalesOrderHeader.findByShipDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipDate = :shipDate"),
    @NamedQuery(name = "SalesOrderHeader.findByStatus", query = "SELECT s FROM SalesOrderHeader s WHERE s.status = :status"),
    @NamedQuery(name = "SalesOrderHeader.findBySalesOrderNumber", query = "SELECT s FROM SalesOrderHeader s WHERE s.salesOrderNumber = :salesOrderNumber"),
    @NamedQuery(name = "SalesOrderHeader.findByBillToAddressID", query = "SELECT s FROM SalesOrderHeader s WHERE s.billToAddressID = :billToAddressID"),
    @NamedQuery(name = "SalesOrderHeader.findByShipToAddressID", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipToAddressID = :shipToAddressID"),
    @NamedQuery(name = "SalesOrderHeader.findByShipMethodID", query = "SELECT s FROM SalesOrderHeader s WHERE s.shipMethodID = :shipMethodID"),
    @NamedQuery(name = "SalesOrderHeader.findByCreditCardApprovalCode", query = "SELECT s FROM SalesOrderHeader s WHERE s.creditCardApprovalCode = :creditCardApprovalCode"),
    @NamedQuery(name = "SalesOrderHeader.findBySubTotal", query = "SELECT s FROM SalesOrderHeader s WHERE s.subTotal = :subTotal"),
    @NamedQuery(name = "SalesOrderHeader.findByTaxAmt", query = "SELECT s FROM SalesOrderHeader s WHERE s.taxAmt = :taxAmt"),
    @NamedQuery(name = "SalesOrderHeader.findByFreight", query = "SELECT s FROM SalesOrderHeader s WHERE s.freight = :freight"),
    @NamedQuery(name = "SalesOrderHeader.findByTotalDue", query = "SELECT s FROM SalesOrderHeader s WHERE s.totalDue = :totalDue"),
    @NamedQuery(name = "SalesOrderHeader.findByComment", query = "SELECT s FROM SalesOrderHeader s WHERE s.comment = :comment"),
    @NamedQuery(name = "SalesOrderHeader.findByRowguid", query = "SELECT s FROM SalesOrderHeader s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesOrderHeader.findByModifiedDate", query = "SELECT s FROM SalesOrderHeader s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderHeader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SalesOrderID")
    private Integer salesOrderID;
    @Basic(optional = false)
    @Column(name = "RevisionNumber")
    private short revisionNumber;
    @Basic(optional = false)
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Basic(optional = false)
    @Column(name = "Status")
    private short status;
    @Basic(optional = false)
    @Column(name = "SalesOrderNumber")
    private String salesOrderNumber;
    @Basic(optional = false)
    @Column(name = "BillToAddressID")
    private int billToAddressID;
    @Basic(optional = false)
    @Column(name = "ShipToAddressID")
    private int shipToAddressID;
    @Basic(optional = false)
    @Column(name = "ShipMethodID")
    private int shipMethodID;
    @Column(name = "CreditCardApprovalCode")
    private String creditCardApprovalCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Column(name = "Comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID")
    @ManyToOne
    private CreditCard creditCardID;
    @JoinColumn(name = "CurrencyRateID", referencedColumnName = "CurrencyRateID")
    @ManyToOne
    private CurrencyRate currencyRateID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customer customerID;
    @JoinColumn(name = "SalesPersonID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private SalesPerson salesPersonID;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;

    public SalesOrderHeader() {
    }

    public SalesOrderHeader(Integer salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public SalesOrderHeader(Integer salesOrderID, short revisionNumber, Date orderDate, Date dueDate, short status, String salesOrderNumber, int billToAddressID, int shipToAddressID, int shipMethodID, BigDecimal subTotal, BigDecimal taxAmt, BigDecimal freight, BigDecimal totalDue, String rowguid, Date modifiedDate) {
        this.salesOrderID = salesOrderID;
        this.revisionNumber = revisionNumber;
        this.orderDate = orderDate;
        this.dueDate = dueDate;
        this.status = status;
        this.salesOrderNumber = salesOrderNumber;
        this.billToAddressID = billToAddressID;
        this.shipToAddressID = shipToAddressID;
        this.shipMethodID = shipMethodID;
        this.subTotal = subTotal;
        this.taxAmt = taxAmt;
        this.freight = freight;
        this.totalDue = totalDue;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(Integer salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public short getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(short revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public int getBillToAddressID() {
        return billToAddressID;
    }

    public void setBillToAddressID(int billToAddressID) {
        this.billToAddressID = billToAddressID;
    }

    public int getShipToAddressID() {
        return shipToAddressID;
    }

    public void setShipToAddressID(int shipToAddressID) {
        this.shipToAddressID = shipToAddressID;
    }

    public int getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(int shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public CreditCard getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(CreditCard creditCardID) {
        this.creditCardID = creditCardID;
    }

    public CurrencyRate getCurrencyRateID() {
        return currencyRateID;
    }

    public void setCurrencyRateID(CurrencyRate currencyRateID) {
        this.currencyRateID = currencyRateID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public SalesPerson getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(SalesPerson salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public SalesTerritory getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(SalesTerritory territoryID) {
        this.territoryID = territoryID;
    }

    public Collection<SalesOrderHeaderSalesReason> getSalesOrderHeaderSalesReasonCollection() {
        return salesOrderHeaderSalesReasonCollection;
    }

    public void setSalesOrderHeaderSalesReasonCollection(Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection) {
        this.salesOrderHeaderSalesReasonCollection = salesOrderHeaderSalesReasonCollection;
    }

    public Collection<SalesOrderDetail> getSalesOrderDetailCollection() {
        return salesOrderDetailCollection;
    }

    public void setSalesOrderDetailCollection(Collection<SalesOrderDetail> salesOrderDetailCollection) {
        this.salesOrderDetailCollection = salesOrderDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesOrderID != null ? salesOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderHeader)) {
            return false;
        }
        SalesOrderHeader other = (SalesOrderHeader) object;
        if ((this.salesOrderID == null && other.salesOrderID != null) || (this.salesOrderID != null && !this.salesOrderID.equals(other.salesOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesOrderHeader[ salesOrderID=" + salesOrderID + " ]";
    }
    
}
