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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "SalesOrderDetail", catalog = "AdventureWorks2017", schema = "Sales")
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
    
    @Column(name = "CarrierTrackingNumber")
    private String carrierTrackingNumber;
    
    @Basic(optional = false)
    @Column(name = "OrderQty")
    private short orderQty;
    
    @Basic(optional = false)
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    
    @Basic(optional = false)
    @Column(name = "UnitPriceDiscount")
    private BigDecimal unitPriceDiscount;
    
    @Basic(optional = false)
    @Column(name = "LineTotal")
    private BigDecimal lineTotal;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    
    @JsonBackReference
    @JoinColumns({
        @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID"),
        @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")})
    @ManyToOne(optional = false)
    private SpecialOfferProduct specialOfferProduct;


	@Override
	public String toString() {
		return getClass().getName() + "[Sales Order Detail ID: " + salesOrderDetailPK.getSalesOrderDetailID() + ", Sales Order ID: " + salesOrderDetailPK.getSalesOrderID() + "]"; 
	}
}
