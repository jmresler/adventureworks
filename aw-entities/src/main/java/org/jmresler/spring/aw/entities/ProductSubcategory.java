/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "ProductSubcategory", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p"),
    @NamedQuery(name = "ProductSubcategory.findByProductSubcategoryID", query = "SELECT p FROM ProductSubcategory p WHERE p.productSubcategoryID = :productSubcategoryID"),
    @NamedQuery(name = "ProductSubcategory.findByRowguid", query = "SELECT p FROM ProductSubcategory p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductSubcategory.findByModifiedDate", query = "SELECT p FROM ProductSubcategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductSubcategoryID")
    private Integer productSubcategoryID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "productSubcategoryID")
    private Collection<Product> productCollection;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID")
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;

    public ProductSubcategory() {
    }

    public ProductSubcategory(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

    public ProductSubcategory(Integer productSubcategoryID, String rowguid, Date modifiedDate) {
        this.productSubcategoryID = productSubcategoryID;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductSubcategoryID() {
        return productSubcategoryID;
    }

    public void setProductSubcategoryID(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
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
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public ProductCategory getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(ProductCategory productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSubcategoryID != null ? productSubcategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSubcategory)) {
            return false;
        }
        ProductSubcategory other = (ProductSubcategory) object;
        if ((this.productSubcategoryID == null && other.productSubcategoryID != null) || (this.productSubcategoryID != null && !this.productSubcategoryID.equals(other.productSubcategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductSubcategory[ productSubcategoryID=" + productSubcategoryID + " ]";
    }
    
}
