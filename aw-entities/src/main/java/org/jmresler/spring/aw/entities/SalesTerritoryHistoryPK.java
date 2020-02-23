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
public class SalesTerritoryHistoryPK implements Serializable {

	private static final long serialVersionUID = -4465219691155440237L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private int territoryID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    public SalesTerritoryHistoryPK() {
    }

    public SalesTerritoryHistoryPK(int businessEntityID, int territoryID, Date startDate) {
        this.businessEntityID = businessEntityID;
        this.territoryID = territoryID;
        this.startDate = startDate;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public int getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessEntityID;
        hash += (int) territoryID;
        hash += (startDate != null ? startDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesTerritoryHistoryPK)) {
            return false;
        }
        SalesTerritoryHistoryPK other = (SalesTerritoryHistoryPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if (this.territoryID != other.territoryID) {
            return false;
        }
        if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesTerritoryHistoryPK[ businessEntityID=" + businessEntityID + ", territoryID=" + territoryID + ", startDate=" + startDate + " ]";
    }
    
}
