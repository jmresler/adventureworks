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
@Table(name = "Department", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentID", query = "SELECT d FROM Department d WHERE d.departmentID = :departmentID"),
    @NamedQuery(name = "Department.findByModifiedDate", query = "SELECT d FROM Department d WHERE d.modifiedDate = :modifiedDate")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private Short departmentID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    public Department() {
    }

    public Department(Short departmentID) {
        this.departmentID = departmentID;
    }

    public Department(Short departmentID, Date modifiedDate) {
        this.departmentID = departmentID;
        this.modifiedDate = modifiedDate;
    }

    public Short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Short departmentID) {
        this.departmentID = departmentID;
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
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Department[ departmentID=" + departmentID + " ]";
    }
    
}
