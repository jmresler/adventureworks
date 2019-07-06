package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Employee", schema = "HumanResources", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"LoginID"}),
    @UniqueConstraint(columnNames = {"NationalIDNumber"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
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

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "NationalIDNumber", nullable = false, length = 15)
    private String nationalIDNumber;
    @Basic(optional = false)
    @Column(name = "LoginID", nullable = false, length = 256)
    private String loginID;
    @Lob
    @Column(name = "OrganizationNode")
    private byte[] organizationNode;
    @Column(name = "OrganizationLevel")
    private Short organizationLevel;
    @Basic(optional = false)
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "BirthDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "MaritalStatus", nullable = false, length = 1)
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "Gender", nullable = false, length = 1)
    private String gender;
    @Basic(optional = false)
    @Column(name = "HireDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Basic(optional = false)
    @Column(name = "VacationHours", nullable = false)
    private short vacationHours;
    @Basic(optional = false)
    @Column(name = "SickLeaveHours", nullable = false)
    private short sickLeaveHours;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeePayHistory> employeePayHistoryCollection;
    @XmlTransient
    @OneToMany(mappedBy = "businessEntityID")
    private Collection<JobCandidate> jobCandidateCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    public Employee(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    } 
}
