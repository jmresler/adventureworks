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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
