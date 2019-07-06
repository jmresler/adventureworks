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
@Table(name = "Product", schema = "Production", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ProductNumber"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByProductNumber", query = "SELECT p FROM Product p WHERE p.productNumber = :productNumber"),
    @NamedQuery(name = "Product.findByColor", query = "SELECT p FROM Product p WHERE p.color = :color"),
    @NamedQuery(name = "Product.findBySafetyStockLevel", query = "SELECT p FROM Product p WHERE p.safetyStockLevel = :safetyStockLevel"),
    @NamedQuery(name = "Product.findByReorderPoint", query = "SELECT p FROM Product p WHERE p.reorderPoint = :reorderPoint"),
    @NamedQuery(name = "Product.findByStandardCost", query = "SELECT p FROM Product p WHERE p.standardCost = :standardCost"),
    @NamedQuery(name = "Product.findByListPrice", query = "SELECT p FROM Product p WHERE p.listPrice = :listPrice"),
    @NamedQuery(name = "Product.findBySize", query = "SELECT p FROM Product p WHERE p.size = :size"),
    @NamedQuery(name = "Product.findByWeight", query = "SELECT p FROM Product p WHERE p.weight = :weight"),
    @NamedQuery(name = "Product.findByDaysToManufacture", query = "SELECT p FROM Product p WHERE p.daysToManufacture = :daysToManufacture"),
    @NamedQuery(name = "Product.findByProductLine", query = "SELECT p FROM Product p WHERE p.productLine = :productLine"),
    @NamedQuery(name = "Product.findByClass1", query = "SELECT p FROM Product p WHERE p.class1 = :class1"),
    @NamedQuery(name = "Product.findByStyle", query = "SELECT p FROM Product p WHERE p.style = :style"),
    @NamedQuery(name = "Product.findBySellStartDate", query = "SELECT p FROM Product p WHERE p.sellStartDate = :sellStartDate"),
    @NamedQuery(name = "Product.findBySellEndDate", query = "SELECT p FROM Product p WHERE p.sellEndDate = :sellEndDate"),
    @NamedQuery(name = "Product.findByDiscontinuedDate", query = "SELECT p FROM Product p WHERE p.discontinuedDate = :discontinuedDate"),
    @NamedQuery(name = "Product.findByRowguid", query = "SELECT p FROM Product p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "Product.findByModifiedDate", query = "SELECT p FROM Product p WHERE p.modifiedDate = :modifiedDate")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "ProductNumber", nullable = false, length = 25)
    private String productNumber;
    @Column(name = "Color", length = 15)
    private String color;
    @Basic(optional = false)
    @Column(name = "SafetyStockLevel", nullable = false)
    private short safetyStockLevel;
    @Basic(optional = false)
    @Column(name = "ReorderPoint", nullable = false)
    private short reorderPoint;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "StandardCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal standardCost;
    @Basic(optional = false)
    @Column(name = "ListPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal listPrice;
    @Column(name = "Size", length = 5)
    private String size;
    @Column(name = "Weight", precision = 8, scale = 2)
    private BigDecimal weight;
    @Basic(optional = false)
    @Column(name = "DaysToManufacture", nullable = false)
    private int daysToManufacture;
    @Column(name = "ProductLine", length = 2)
    private String productLine;
    @Column(name = "Class", length = 2)
    private String class1;
    @Column(name = "Style", length = 2)
    private String style;
    @Basic(optional = false)
    @Column(name = "SellStartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellStartDate;
    @Column(name = "SellEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellEndDate;
    @Column(name = "DiscontinuedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedDate;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductInventory> productInventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<TransactionHistory> transactionHistoryCollection;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID")
    @ManyToOne
    private ProductModel productModelID;
    @JoinColumn(name = "ProductSubcategoryID", referencedColumnName = "ProductSubcategoryID")
    @ManyToOne
    private ProductSubcategory productSubcategoryID;
    @JoinColumn(name = "SizeUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne
    private UnitMeasure sizeUnitMeasureCode;
    @JoinColumn(name = "WeightUnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne
    private UnitMeasure weightUnitMeasureCode;
    @XmlTransient
    @OneToMany(mappedBy = "productAssemblyID")
    private Collection<BillOfMaterials> billOfMaterialsCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentID")
    private Collection<BillOfMaterials> billOfMaterialsCollection1;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<ProductReview> productReviewCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductCostHistory> productCostHistoryCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<WorkOrder> workOrderCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductProductPhoto> productProductPhotoCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductListPriceHistory> productListPriceHistoryCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductDocument> productDocumentCollection;

    public Product(Integer productID) {
        this.productID = productID;
    }
}
