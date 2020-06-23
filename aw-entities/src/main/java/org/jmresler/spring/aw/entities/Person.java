
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;

import lombok.Setter;

import lombok.Getter;

import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Person", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
		@NamedQuery(name = "Person.findByBusinessEntityID", query = "SELECT p FROM Person p WHERE p.businessEntityID = :businessEntityID"),
		@NamedQuery(name = "Person.findByPersonType", query = "SELECT p FROM Person p WHERE p.personType = :personType"),
		@NamedQuery(name = "Person.findByTitle", query = "SELECT p FROM Person p WHERE p.title = :title"),
		@NamedQuery(name = "Person.findBySuffix", query = "SELECT p FROM Person p WHERE p.suffix = :suffix"),
		@NamedQuery(name = "Person.findByEmailPromotion", query = "SELECT p FROM Person p WHERE p.emailPromotion = :emailPromotion"),
		@NamedQuery(name = "Person.findByAdditionalContactInfo", query = "SELECT p FROM Person p WHERE p.additionalContactInfo = :additionalContactInfo"),
		@NamedQuery(name = "Person.findByDemographics", query = "SELECT p FROM Person p WHERE p.demographics = :demographics"),
		@NamedQuery(name = "Person.findByRowguid", query = "SELECT p FROM Person p WHERE p.rowguid = :rowguid"),
		@NamedQuery(name = "Person.findByModifiedDate", query = "SELECT p FROM Person p WHERE p.modifiedDate = :modifiedDate") })
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "BusinessEntityID")
	private Integer businessEntityID;
	
	@Basic(optional = false)
	@Column(name = "UserName")
	private String userName;
	
	@Basic(optional = false)
	@Column(name = "PersonType")
	private String personType;
	
	@Basic(optional = false)
	@Column(name = "NameStyle")
	private Boolean nameStyle;
	
	@Column(name = "Title")
	private String title;
	
	@Basic(optional = false)
	@Column(name = "FirstName")
	private String firstName;
	
	@Basic(optional = false)
	@Column(name = "MiddleName")
	private String middleName;
	
	@Basic(optional = false)
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Suffix")
	private String suffix;
	
	@Basic(optional = false)
	@Column(name = "EmailPromotion")
	private int emailPromotion;
	
	@Column(name = "AdditionalContactInfo")
	private String additionalContactInfo;
	
	@Column(name = "Demographics")
	private String demographics;
	
	@Basic(optional = false)
	@Column(name = "rowguid")
	private String rowguid;
	
	@Basic(optional = false)
	@Column(name = "ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Collection<PersonPhone> personPhoneCollection;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Collection<EmailAddress> emailAddressCollection;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	private Collection<BusinessEntityContact> businessEntityContactCollection;
	
	@JsonBackReference
	@JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private BusinessEntity businessEntity;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
	private Password password;

	@Override
	public String toString() {
		return getClass().getName() + "[" + businessEntityID + "]"; 
	}
}
