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
@Table(name = "ProductVendor", schema = "Purchasing")
@XmlRootElement
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
    @Column(name = "AverageLeadTime", nullable = false)
    private int averageLeadTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "StandardPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal standardPrice;
    @Column(name = "LastReceiptCost", precision = 19, scale = 4)
    private BigDecimal lastReceiptCost;
    @Column(name = "LastReceiptDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReceiptDate;
    @Basic(optional = false)
    @Column(name = "MinOrderQty", nullable = false)
    private int minOrderQty;
    @Basic(optional = false)
    @Column(name = "MaxOrderQty", nullable = false)
    private int maxOrderQty;
    @Column(name = "OnOrderQty")
    private Integer onOrderQty;
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode", nullable = false, length = 3)
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendor vendor;

    public ProductVendor(ProductVendorPK productVendorPK) {
        this.productVendorPK = productVendorPK;
    }
    
}
