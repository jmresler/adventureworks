package org.jmresler.spring.aw.entities.views;

import java.io.Serializable;

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
@Table(name = "vEmployee", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
    @NamedQuery(name = "VEmployee.findAll", query = "SELECT v FROM VEmployee v"),
    @NamedQuery(name = "VEmployee.findByBusinessEntityID", query = "SELECT v FROM VEmployee v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VEmployee.findByTitle", query = "SELECT v FROM VEmployee v WHERE v.title = :title"),
    @NamedQuery(name = "VEmployee.findBySuffix", query = "SELECT v FROM VEmployee v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VEmployee.findByJobTitle", query = "SELECT v FROM VEmployee v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VEmployee.findByEmailAddress", query = "SELECT v FROM VEmployee v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VEmployee.findByEmailPromotion", query = "SELECT v FROM VEmployee v WHERE v.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "VEmployee.findByAddressLine1", query = "SELECT v FROM VEmployee v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VEmployee.findByAddressLine2", query = "SELECT v FROM VEmployee v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VEmployee.findByCity", query = "SELECT v FROM VEmployee v WHERE v.city = :city"),
    @NamedQuery(name = "VEmployee.findByPostalCode", query = "SELECT v FROM VEmployee v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VEmployee.findByAdditionalContactInfo", query = "SELECT v FROM VEmployee v WHERE v.additionalContactInfo = :additionalContactInfo")})
public class VEmployee implements Serializable {

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
    @Column(name = "AdditionalContactInfo")
    private String additionalContactInfo;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
