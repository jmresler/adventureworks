package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Person", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByBusinessEntityID", query = "SELECT p FROM Person p WHERE p.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Person.findByPersonType", query = "SELECT p FROM Person p WHERE p.personType = :personType"),
    @NamedQuery(name = "Person.findByTitle", query = "SELECT p FROM Person p WHERE p.title = :title"),
    @NamedQuery(name = "Person.findBySuffix", query = "SELECT p FROM Person p WHERE p.suffix = :suffix"),
    @NamedQuery(name = "Person.findByEmailPromotion", query = "SELECT p FROM Person p WHERE p.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "Person.findByAdditionalContactInfo", query = "SELECT p FROM Person p WHERE p.additionalContactInfo = :additionalContactInfo"),
    @NamedQuery(name = "Person.findByDemographics", query = "SELECT p FROM Person p WHERE p.demographics = :demographics"),
    @NamedQuery(name = "Person.findByRowguid", query = "SELECT p FROM Person p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "Person.findByModifiedDate", query = "SELECT p FROM Person p WHERE p.modifiedDate = :modifiedDate")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "PersonType")
    private String personType;
    @Column(name = "Title")
    private String title;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="MiddleName")
    private String middleName;
    @Column(name="LastName")
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
    @JsonIgnore
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonPhone> personPhoneCollection;
    @JsonIgnore
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<EmailAddress> emailAddressCollection;
    @JsonIgnore
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BusinessEntity businessEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Password password;
}
