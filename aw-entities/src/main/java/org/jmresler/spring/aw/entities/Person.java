
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

/**
 *
 * @author John
 */
@Entity
@Table(name = "Person", catalog = "AdventureWorks2017", schema = "Person")

@Builder
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonPhone> personPhoneCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<EmailAddress> emailAddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @JsonIgnore
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BusinessEntity businessEntity;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Password password;

    public Person() {
    }

    public Person(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    /**
     * 
     * @param businessEntityID
     * @param personType
     * @param nameStyle
     * @param title
     * @param firstName
     * @param middleName
     * @param lastName
     * @param suffix
     * @param emailPromotion
     * @param additionalContactInfo
     * @param demographics
     * @param rowguid
     * @param modifiedDate
     * @param personPhoneCollection
     * @param emailAddressCollection
     * @param businessEntityContactCollection
     * @param businessEntity
     * @param password 
     */
    public Person(Integer businessEntityID,
    			  String userName,
                  String personType, 
                  Boolean nameStyle, 
                  String title, 
                  String firstName, 
                  String middleName, 
                  String lastName, 
                  String suffix, 
                  int emailPromotion, 
                  String additionalContactInfo, 
                  String demographics, 
                  String rowguid, 
                  Date modifiedDate, 
                  Collection<PersonPhone> personPhoneCollection, 
                  Collection<EmailAddress> emailAddressCollection, 
                  Collection<BusinessEntityContact> businessEntityContactCollection, 
                  BusinessEntity businessEntity, 
                  Password password) {
        this.businessEntityID = businessEntityID;
        this.userName = userName;
        this.personType = personType;
        this.nameStyle = nameStyle;
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.emailPromotion = emailPromotion;
        this.additionalContactInfo = additionalContactInfo;
        this.demographics = demographics;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
        this.personPhoneCollection = personPhoneCollection;
        this.emailAddressCollection = emailAddressCollection;
        this.businessEntityContactCollection = businessEntityContactCollection;
        this.businessEntity = businessEntity;
        this.password = password;
    }

    
    public String getUserName() {
    	return userName;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }

    public Boolean getNameStyle() {
        return nameStyle;
    }

    public void setNameStyle(Boolean nameStyle) {
        this.nameStyle = nameStyle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
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

    public int getEmailPromotion() {
        return emailPromotion;
    }

    public void setEmailPromotion(int emailPromotion) {
        this.emailPromotion = emailPromotion;
    }

    public String getAdditionalContactInfo() {
        return additionalContactInfo;
    }

    public void setAdditionalContactInfo(String additionalContactInfo) {
        this.additionalContactInfo = additionalContactInfo;
    }

    public String getDemographics() {
        return demographics;
    }

    public void setDemographics(String demographics) {
        this.demographics = demographics;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<PersonPhone> getPersonPhoneCollection() {
        return personPhoneCollection;
    }

    public void setPersonPhoneCollection(Collection<PersonPhone> personPhoneCollection) {
        this.personPhoneCollection = personPhoneCollection;
    }

    public Collection<EmailAddress> getEmailAddressCollection() {
        return emailAddressCollection;
    }

    public void setEmailAddressCollection(Collection<EmailAddress> emailAddressCollection) {
        this.emailAddressCollection = emailAddressCollection;
    }

    public Collection<BusinessEntityContact> getBusinessEntityContactCollection() {
        return businessEntityContactCollection;
    }

    public void setBusinessEntityContactCollection(Collection<BusinessEntityContact> businessEntityContactCollection) {
        this.businessEntityContactCollection = businessEntityContactCollection;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Person[ businessEntityID=" + businessEntityID + " ]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalContactInfo, businessEntity, userName, businessEntityID, demographics, emailPromotion,
                firstName, lastName, middleName, modifiedDate, nameStyle, password, personType, rowguid, suffix, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return Objects.equals(additionalContactInfo, other.additionalContactInfo)
                && Objects.equals(businessEntity, other.businessEntity)
                && Objects.equals(userName, other.userName)
                && Objects.equals(businessEntityID, other.businessEntityID)
                && Objects.equals(demographics, other.demographics) && emailPromotion == other.emailPromotion
                && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(middleName, other.middleName) && Objects.equals(modifiedDate, other.modifiedDate)
                && Objects.equals(nameStyle, other.nameStyle) && Objects.equals(password, other.password)
                && Objects.equals(personType, other.personType) && Objects.equals(rowguid, other.rowguid)
                && Objects.equals(suffix, other.suffix) && Objects.equals(title, other.title);
    }

}
