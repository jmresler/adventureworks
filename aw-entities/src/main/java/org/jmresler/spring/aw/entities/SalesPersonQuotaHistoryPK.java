/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Embeddable
public class SalesPersonQuotaHistoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "QuotaDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date quotaDate;

    public SalesPersonQuotaHistoryPK() {
    }

    public SalesPersonQuotaHistoryPK(int businessEntityID, Date quotaDate) {
        this.businessEntityID = businessEntityID;
        this.quotaDate = quotaDate;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public Date getQuotaDate() {
        return quotaDate;
    }

    public void setQuotaDate(Date quotaDate) {
        this.quotaDate = quotaDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (quotaDate != null ? quotaDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesPersonQuotaHistoryPK)) {
            return false;
        }
        SalesPersonQuotaHistoryPK other = (SalesPersonQuotaHistoryPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if ((this.quotaDate == null && other.quotaDate != null) || (this.quotaDate != null && !this.quotaDate.equals(other.quotaDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesPersonQuotaHistoryPK[ businessEntityID=" + businessEntityID + ", quotaDate=" + quotaDate + " ]";
    }
    
}
