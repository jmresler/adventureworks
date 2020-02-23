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

    public VStoreWithDemographics() {
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public BigDecimal getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(BigDecimal annualSales) {
        this.annualSales = annualSales;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(Integer yearOpened) {
        this.yearOpened = yearOpened;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

	@Override
	public int hashCode() {
		return Objects.hash(annualRevenue, annualSales, bankName, brands, businessEntityID, businessType, internet,
				numberEmployees, specialty, squareFeet, yearOpened);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VStoreWithDemographics other = (VStoreWithDemographics) obj;
		return Objects.equals(annualRevenue, other.annualRevenue) && Objects.equals(annualSales, other.annualSales)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(brands, other.brands)
				&& businessEntityID == other.businessEntityID && Objects.equals(businessType, other.businessType)
				&& Objects.equals(internet, other.internet) && Objects.equals(numberEmployees, other.numberEmployees)
				&& Objects.equals(specialty, other.specialty) && Objects.equals(squareFeet, other.squareFeet)
				&& Objects.equals(yearOpened, other.yearOpened);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VStoreWithDemographics [businessEntityID=")
				.append(businessEntityID)
				.append(", annualSales=")
				.append(annualSales)
				.append(", annualRevenue=")
				.append(annualRevenue)
				.append(", bankName=")
				.append(bankName)
				.append(", businessType=")
				.append(businessType)
				.append(", yearOpened=")
				.append(yearOpened)
				.append(", specialty=")
				.append(specialty)
				.append(", squareFeet=")
				.append(squareFeet)
				.append(", brands=")
				.append(brands)
				.append(", internet=")
				.append(internet)
				.append(", numberEmployees=")
				.append(numberEmployees)
				.append("]");
		return builder.toString();
	}
    
    
    
}
