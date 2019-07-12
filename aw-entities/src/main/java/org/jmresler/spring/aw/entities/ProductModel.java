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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ProductModel", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModel.findAll", query = "SELECT p FROM ProductModel p"),
    @NamedQuery(name = "ProductModel.findByProductModelID", query = "SELECT p FROM ProductModel p WHERE p.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModel.findByCatalogDescription", query = "SELECT p FROM ProductModel p WHERE p.catalogDescription = :catalogDescription"),
    @NamedQuery(name = "ProductModel.findByInstructions", query = "SELECT p FROM ProductModel p WHERE p.instructions = :instructions"),
    @NamedQuery(name = "ProductModel.findByRowguid", query = "SELECT p FROM ProductModel p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductModel.findByModifiedDate", query = "SELECT p FROM ProductModel p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductModelID")
    private Integer productModelID;
    @Column(name = "CatalogDescription")
    private String catalogDescription;
    @Column(name = "Instructions")
    private String instructions;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;
    @OneToMany(mappedBy = "productModelID")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public ProductModel() {
    }

    public ProductModel(Integer productModelID) {
        this.productModelID = productModelID;
    }

    public ProductModel(Integer productModelID, String rowguid, Date modifiedDate) {
        this.productModelID = productModelID;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(Integer productModelID) {
        this.productModelID = productModelID;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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
    public Collection<ProductModelIllustration> getProductModelIllustrationCollection() {
        return productModelIllustrationCollection;
    }

    public void setProductModelIllustrationCollection(Collection<ProductModelIllustration> productModelIllustrationCollection) {
        this.productModelIllustrationCollection = productModelIllustrationCollection;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultureCollection() {
        return productModelProductDescriptionCultureCollection;
    }

    public void setProductModelProductDescriptionCultureCollection(Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection) {
        this.productModelProductDescriptionCultureCollection = productModelProductDescriptionCultureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productModelID != null ? productModelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModel)) {
            return false;
        }
        ProductModel other = (ProductModel) object;
        if ((this.productModelID == null && other.productModelID != null) || (this.productModelID != null && !this.productModelID.equals(other.productModelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductModel[ productModelID=" + productModelID + " ]";
    }
    
}
