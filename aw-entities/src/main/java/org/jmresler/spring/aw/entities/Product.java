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
@Table(name = "Product", catalog = "AdventureWorks2017", schema = "Production")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "ProductNumber")
    private String productNumber;
    @Column(name = "Color")
    private String color;
    @Basic(optional = false)
    @Column(name = "SafetyStockLevel")
    private short safetyStockLevel;
    @Basic(optional = false)
    @Column(name = "ReorderPoint")
    private short reorderPoint;
    @Basic(optional = false)
    @Column(name = "StandardCost")
    private BigDecimal standardCost;
    @Basic(optional = false)
    @Column(name = "ListPrice")
    private BigDecimal listPrice;
    @Column(name = "Size")
    private String size;
    @Column(name = "Weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @Column(name = "DaysToManufacture")
    private int daysToManufacture;
    @Column(name = "ProductLine")
    private String productLine;
    @Column(name = "Class")
    private String class1;
    @Column(name = "Style")
    private String style;
    @Basic(optional = false)
    @Column(name = "SellStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellStartDate;
    @Column(name = "SellEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellEndDate;
    @Column(name = "DiscontinuedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedDate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
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
    @OneToMany(mappedBy = "productAssemblyID")
    private Collection<BillOfMaterials> billOfMaterialsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentID")
    private Collection<BillOfMaterials> billOfMaterialsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<ProductReview> productReviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductCostHistory> productCostHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<WorkOrder> workOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductProductPhoto> productProductPhotoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductListPriceHistory> productListPriceHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductDocument> productDocumentCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + productID + "]"; 
	}
}
