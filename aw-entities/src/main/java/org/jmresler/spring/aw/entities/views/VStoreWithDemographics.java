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
@Table(name = "vStoreWithDemographics", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VStoreWithDemographics.findAll", query = "SELECT v FROM VStoreWithDemographics v"),
    @NamedQuery(name = "VStoreWithDemographics.findByBusinessEntityID", query = "SELECT v FROM VStoreWithDemographics v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VStoreWithDemographics.findByAnnualSales", query = "SELECT v FROM VStoreWithDemographics v WHERE v.annualSales = :annualSales"),
    @NamedQuery(name = "VStoreWithDemographics.findByAnnualRevenue", query = "SELECT v FROM VStoreWithDemographics v WHERE v.annualRevenue = :annualRevenue"),
    @NamedQuery(name = "VStoreWithDemographics.findByBankName", query = "SELECT v FROM VStoreWithDemographics v WHERE v.bankName = :bankName"),
    @NamedQuery(name = "VStoreWithDemographics.findByBusinessType", query = "SELECT v FROM VStoreWithDemographics v WHERE v.businessType = :businessType"),
    @NamedQuery(name = "VStoreWithDemographics.findByYearOpened", query = "SELECT v FROM VStoreWithDemographics v WHERE v.yearOpened = :yearOpened"),
    @NamedQuery(name = "VStoreWithDemographics.findBySpecialty", query = "SELECT v FROM VStoreWithDemographics v WHERE v.specialty = :specialty"),
    @NamedQuery(name = "VStoreWithDemographics.findBySquareFeet", query = "SELECT v FROM VStoreWithDemographics v WHERE v.squareFeet = :squareFeet"),
    @NamedQuery(name = "VStoreWithDemographics.findByBrands", query = "SELECT v FROM VStoreWithDemographics v WHERE v.brands = :brands"),
    @NamedQuery(name = "VStoreWithDemographics.findByInternet", query = "SELECT v FROM VStoreWithDemographics v WHERE v.internet = :internet"),
    @NamedQuery(name = "VStoreWithDemographics.findByNumberEmployees", query = "SELECT v FROM VStoreWithDemographics v WHERE v.numberEmployees = :numberEmployees")})
public class VStoreWithDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "AnnualSales")
    private BigDecimal annualSales;
    @Column(name = "AnnualRevenue")
    private BigDecimal annualRevenue;
    @Column(name = "BankName")
    private String bankName;
    @Column(name = "BusinessType")
    private String businessType;
    @Column(name = "YearOpened")
    private Integer yearOpened;
    @Column(name = "Specialty")
    private String specialty;
    @Column(name = "SquareFeet")
    private Integer squareFeet;
    @Column(name = "Brands")
    private String brands;
    @Column(name = "Internet")
    private String internet;
    @Column(name = "NumberEmployees")
    private Integer numberEmployees;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
