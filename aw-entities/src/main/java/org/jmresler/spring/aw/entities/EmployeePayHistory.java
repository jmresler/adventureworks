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
@Table(name = "EmployeePayHistory", schema = "HumanResources")
@XmlRootElement
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Rate", nullable = false, precision = 19, scale = 4)
    private BigDecimal rate;
    @Basic(optional = false)
    @Column(name = "PayFrequency", nullable = false)
    private short payFrequency;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public EmployeePayHistory(EmployeePayHistoryPK employeePayHistoryPK) {
        this.employeePayHistoryPK = employeePayHistoryPK;
    }    
}
