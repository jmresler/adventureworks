package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "SalesOrderHeader", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"SalesOrderNumber"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "SalesOrderID", nullable = false)
    private Integer salesOrderID;
    @Basic(optional = false)
    @Column(name = "RevisionNumber", nullable = false)
    private short revisionNumber;
    @Basic(optional = false)
    @Column(name = "OrderDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "DueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private short status;
    @Basic(optional = false)
    @Column(name = "SalesOrderNumber", nullable = false, length = 25)
    private String salesOrderNumber;
    @Basic(optional = false)
    @Column(name = "BillToAddressID", nullable = false)
    private int billToAddressID;
    @Basic(optional = false)
    @Column(name = "ShipToAddressID", nullable = false)
    private int shipToAddressID;
    @Basic(optional = false)
    @Column(name = "ShipMethodID", nullable = false)
    private int shipMethodID;
    @Column(name = "CreditCardApprovalCode", length = 15)
    private String creditCardApprovalCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SubTotal", nullable = false, precision = 19, scale = 4)
    private BigDecimal subTotal;
    @Basic(optional = false)
    @Column(name = "TaxAmt", nullable = false, precision = 19, scale = 4)
    private BigDecimal taxAmt;
    @Basic(optional = false)
    @Column(name = "Freight", nullable = false, precision = 19, scale = 4)
    private BigDecimal freight;
    @Basic(optional = false)
    @Column(name = "TotalDue", nullable = false, precision = 19, scale = 4)
    private BigDecimal totalDue;
    @Column(name = "Comment", length = 128)
    private String comment;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID")
    @ManyToOne
    private CreditCard creditCardID;
    @JoinColumn(name = "CurrencyRateID", referencedColumnName = "CurrencyRateID")
    @ManyToOne
    private CurrencyRate currencyRateID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerID;
    @JoinColumn(name = "SalesPersonID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private SalesPerson salesPersonID;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderHeader")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;

    public SalesOrderHeader(Integer salesOrderID) {
        this.salesOrderID = salesOrderID;
    }
}
