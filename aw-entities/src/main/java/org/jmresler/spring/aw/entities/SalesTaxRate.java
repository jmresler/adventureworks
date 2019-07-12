/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "SalesTaxRate", catalog = "AdventureWorks2017", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesTaxRate.findAll", query = "SELECT s FROM SalesTaxRate s"),
    @NamedQuery(name = "SalesTaxRate.findBySalesTaxRateID", query = "SELECT s FROM SalesTaxRate s WHERE s.salesTaxRateID = :salesTaxRateID"),
    @NamedQuery(name = "SalesTaxRate.findByStateProvinceID", query = "SELECT s FROM SalesTaxRate s WHERE s.stateProvinceID = :stateProvinceID"),
    @NamedQuery(name = "SalesTaxRate.findByTaxType", query = "SELECT s FROM SalesTaxRate s WHERE s.taxType = :taxType"),
    @NamedQuery(name = "SalesTaxRate.findByTaxRate", query = "SELECT s FROM SalesTaxRate s WHERE s.taxRate = :taxRate"),
    @NamedQuery(name = "SalesTaxRate.findByRowguid", query = "SELECT s FROM SalesTaxRate s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTaxRate.findByModifiedDate", query = "SELECT s FROM SalesTaxRate s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTaxRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SalesTaxRateID")
    private Integer salesTaxRateID;
    @Basic(optional = false)
    @Column(name = "StateProvinceID")
    private int stateProvinceID;
    @Basic(optional = false)
    @Column(name = "TaxType")
    private short taxType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TaxRate")
    private BigDecimal taxRate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public SalesTaxRate() {
    }

    public SalesTaxRate(Integer salesTaxRateID) {
        this.salesTaxRateID = salesTaxRateID;
    }

    public SalesTaxRate(Integer salesTaxRateID, int stateProvinceID, short taxType, BigDecimal taxRate, String rowguid, Date modifiedDate) {
        this.salesTaxRateID = salesTaxRateID;
        this.stateProvinceID = stateProvinceID;
        this.taxType = taxType;
        this.taxRate = taxRate;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getSalesTaxRateID() {
        return salesTaxRateID;
    }

    public void setSalesTaxRateID(Integer salesTaxRateID) {
        this.salesTaxRateID = salesTaxRateID;
    }

    public int getStateProvinceID() {
        return stateProvinceID;
    }

    public void setStateProvinceID(int stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }

    public short getTaxType() {
        return taxType;
    }

    public void setTaxType(short taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesTaxRateID != null ? salesTaxRateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesTaxRate)) {
            return false;
        }
        SalesTaxRate other = (SalesTaxRate) object;
        if ((this.salesTaxRateID == null && other.salesTaxRateID != null) || (this.salesTaxRateID != null && !this.salesTaxRateID.equals(other.salesTaxRateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesTaxRate[ salesTaxRateID=" + salesTaxRateID + " ]";
    }
    
}
