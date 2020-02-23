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

/**
 *
 * @author John
 */
@Entity
@Table(name = "EmployeePayHistory", catalog = "AdventureWorks2017", schema = "HumanResources")

@NamedQueries({
    @NamedQuery(name = "EmployeePayHistory.findAll", query = "SELECT e FROM EmployeePayHistory e"),
    @NamedQuery(name = "EmployeePayHistory.findByBusinessEntityID", query = "SELECT e FROM EmployeePayHistory e WHERE e.employeePayHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "EmployeePayHistory.findByRateChangeDate", query = "SELECT e FROM EmployeePayHistory e WHERE e.employeePayHistoryPK.rateChangeDate = :rateChangeDate"),
    @NamedQuery(name = "EmployeePayHistory.findByRate", query = "SELECT e FROM EmployeePayHistory e WHERE e.rate = :rate"),
    @NamedQuery(name = "EmployeePayHistory.findByPayFrequency", query = "SELECT e FROM EmployeePayHistory e WHERE e.payFrequency = :payFrequency"),
    @NamedQuery(name = "EmployeePayHistory.findByModifiedDate", query = "SELECT e FROM EmployeePayHistory e WHERE e.modifiedDate = :modifiedDate")})
public class EmployeePayHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmployeePayHistoryPK employeePayHistoryPK;
    @Basic(optional = false)
    @Column(name = "Rate")
    private BigDecimal rate;
    @Basic(optional = false)
    @Column(name = "PayFrequency")
    private short payFrequency;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public EmployeePayHistory() {
    }

    public EmployeePayHistory(EmployeePayHistoryPK employeePayHistoryPK) {
        this.employeePayHistoryPK = employeePayHistoryPK;
    }

    public EmployeePayHistory(EmployeePayHistoryPK employeePayHistoryPK, BigDecimal rate, short payFrequency, Date modifiedDate) {
        this.employeePayHistoryPK = employeePayHistoryPK;
        this.rate = rate;
        this.payFrequency = payFrequency;
        this.modifiedDate = modifiedDate;
    }

    public EmployeePayHistory(int businessEntityID, Date rateChangeDate) {
        this.employeePayHistoryPK = new EmployeePayHistoryPK(businessEntityID, rateChangeDate);
    }

    public EmployeePayHistoryPK getEmployeePayHistoryPK() {
        return employeePayHistoryPK;
    }

    public void setEmployeePayHistoryPK(EmployeePayHistoryPK employeePayHistoryPK) {
        this.employeePayHistoryPK = employeePayHistoryPK;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public short getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(short payFrequency) {
        this.payFrequency = payFrequency;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeePayHistoryPK != null ? employeePayHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeePayHistory)) {
            return false;
        }
        EmployeePayHistory other = (EmployeePayHistory) object;
        if ((this.employeePayHistoryPK == null && other.employeePayHistoryPK != null) || (this.employeePayHistoryPK != null && !this.employeePayHistoryPK.equals(other.employeePayHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.EmployeePayHistory[ employeePayHistoryPK=" + employeePayHistoryPK + " ]";
    }
    
}
