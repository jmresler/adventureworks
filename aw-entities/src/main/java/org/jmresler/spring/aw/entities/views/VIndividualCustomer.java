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
@Table(name = "vIndividualCustomer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VIndividualCustomer.findAll", query = "SELECT v FROM VIndividualCustomer v"),
    @NamedQuery(name = "VIndividualCustomer.findByBusinessEntityID", query = "SELECT v FROM VIndividualCustomer v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VIndividualCustomer.findByTitle", query = "SELECT v FROM VIndividualCustomer v WHERE v.title = :title"),
    @NamedQuery(name = "VIndividualCustomer.findBySuffix", query = "SELECT v FROM VIndividualCustomer v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VIndividualCustomer.findByEmailAddress", query = "SELECT v FROM VIndividualCustomer v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VIndividualCustomer.findByEmailPromotion", query = "SELECT v FROM VIndividualCustomer v WHERE v.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "VIndividualCustomer.findByAddressLine1", query = "SELECT v FROM VIndividualCustomer v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VIndividualCustomer.findByAddressLine2", query = "SELECT v FROM VIndividualCustomer v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VIndividualCustomer.findByCity", query = "SELECT v FROM VIndividualCustomer v WHERE v.city = :city"),
    @NamedQuery(name = "VIndividualCustomer.findByPostalCode", query = "SELECT v FROM VIndividualCustomer v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VIndividualCustomer.findByDemographics", query = "SELECT v FROM VIndividualCustomer v WHERE v.demographics = :demographics")})
public class VIndividualCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Column(name = "Suffix")
    private String suffix;
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
    @Column(name = "Demographics")
    private String demographics;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
