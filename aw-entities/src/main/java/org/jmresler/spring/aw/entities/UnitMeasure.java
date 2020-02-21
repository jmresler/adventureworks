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
@Table(name = "UnitMeasure", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitMeasure.findAll", query = "SELECT u FROM UnitMeasure u"),
    @NamedQuery(name = "UnitMeasure.findByUnitMeasureCode", query = "SELECT u FROM UnitMeasure u WHERE u.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "UnitMeasure.findByModifiedDate", query = "SELECT u FROM UnitMeasure u WHERE u.modifiedDate = :modifiedDate")})
public class UnitMeasure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "sizeUnitMeasureCode")
    private Collection<Product> productCollection;
    @OneToMany(mappedBy = "weightUnitMeasureCode")
    private Collection<Product> productCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitMeasureCode")
    private Collection<BillOfMaterials> billOfMaterialsCollection;

    public UnitMeasure() {
    }

    public UnitMeasure(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    public UnitMeasure(String unitMeasureCode, Date modifiedDate) {
        this.unitMeasureCode = unitMeasureCode;
        this.modifiedDate = modifiedDate;
    }

    public String getUnitMeasureCode() {
        return unitMeasureCode;
    }

    public void setUnitMeasureCode(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
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

    @XmlTransient
    public Collection<Product> getProductCollection1() {
        return productCollection1;
    }

    public void setProductCollection1(Collection<Product> productCollection1) {
        this.productCollection1 = productCollection1;
    }

    @XmlTransient
    public Collection<BillOfMaterials> getBillOfMaterialsCollection() {
        return billOfMaterialsCollection;
    }

    public void setBillOfMaterialsCollection(Collection<BillOfMaterials> billOfMaterialsCollection) {
        this.billOfMaterialsCollection = billOfMaterialsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitMeasureCode != null ? unitMeasureCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitMeasure)) {
            return false;
        }
        UnitMeasure other = (UnitMeasure) object;
        if ((this.unitMeasureCode == null && other.unitMeasureCode != null) || (this.unitMeasureCode != null && !this.unitMeasureCode.equals(other.unitMeasureCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.UnitMeasure[ unitMeasureCode=" + unitMeasureCode + " ]";
    }
    
}
