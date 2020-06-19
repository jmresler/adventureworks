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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employee", catalog = "AdventureWorks2017", schema = "HumanResources")
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

    private static final long serialVersionUID = 1L;
	
    @Lob
    @Column(name = "OrganizationNode", columnDefinition = "HIERARCHYID")
    private byte[] organizationNode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "NationalIDNumber", columnDefinition = "NVARCHAR(15) NOT NULL")
    private String nationalIDNumber;
    @Basic(optional = false)
    @Column(name = "LoginID", columnDefinition = "NVARCHAR(256) NOT NULL")
    private String loginID;
    @Column(name = "OrganizationLevel")
    private Short organizationLevel;
    @Basic(optional = false)
    @Column(name = "JobTitle", columnDefinition = "NVARCHAR(50) NOT NULL")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "MaritalStatus", columnDefinition = "NCHAR(1) NOT NULL")
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "Gender", columnDefinition = "NCHAR(1) NOT NULL")
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
    @Column(name = "rowguid", columnDefinition = "UNIQUEIDENTIFIER")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}    
}
