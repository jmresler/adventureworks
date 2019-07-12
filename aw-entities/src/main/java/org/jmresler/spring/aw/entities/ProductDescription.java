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
@Table(name = "ProductDescription", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDescription.findAll", query = "SELECT p FROM ProductDescription p"),
    @NamedQuery(name = "ProductDescription.findByProductDescriptionID", query = "SELECT p FROM ProductDescription p WHERE p.productDescriptionID = :productDescriptionID"),
    @NamedQuery(name = "ProductDescription.findByDescription", query = "SELECT p FROM ProductDescription p WHERE p.description = :description"),
    @NamedQuery(name = "ProductDescription.findByRowguid", query = "SELECT p FROM ProductDescription p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductDescription.findByModifiedDate", query = "SELECT p FROM ProductDescription p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductDescriptionID")
    private Integer productDescriptionID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDescription")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public ProductDescription() {
    }

    public ProductDescription(Integer productDescriptionID) {
        this.productDescriptionID = productDescriptionID;
    }

    public ProductDescription(Integer productDescriptionID, String description, String rowguid, Date modifiedDate) {
        this.productDescriptionID = productDescriptionID;
        this.description = description;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductDescriptionID() {
        return productDescriptionID;
    }

    public void setProductDescriptionID(Integer productDescriptionID) {
        this.productDescriptionID = productDescriptionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Collection<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultureCollection() {
        return productModelProductDescriptionCultureCollection;
    }

    public void setProductModelProductDescriptionCultureCollection(Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection) {
        this.productModelProductDescriptionCultureCollection = productModelProductDescriptionCultureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDescriptionID != null ? productDescriptionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDescription)) {
            return false;
        }
        ProductDescription other = (ProductDescription) object;
        if ((this.productDescriptionID == null && other.productDescriptionID != null) || (this.productDescriptionID != null && !this.productDescriptionID.equals(other.productDescriptionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductDescription[ productDescriptionID=" + productDescriptionID + " ]";
    }
    
}
