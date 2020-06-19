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
@Table(name = "vStoreWithContacts", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VStoreWithContacts.findAll", query = "SELECT v FROM VStoreWithContacts v"),
    @NamedQuery(name = "VStoreWithContacts.findByBusinessEntityID", query = "SELECT v FROM VStoreWithContacts v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VStoreWithContacts.findByTitle", query = "SELECT v FROM VStoreWithContacts v WHERE v.title = :title"),
    @NamedQuery(name = "VStoreWithContacts.findBySuffix", query = "SELECT v FROM VStoreWithContacts v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VStoreWithContacts.findByEmailAddress", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VStoreWithContacts.findByEmailPromotion", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailPromotion = :emailPromotion")})
public class VStoreWithContacts implements Serializable {

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
