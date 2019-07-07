/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "Product", catalog = "AdventureWorks2017", schema = "Production")
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Product(Integer productID, String productNumber, short safetyStockLevel, short reorderPoint, BigDecimal standardCost, BigDecimal listPrice, int daysToManufacture, Date sellStartDate, String rowguid, Date modifiedDate) {
        this.productID = productID;
        this.productNumber = productNumber;
        this.safetyStockLevel = safetyStockLevel;
        this.reorderPoint = reorderPoint;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.daysToManufacture = daysToManufacture;
        this.sellStartDate = sellStartDate;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(short safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public short getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(short reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getDaysToManufacture() {
        return daysToManufacture;
    }

    public void setDaysToManufacture(int daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Date getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(Date sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public Date getSellEndDate() {
        return sellEndDate;
    }

    public void setSellEndDate(Date sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public Date getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(Date discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<ProductInventory> getProductInventoryCollection() {
        return productInventoryCollection;
    }

    public void setProductInventoryCollection(Collection<ProductInventory> productInventoryCollection) {
        this.productInventoryCollection = productInventoryCollection;
    }

    @XmlTransient
    public Collection<TransactionHistory> getTransactionHistoryCollection() {
        return transactionHistoryCollection;
    }

    public void setTransactionHistoryCollection(Collection<TransactionHistory> transactionHistoryCollection) {
        this.transactionHistoryCollection = transactionHistoryCollection;
    }

    public ProductModel getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(ProductModel productModelID) {
        this.productModelID = productModelID;
    }

    public ProductSubcategory getProductSubcategoryID() {
        return productSubcategoryID;
    }

    public void setProductSubcategoryID(ProductSubcategory productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

    public UnitMeasure getSizeUnitMeasureCode() {
        return sizeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCode(UnitMeasure sizeUnitMeasureCode) {
        this.sizeUnitMeasureCode = sizeUnitMeasureCode;
    }

    public UnitMeasure getWeightUnitMeasureCode() {
        return weightUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(UnitMeasure weightUnitMeasureCode) {
        this.weightUnitMeasureCode = weightUnitMeasureCode;
    }

    @XmlTransient
    public Collection<BillOfMaterials> getBillOfMaterialsCollection() {
        return billOfMaterialsCollection;
    }

    public void setBillOfMaterialsCollection(Collection<BillOfMaterials> billOfMaterialsCollection) {
        this.billOfMaterialsCollection = billOfMaterialsCollection;
    }

    @XmlTransient
    public Collection<BillOfMaterials> getBillOfMaterialsCollection1() {
        return billOfMaterialsCollection1;
    }

    public void setBillOfMaterialsCollection1(Collection<BillOfMaterials> billOfMaterialsCollection1) {
        this.billOfMaterialsCollection1 = billOfMaterialsCollection1;
    }

    @XmlTransient
    public Collection<ProductReview> getProductReviewCollection() {
        return productReviewCollection;
    }

    public void setProductReviewCollection(Collection<ProductReview> productReviewCollection) {
        this.productReviewCollection = productReviewCollection;
    }

    @XmlTransient
    public Collection<ProductCostHistory> getProductCostHistoryCollection() {
        return productCostHistoryCollection;
    }

    public void setProductCostHistoryCollection(Collection<ProductCostHistory> productCostHistoryCollection) {
        this.productCostHistoryCollection = productCostHistoryCollection;
    }

    @XmlTransient
    public Collection<WorkOrder> getWorkOrderCollection() {
        return workOrderCollection;
    }

    public void setWorkOrderCollection(Collection<WorkOrder> workOrderCollection) {
        this.workOrderCollection = workOrderCollection;
    }

    @XmlTransient
    public Collection<ProductProductPhoto> getProductProductPhotoCollection() {
        return productProductPhotoCollection;
    }

    public void setProductProductPhotoCollection(Collection<ProductProductPhoto> productProductPhotoCollection) {
        this.productProductPhotoCollection = productProductPhotoCollection;
    }

    @XmlTransient
    public Collection<ProductListPriceHistory> getProductListPriceHistoryCollection() {
        return productListPriceHistoryCollection;
    }

    public void setProductListPriceHistoryCollection(Collection<ProductListPriceHistory> productListPriceHistoryCollection) {
        this.productListPriceHistoryCollection = productListPriceHistoryCollection;
    }

    @XmlTransient
    public Collection<ProductDocument> getProductDocumentCollection() {
        return productDocumentCollection;
    }

    public void setProductDocumentCollection(Collection<ProductDocument> productDocumentCollection) {
        this.productDocumentCollection = productDocumentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Product[ productID=" + productID + " ]";
    }
    
}
