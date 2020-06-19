package org.jmresler.spring.aw.entities.views;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
