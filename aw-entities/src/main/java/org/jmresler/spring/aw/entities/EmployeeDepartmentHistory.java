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
@Table(name = "EmployeeDepartmentHistory", catalog = "AdventureWorks2017", schema = "HumanResources")

@NamedQueries({
    @NamedQuery(name = "EmployeeDepartmentHistory.findAll", query = "SELECT e FROM EmployeeDepartmentHistory e"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByBusinessEntityID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByDepartmentID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.departmentID = :departmentID"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByShiftID", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.shiftID = :shiftID"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByStartDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.employeeDepartmentHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByEndDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.endDate = :endDate"),
    @NamedQuery(name = "EmployeeDepartmentHistory.findByModifiedDate", query = "SELECT e FROM EmployeeDepartmentHistory e WHERE e.modifiedDate = :modifiedDate")})
public class EmployeeDepartmentHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "ShiftID", referencedColumnName = "ShiftID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Shift shift;

    public EmployeeDepartmentHistory() {
    }

    public EmployeeDepartmentHistory(EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK) {
        this.employeeDepartmentHistoryPK = employeeDepartmentHistoryPK;
    }

    public EmployeeDepartmentHistory(EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK, Date modifiedDate) {
        this.employeeDepartmentHistoryPK = employeeDepartmentHistoryPK;
        this.modifiedDate = modifiedDate;
    }

    public EmployeeDepartmentHistory(int businessEntityID, short departmentID, short shiftID, Date startDate) {
        this.employeeDepartmentHistoryPK = new EmployeeDepartmentHistoryPK(businessEntityID, departmentID, shiftID, startDate);
    }

    public EmployeeDepartmentHistoryPK getEmployeeDepartmentHistoryPK() {
        return employeeDepartmentHistoryPK;
    }

    public void setEmployeeDepartmentHistoryPK(EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK) {
        this.employeeDepartmentHistoryPK = employeeDepartmentHistoryPK;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeDepartmentHistoryPK != null ? employeeDepartmentHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDepartmentHistory)) {
            return false;
        }
        EmployeeDepartmentHistory other = (EmployeeDepartmentHistory) object;
        if ((this.employeeDepartmentHistoryPK == null && other.employeeDepartmentHistoryPK != null) || (this.employeeDepartmentHistoryPK != null && !this.employeeDepartmentHistoryPK.equals(other.employeeDepartmentHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.EmployeeDepartmentHistory[ employeeDepartmentHistoryPK=" + employeeDepartmentHistoryPK + " ]";
    }
    
}
