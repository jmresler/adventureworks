package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author John
 */
@Entity
@Table(name = "vSalesPersonSalesByFiscalYears", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findAll", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findBySalesPersonID", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.salesPersonID = :salesPersonID"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByFullName", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByJobTitle", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a = :a"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA1", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a1 = :a1"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA2", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a2 = :a2")})
public class VSalesPersonSalesByFiscalYears implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "SalesPersonID")
    private Integer salesPersonID;
    @Column(name = "FullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "2002")
    private BigDecimal a;
    @Column(name = "2003")
    private BigDecimal a1;
    @Column(name = "2004")
    private BigDecimal a2;

    public VSalesPersonSalesByFiscalYears() {
    }

    public Integer getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(Integer salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getA1() {
        return a1;
    }

    public void setA1(BigDecimal a1) {
        this.a1 = a1;
    }

    public BigDecimal getA2() {
        return a2;
    }

    public void setA2(BigDecimal a2) {
        this.a2 = a2;
    }

	@Override
	public int hashCode() {
		return Objects.hash(a, a1, a2, fullName, jobTitle, salesPersonID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VSalesPersonSalesByFiscalYears other = (VSalesPersonSalesByFiscalYears) obj;
		return Objects.equals(a, other.a) && Objects.equals(a1, other.a1) && Objects.equals(a2, other.a2)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(jobTitle, other.jobTitle)
				&& Objects.equals(salesPersonID, other.salesPersonID);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VSalesPersonSalesByFiscalYears [salesPersonID=")
				.append(salesPersonID)
				.append(", fullName=")
				.append(fullName)
				.append(", jobTitle=")
				.append(jobTitle)
				.append(", a=")
				.append(a)
				.append(", a1=")
				.append(a1)
				.append(", a2=")
				.append(a2)
				.append("]");
		return builder.toString();
	}
    
    
}
