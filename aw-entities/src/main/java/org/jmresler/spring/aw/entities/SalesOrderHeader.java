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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
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
    
    @JsonManagedReference
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

    //if you know the range of your decimal fields 
    // consider using these annotations to enforce field validation    
    // @Max(value=?)  @Min(value=?)
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
    
    @JsonBackReference
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;


	@Override
	public String toString() {
		return getClass().getName() + "[" + salesOrderID + "]"; 
	}
}
