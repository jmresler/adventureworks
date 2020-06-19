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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
