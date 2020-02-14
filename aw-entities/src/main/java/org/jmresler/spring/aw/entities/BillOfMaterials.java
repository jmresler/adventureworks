package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
@Table(name = "BillOfMaterials", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "BillOfMaterials.findAll", query = "SELECT b FROM BillOfMaterials b"),
    @NamedQuery(name = "BillOfMaterials.findByBillOfMaterialsID", query = "SELECT b FROM BillOfMaterials b WHERE b.billOfMaterialsID = :billOfMaterialsID"),
    @NamedQuery(name = "BillOfMaterials.findByStartDate", query = "SELECT b FROM BillOfMaterials b WHERE b.startDate = :startDate"),
    @NamedQuery(name = "BillOfMaterials.findByEndDate", query = "SELECT b FROM BillOfMaterials b WHERE b.endDate = :endDate"),
    @NamedQuery(name = "BillOfMaterials.findByBOMLevel", query = "SELECT b FROM BillOfMaterials b WHERE b.bOMLevel = :bOMLevel"),
    @NamedQuery(name = "BillOfMaterials.findByPerAssemblyQty", query = "SELECT b FROM BillOfMaterials b WHERE b.perAssemblyQty = :perAssemblyQty"),
    @NamedQuery(name = "BillOfMaterials.findByModifiedDate", query = "SELECT b FROM BillOfMaterials b WHERE b.modifiedDate = :modifiedDate")})
public class BillOfMaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BillOfMaterialsID")
    private Integer billOfMaterialsID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "BOMLevel")
    private short bOMLevel;
    @Basic(optional = false)
    @Column(name = "PerAssemblyQty")
    private BigDecimal perAssemblyQty;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductAssemblyID", referencedColumnName = "ProductID")
    @ManyToOne
    private Product productAssemblyID;
    @JoinColumn(name = "ComponentID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product componentID;
    @JoinColumn(name = "UnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne(optional = false)
    private UnitMeasure unitMeasureCode;

    public BillOfMaterials() {
    }

    public BillOfMaterials(Integer billOfMaterialsID) {
        this.billOfMaterialsID = billOfMaterialsID;
    }

    public BillOfMaterials(Integer billOfMaterialsID, Date startDate, short bOMLevel, BigDecimal perAssemblyQty, Date modifiedDate) {
        this.billOfMaterialsID = billOfMaterialsID;
        this.startDate = startDate;
        this.bOMLevel = bOMLevel;
        this.perAssemblyQty = perAssemblyQty;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBillOfMaterialsID() {
        return billOfMaterialsID;
    }

    public void setBillOfMaterialsID(Integer billOfMaterialsID) {
        this.billOfMaterialsID = billOfMaterialsID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public short getBOMLevel() {
        return bOMLevel;
    }

    public void setBOMLevel(short bOMLevel) {
        this.bOMLevel = bOMLevel;
    }

    public BigDecimal getPerAssemblyQty() {
        return perAssemblyQty;
    }

    public void setPerAssemblyQty(BigDecimal perAssemblyQty) {
        this.perAssemblyQty = perAssemblyQty;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Product getProductAssemblyID() {
        return productAssemblyID;
    }

    public void setProductAssemblyID(Product productAssemblyID) {
        this.productAssemblyID = productAssemblyID;
    }

    public Product getComponentID() {
        return componentID;
    }

    public void setComponentID(Product componentID) {
        this.componentID = componentID;
    }

    public UnitMeasure getUnitMeasureCode() {
        return unitMeasureCode;
    }

    public void setUnitMeasureCode(UnitMeasure unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billOfMaterialsID != null ? billOfMaterialsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillOfMaterials)) {
            return false;
        }
        BillOfMaterials other = (BillOfMaterials) object;
        if ((this.billOfMaterialsID == null && other.billOfMaterialsID != null) || (this.billOfMaterialsID != null && !this.billOfMaterialsID.equals(other.billOfMaterialsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.BillOfMaterials[ billOfMaterialsID=" + billOfMaterialsID + " ]";
    }
    
}
