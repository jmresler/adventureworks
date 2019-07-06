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
@Table(name = "PurchaseOrderHeader", schema = "Purchasing")
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "PurchaseOrderID", nullable = false)
    private Integer purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "RevisionNumber", nullable = false)
    private short revisionNumber;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private short status;
    @Basic(optional = false)
    @Column(name = "EmployeeID", nullable = false)
    private int employeeID;
    @Basic(optional = false)
    @Column(name = "OrderDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
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
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderHeader")
    private Collection<PurchaseOrderDetail> purchaseOrderDetailCollection;
    @JoinColumn(name = "ShipMethodID", referencedColumnName = "ShipMethodID", nullable = false)
    @ManyToOne(optional = false)
    private ShipMethod shipMethodID;
    @JoinColumn(name = "VendorID", referencedColumnName = "BusinessEntityID", nullable = false)
    @ManyToOne(optional = false)
    private Vendor vendorID;

    public PurchaseOrderHeader(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

}
