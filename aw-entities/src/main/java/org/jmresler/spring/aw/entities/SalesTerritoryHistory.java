package org.jmresler.spring.aw.entities;

import java.io.Serializable;
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "SalesTerritoryHistory", catalog = "AdventureWorks2017", schema = "Sales")

@NamedQueries({
    @NamedQuery(name = "SalesTerritoryHistory.findAll", query = "SELECT s FROM SalesTerritoryHistory s"),
    @NamedQuery(name = "SalesTerritoryHistory.findByBusinessEntityID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesTerritoryHistory.findByTerritoryID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.territoryID = :territoryID"),
    @NamedQuery(name = "SalesTerritoryHistory.findByStartDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "SalesTerritoryHistory.findByEndDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SalesTerritoryHistory.findByRowguid", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTerritoryHistory.findByModifiedDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritoryHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SalesTerritoryHistoryPK salesTerritoryHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesPerson salesPerson;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesTerritory salesTerritory;

    public SalesTerritoryHistory() {
    }

    public SalesTerritoryHistory(SalesTerritoryHistoryPK salesTerritoryHistoryPK) {
        this.salesTerritoryHistoryPK = salesTerritoryHistoryPK;
    }

    public SalesTerritoryHistory(SalesTerritoryHistoryPK salesTerritoryHistoryPK, String rowguid, Date modifiedDate) {
        this.salesTerritoryHistoryPK = salesTerritoryHistoryPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public SalesTerritoryHistory(int businessEntityID, int territoryID, Date startDate) {
        this.salesTerritoryHistoryPK = new SalesTerritoryHistoryPK(businessEntityID, territoryID, startDate);
    }

    public SalesTerritoryHistoryPK getSalesTerritoryHistoryPK() {
        return salesTerritoryHistoryPK;
    }

    public void setSalesTerritoryHistoryPK(SalesTerritoryHistoryPK salesTerritoryHistoryPK) {
        this.salesTerritoryHistoryPK = salesTerritoryHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public SalesTerritory getSalesTerritory() {
        return salesTerritory;
    }

    public void setSalesTerritory(SalesTerritory salesTerritory) {
        this.salesTerritory = salesTerritory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesTerritoryHistoryPK != null ? salesTerritoryHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesTerritoryHistory)) {
            return false;
        }
        SalesTerritoryHistory other = (SalesTerritoryHistory) object;
        if ((this.salesTerritoryHistoryPK == null && other.salesTerritoryHistoryPK != null) || (this.salesTerritoryHistoryPK != null && !this.salesTerritoryHistoryPK.equals(other.salesTerritoryHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesTerritoryHistory[ salesTerritoryHistoryPK=" + salesTerritoryHistoryPK + " ]";
    }
    
}
