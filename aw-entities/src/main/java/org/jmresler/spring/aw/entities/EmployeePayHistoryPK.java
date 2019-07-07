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
public class EmployeePayHistoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "RateChangeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rateChangeDate;

    public EmployeePayHistoryPK() {
    }

    public EmployeePayHistoryPK(int businessEntityID, Date rateChangeDate) {
        this.businessEntityID = businessEntityID;
        this.rateChangeDate = rateChangeDate;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public Date getRateChangeDate() {
        return rateChangeDate;
    }

    public void setRateChangeDate(Date rateChangeDate) {
        this.rateChangeDate = rateChangeDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (rateChangeDate != null ? rateChangeDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeePayHistoryPK)) {
            return false;
        }
        EmployeePayHistoryPK other = (EmployeePayHistoryPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if ((this.rateChangeDate == null && other.rateChangeDate != null) || (this.rateChangeDate != null && !this.rateChangeDate.equals(other.rateChangeDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.EmployeePayHistoryPK[ businessEntityID=" + businessEntityID + ", rateChangeDate=" + rateChangeDate + " ]";
    }
    
}
