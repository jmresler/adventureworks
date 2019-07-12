/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "Shift", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s"),
    @NamedQuery(name = "Shift.findByShiftID", query = "SELECT s FROM Shift s WHERE s.shiftID = :shiftID"),
    @NamedQuery(name = "Shift.findByStartTime", query = "SELECT s FROM Shift s WHERE s.startTime = :startTime"),
    @NamedQuery(name = "Shift.findByEndTime", query = "SELECT s FROM Shift s WHERE s.endTime = :endTime"),
    @NamedQuery(name = "Shift.findByModifiedDate", query = "SELECT s FROM Shift s WHERE s.modifiedDate = :modifiedDate")})
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShiftID")
    private Short shiftID;
    @Basic(optional = false)
    @Column(name = "StartTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "EndTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shift")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    public Shift() {
    }

    public Shift(Short shiftID) {
        this.shiftID = shiftID;
    }

    public Shift(Short shiftID, Date startTime, Date endTime, Date modifiedDate) {
        this.shiftID = shiftID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modifiedDate = modifiedDate;
    }

    public Short getShiftID() {
        return shiftID;
    }

    public void setShiftID(Short shiftID) {
        this.shiftID = shiftID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<EmployeeDepartmentHistory> getEmployeeDepartmentHistoryCollection() {
        return employeeDepartmentHistoryCollection;
    }

    public void setEmployeeDepartmentHistoryCollection(Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection) {
        this.employeeDepartmentHistoryCollection = employeeDepartmentHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftID != null ? shiftID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.shiftID == null && other.shiftID != null) || (this.shiftID != null && !this.shiftID.equals(other.shiftID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Shift[ shiftID=" + shiftID + " ]";
    }
    
}
