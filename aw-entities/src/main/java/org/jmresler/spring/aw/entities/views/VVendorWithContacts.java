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


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
