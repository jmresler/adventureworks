package org.jmresler.spring.aw.entities;

import java.io.Serializable;
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

    public VIndividualCustomer() {
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getEmailPromotion() {
        return emailPromotion;
    }

    public void setEmailPromotion(int emailPromotion) {
        this.emailPromotion = emailPromotion;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDemographics() {
        return demographics;
    }

    public void setDemographics(String demographics) {
        this.demographics = demographics;
    }

	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, businessEntityID, city, emailAddress,
				emailPromotion, postalCode, suffix, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VIndividualCustomer other = (VIndividualCustomer) obj;
		return Objects.equals(addressLine1, other.addressLine1) 
						&& Objects.equals(addressLine2, other.addressLine2)
						&& businessEntityID == other.businessEntityID 
						&& Objects.equals(city, other.city)
						&& Objects.equals(emailAddress, other.emailAddress)
						&& emailPromotion == other.emailPromotion 
						&& Objects.equals(postalCode, other.postalCode)
						&& Objects.equals(suffix, other.suffix) 
						&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VIndividualCustomer [businessEntityID=")
				.append(businessEntityID)
				.append(", title=")
				.append(title)
				.append(", suffix=")
				.append(suffix)
				.append(", emailAddress=")
				.append(emailAddress)
				.append(", emailPromotion=")
				.append(emailPromotion)
				.append(", addressLine1=")
				.append(addressLine1)
				.append(", addressLine2=")
				.append(addressLine2)
				.append(", city=")
				.append(city)
				.append(", postalCode=")
				.append(postalCode)
				.append("]");
		return builder.toString();
	}
    
    
}
