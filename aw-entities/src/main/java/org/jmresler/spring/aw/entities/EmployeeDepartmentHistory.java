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
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "EmployeeDepartmentHistory", schema = "HumanResources")
@XmlRootElement
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
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "ShiftID", referencedColumnName = "ShiftID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Shift shift;

    public EmployeeDepartmentHistory(EmployeeDepartmentHistoryPK employeeDepartmentHistoryPK) {
        this.employeeDepartmentHistoryPK = employeeDepartmentHistoryPK;
    }    
}
