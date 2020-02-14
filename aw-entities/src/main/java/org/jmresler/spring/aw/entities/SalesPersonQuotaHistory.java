package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "SalesPersonQuotaHistory", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SalesPersonQuotaHistory.findAll", query = "SELECT s FROM SalesPersonQuotaHistory s"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByBusinessEntityID", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByQuotaDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.quotaDate = :quotaDate"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findBySalesQuota", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesQuota = :salesQuota"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByRowguid", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByModifiedDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPersonQuotaHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK;
    @Basic(optional = false)
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
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

    public SalesPersonQuotaHistory() {
    }

    public SalesPersonQuotaHistory(SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK) {
        this.salesPersonQuotaHistoryPK = salesPersonQuotaHistoryPK;
    }

    public SalesPersonQuotaHistory(SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK, BigDecimal salesQuota, String rowguid, Date modifiedDate) {
        this.salesPersonQuotaHistoryPK = salesPersonQuotaHistoryPK;
        this.salesQuota = salesQuota;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public SalesPersonQuotaHistory(int businessEntityID, Date quotaDate) {
        this.salesPersonQuotaHistoryPK = new SalesPersonQuotaHistoryPK(businessEntityID, quotaDate);
    }

    public SalesPersonQuotaHistoryPK getSalesPersonQuotaHistoryPK() {
        return salesPersonQuotaHistoryPK;
    }

    public void setSalesPersonQuotaHistoryPK(SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK) {
        this.salesPersonQuotaHistoryPK = salesPersonQuotaHistoryPK;
    }

    public BigDecimal getSalesQuota() {
        return salesQuota;
    }

    public void setSalesQuota(BigDecimal salesQuota) {
        this.salesQuota = salesQuota;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesPersonQuotaHistoryPK != null ? salesPersonQuotaHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesPersonQuotaHistory)) {
            return false;
        }
        SalesPersonQuotaHistory other = (SalesPersonQuotaHistory) object;
        if ((this.salesPersonQuotaHistoryPK == null && other.salesPersonQuotaHistoryPK != null) || (this.salesPersonQuotaHistoryPK != null && !this.salesPersonQuotaHistoryPK.equals(other.salesPersonQuotaHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesPersonQuotaHistory[ salesPersonQuotaHistoryPK=" + salesPersonQuotaHistoryPK + " ]";
    }
    
}
