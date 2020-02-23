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
public class EmployeeDepartmentHistoryPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private short departmentID;
    @Basic(optional = false)
    @Column(name = "ShiftID")
    private short shiftID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public EmployeeDepartmentHistoryPK() {
    }

    public EmployeeDepartmentHistoryPK(int businessEntityID, short departmentID, short shiftID, Date startDate) {
        this.businessEntityID = businessEntityID;
        this.departmentID = departmentID;
        this.shiftID = shiftID;
        this.startDate = startDate;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentID) {
        this.departmentID = departmentID;
    }

    public short getShiftID() {
        return shiftID;
    }

    public void setShiftID(short shiftID) {
        this.shiftID = shiftID;
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
        hash += (int) departmentID;
        hash += (int) shiftID;
        hash += (startDate != null ? startDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDepartmentHistoryPK)) {
            return false;
        }
        EmployeeDepartmentHistoryPK other = (EmployeeDepartmentHistoryPK) object;
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        if (this.departmentID != other.departmentID) {
            return false;
        }
        if (this.shiftID != other.shiftID) {
            return false;
        }
        if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.EmployeeDepartmentHistoryPK[ businessEntityID=" + businessEntityID + ", departmentID=" + departmentID + ", shiftID=" + shiftID + ", startDate=" + startDate + " ]";
    }
    
}
