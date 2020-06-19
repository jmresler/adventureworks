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
@Table(name = "ProductVendor", catalog = "AdventureWorks2017", schema = "Purchasing")

@NamedQueries({
    @NamedQuery(name = "ProductVendor.findAll", query = "SELECT p FROM ProductVendor p"),
    @NamedQuery(name = "ProductVendor.findByProductID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.productID = :productID"),
    @NamedQuery(name = "ProductVendor.findByBusinessEntityID", query = "SELECT p FROM ProductVendor p WHERE p.productVendorPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "ProductVendor.findByAverageLeadTime", query = "SELECT p FROM ProductVendor p WHERE p.averageLeadTime = :averageLeadTime"),
    @NamedQuery(name = "ProductVendor.findByStandardPrice", query = "SELECT p FROM ProductVendor p WHERE p.standardPrice = :standardPrice"),
    @NamedQuery(name = "ProductVendor.findByLastReceiptCost", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptCost = :lastReceiptCost"),
    @NamedQuery(name = "ProductVendor.findByLastReceiptDate", query = "SELECT p FROM ProductVendor p WHERE p.lastReceiptDate = :lastReceiptDate"),
    @NamedQuery(name = "ProductVendor.findByMinOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.minOrderQty = :minOrderQty"),
    @NamedQuery(name = "ProductVendor.findByMaxOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.maxOrderQty = :maxOrderQty"),
    @NamedQuery(name = "ProductVendor.findByOnOrderQty", query = "SELECT p FROM ProductVendor p WHERE p.onOrderQty = :onOrderQty"),
    @NamedQuery(name = "ProductVendor.findByUnitMeasureCode", query = "SELECT p FROM ProductVendor p WHERE p.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "ProductVendor.findByModifiedDate", query = "SELECT p FROM ProductVendor p WHERE p.modifiedDate = :modifiedDate")})
public class ProductVendor implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductVendorPK productVendorPK;
    @Basic(optional = false)
    @Column(name = "AverageLeadTime")
    private int averageLeadTime;
    @Basic(optional = false)
    @Column(name = "StandardPrice")
    private BigDecimal standardPrice;
    @Column(name = "LastReceiptCost")
    private BigDecimal lastReceiptCost;
    @Column(name = "LastReceiptDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReceiptDate;
    @Basic(optional = false)
    @Column(name = "MinOrderQty")
    private int minOrderQty;
    @Basic(optional = false)
    @Column(name = "MaxOrderQty")
    private int maxOrderQty;
    @Column(name = "OnOrderQty")
    private Integer onOrderQty;
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendor vendor;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
