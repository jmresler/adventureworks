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
import javax.persistence.UniqueConstraint;
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
@Table(name = "SalesOrderDetail", schema = "Sales", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
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
    @Column(name = "CarrierTrackingNumber", length = 25)
    private String carrierTrackingNumber;
    @Basic(optional = false)
    @Column(name = "OrderQty", nullable = false)
    private short orderQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @Column(name = "UnitPriceDiscount", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPriceDiscount;
    @Basic(optional = false)
    @Column(name = "LineTotal", nullable = false, precision = 38, scale = 6)
    private BigDecimal lineTotal;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumns({
        @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", nullable = false),
        @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)})
    @ManyToOne(optional = false)
    private SpecialOfferProduct specialOfferProduct;


    public SalesOrderDetail(SalesOrderDetailPK salesOrderDetailPK) {
        this.salesOrderDetailPK = salesOrderDetailPK;
    }

    public SalesOrderDetail(int salesOrderID, int salesOrderDetailID) {
        this.salesOrderDetailPK = new SalesOrderDetailPK(salesOrderID, salesOrderDetailID);
    }    
}
