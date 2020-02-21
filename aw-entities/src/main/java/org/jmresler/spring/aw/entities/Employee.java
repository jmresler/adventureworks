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
import javax.persistence.Lob;
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
@Table(name = "Employee", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByBusinessEntityID", query = "SELECT e FROM Employee e WHERE e.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Employee.findByNationalIDNumber", query = "SELECT e FROM Employee e WHERE e.nationalIDNumber = :nationalIDNumber"),
    @NamedQuery(name = "Employee.findByLoginID", query = "SELECT e FROM Employee e WHERE e.loginID = :loginID"),
    @NamedQuery(name = "Employee.findByOrganizationLevel", query = "SELECT e FROM Employee e WHERE e.organizationLevel = :organizationLevel"),
    @NamedQuery(name = "Employee.findByJobTitle", query = "SELECT e FROM Employee e WHERE e.jobTitle = :jobTitle"),
    @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employee.findByMaritalStatus", query = "SELECT e FROM Employee e WHERE e.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate"),
    @NamedQuery(name = "Employee.findByVacationHours", query = "SELECT e FROM Employee e WHERE e.vacationHours = :vacationHours"),
    @NamedQuery(name = "Employee.findBySickLeaveHours", query = "SELECT e FROM Employee e WHERE e.sickLeaveHours = :sickLeaveHours"),
    @NamedQuery(name = "Employee.findByRowguid", query = "SELECT e FROM Employee e WHERE e.rowguid = :rowguid"),
    @NamedQuery(name = "Employee.findByModifiedDate", query = "SELECT e FROM Employee e WHERE e.modifiedDate = :modifiedDate")})
public class Employee implements Serializable {

    @Lob
    @Column(name = "OrganizationNode")
    private byte[] organizationNode;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "NationalIDNumber")
    private String nationalIDNumber;
    @Basic(optional = false)
    @Column(name = "LoginID")
    private String loginID;
    @Column(name = "OrganizationLevel")
    private Short organizationLevel;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "MaritalStatus")
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "HireDate")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Basic(optional = false)
    @Column(name = "VacationHours")
    private short vacationHours;
    @Basic(optional = false)
    @Column(name = "SickLeaveHours")
    private short sickLeaveHours;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeePayHistory> employeePayHistoryCollection;
    @OneToMany(mappedBy = "businessEntityID")
    private Collection<JobCandidate> jobCandidateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    public Employee() {
    }

    public Employee(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public Employee(Integer businessEntityID, String nationalIDNumber, String loginID, String jobTitle, Date birthDate, String maritalStatus, String gender, Date hireDate, short vacationHours, short sickLeaveHours, String rowguid, Date modifiedDate) {
        this.businessEntityID = businessEntityID;
        this.nationalIDNumber = nationalIDNumber;
        this.loginID = loginID;
        this.jobTitle = jobTitle;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.hireDate = hireDate;
        this.vacationHours = vacationHours;
        this.sickLeaveHours = sickLeaveHours;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }


    public Short getOrganizationLevel() {
        return organizationLevel;
    }

    public void setOrganizationLevel(Short organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public short getVacationHours() {
        return vacationHours;
    }

    public void setVacationHours(short vacationHours) {
        this.vacationHours = vacationHours;
    }

    public short getSickLeaveHours() {
        return sickLeaveHours;
    }

    public void setSickLeaveHours(short sickLeaveHours) {
        this.sickLeaveHours = sickLeaveHours;
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

    @XmlTransient
    public Collection<EmployeePayHistory> getEmployeePayHistoryCollection() {
        return employeePayHistoryCollection;
    }

    public void setEmployeePayHistoryCollection(Collection<EmployeePayHistory> employeePayHistoryCollection) {
        this.employeePayHistoryCollection = employeePayHistoryCollection;
    }

    @XmlTransient
    public Collection<JobCandidate> getJobCandidateCollection() {
        return jobCandidateCollection;
    }

    public void setJobCandidateCollection(Collection<JobCandidate> jobCandidateCollection) {
        this.jobCandidateCollection = jobCandidateCollection;
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
        hash += (businessEntityID != null ? businessEntityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.businessEntityID == null && other.businessEntityID != null) || (this.businessEntityID != null && !this.businessEntityID.equals(other.businessEntityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Employee[ businessEntityID=" + businessEntityID + " ]";
    }

    public byte[] getOrganizationNode() {
        return organizationNode;
    }

    public void setOrganizationNode(byte[] organizationNode) {
        this.organizationNode = organizationNode;
    }
    
}
