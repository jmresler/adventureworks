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
@Table(name = "vVendorWithContacts", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
    @NamedQuery(name = "VVendorWithContacts.findAll", query = "SELECT v FROM VVendorWithContacts v"),
    @NamedQuery(name = "VVendorWithContacts.findByBusinessEntityID", query = "SELECT v FROM VVendorWithContacts v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VVendorWithContacts.findByTitle", query = "SELECT v FROM VVendorWithContacts v WHERE v.title = :title"),
    @NamedQuery(name = "VVendorWithContacts.findBySuffix", query = "SELECT v FROM VVendorWithContacts v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VVendorWithContacts.findByEmailAddress", query = "SELECT v FROM VVendorWithContacts v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VVendorWithContacts.findByEmailPromotion", query = "SELECT v FROM VVendorWithContacts v WHERE v.emailPromotion = :emailPromotion")})
public class VVendorWithContacts implements Serializable {

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

    public VVendorWithContacts() {
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

	@Override
	public int hashCode() {
		return Objects.hash(businessEntityID, emailAddress, emailPromotion, suffix, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VVendorWithContacts other = (VVendorWithContacts) obj;
		return businessEntityID == other.businessEntityID && Objects.equals(emailAddress, other.emailAddress)
				&& emailPromotion == other.emailPromotion && Objects.equals(suffix, other.suffix)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VVendorWithContacts [businessEntityID=")
				.append(businessEntityID)
				.append(", title=")
				.append(title)
				.append(", suffix=")
				.append(suffix)
				.append(", emailAddress=")
				.append(emailAddress)
				.append(", emailPromotion=")
				.append(emailPromotion)
				.append("]");
		return builder.toString();
	}
    
}
