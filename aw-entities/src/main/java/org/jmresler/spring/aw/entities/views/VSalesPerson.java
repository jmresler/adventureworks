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
@Table(name = "vSalesPerson", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VSalesPerson.findAll", query = "SELECT v FROM VSalesPerson v"),
    @NamedQuery(name = "VSalesPerson.findByBusinessEntityID", query = "SELECT v FROM VSalesPerson v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VSalesPerson.findByTitle", query = "SELECT v FROM VSalesPerson v WHERE v.title = :title"),
    @NamedQuery(name = "VSalesPerson.findBySuffix", query = "SELECT v FROM VSalesPerson v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VSalesPerson.findByJobTitle", query = "SELECT v FROM VSalesPerson v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VSalesPerson.findByEmailAddress", query = "SELECT v FROM VSalesPerson v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VSalesPerson.findByEmailPromotion", query = "SELECT v FROM VSalesPerson v WHERE v.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "VSalesPerson.findByAddressLine1", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VSalesPerson.findByAddressLine2", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VSalesPerson.findByCity", query = "SELECT v FROM VSalesPerson v WHERE v.city = :city"),
    @NamedQuery(name = "VSalesPerson.findByPostalCode", query = "SELECT v FROM VSalesPerson v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VSalesPerson.findByTerritoryGroup", query = "SELECT v FROM VSalesPerson v WHERE v.territoryGroup = :territoryGroup"),
    @NamedQuery(name = "VSalesPerson.findBySalesQuota", query = "SELECT v FROM VSalesPerson v WHERE v.salesQuota = :salesQuota"),
    @NamedQuery(name = "VSalesPerson.findBySalesYTD", query = "SELECT v FROM VSalesPerson v WHERE v.salesYTD = :salesYTD"),
    @NamedQuery(name = "VSalesPerson.findBySalesLastYear", query = "SELECT v FROM VSalesPerson v WHERE v.salesLastYear = :salesLastYear")})
public class VSalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Column(name = "Suffix")
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "EmailPromotion")
    private int emailPromotion;
    @Basic(optional = false)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "TerritoryGroup")
    private String territoryGroup;
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Basic(optional = false)
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
