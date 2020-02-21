package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "vAdditionalContactInfo", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VAdditionalContactInfo.findAll", query = "SELECT v FROM VAdditionalContactInfo v"),
    @NamedQuery(name = "VAdditionalContactInfo.findByBusinessEntityID", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VAdditionalContactInfo.findByTelephoneNumber", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "VAdditionalContactInfo.findByTelephoneSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.telephoneSpecialInstructions = :telephoneSpecialInstructions"),
    @NamedQuery(name = "VAdditionalContactInfo.findByStreet", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.street = :street"),
    @NamedQuery(name = "VAdditionalContactInfo.findByCity", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.city = :city"),
    @NamedQuery(name = "VAdditionalContactInfo.findByStateProvince", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.stateProvince = :stateProvince"),
    @NamedQuery(name = "VAdditionalContactInfo.findByPostalCode", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VAdditionalContactInfo.findByCountryRegion", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.countryRegion = :countryRegion"),
    @NamedQuery(name = "VAdditionalContactInfo.findByHomeAddressSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.homeAddressSpecialInstructions = :homeAddressSpecialInstructions"),
    @NamedQuery(name = "VAdditionalContactInfo.findByEMailAddress", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailAddress = :eMailAddress"),
    @NamedQuery(name = "VAdditionalContactInfo.findByEMailSpecialInstructions", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailSpecialInstructions = :eMailSpecialInstructions"),
    @NamedQuery(name = "VAdditionalContactInfo.findByEMailTelephoneNumber", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.eMailTelephoneNumber = :eMailTelephoneNumber"),
    @NamedQuery(name = "VAdditionalContactInfo.findByRowguid", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.rowguid = :rowguid"),
    @NamedQuery(name = "VAdditionalContactInfo.findByModifiedDate", query = "SELECT v FROM VAdditionalContactInfo v WHERE v.modifiedDate = :modifiedDate")})
public class VAdditionalContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "TelephoneNumber")
    private String telephoneNumber;
    @Column(name = "TelephoneSpecialInstructions")
    private String telephoneSpecialInstructions;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name = "StateProvince")
    private String stateProvince;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "HomeAddressSpecialInstructions")
    private String homeAddressSpecialInstructions;
    @Column(name = "EMailAddress")
    private String eMailAddress;
    @Column(name = "EMailSpecialInstructions")
    private String eMailSpecialInstructions;
    @Column(name = "EMailTelephoneNumber")
    private String eMailTelephoneNumber;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public VAdditionalContactInfo() {
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneSpecialInstructions() {
        return telephoneSpecialInstructions;
    }

    public void setTelephoneSpecialInstructions(String telephoneSpecialInstructions) {
        this.telephoneSpecialInstructions = telephoneSpecialInstructions;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getHomeAddressSpecialInstructions() {
        return homeAddressSpecialInstructions;
    }

    public void setHomeAddressSpecialInstructions(String homeAddressSpecialInstructions) {
        this.homeAddressSpecialInstructions = homeAddressSpecialInstructions;
    }

    public String getEMailAddress() {
        return eMailAddress;
    }

    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getEMailSpecialInstructions() {
        return eMailSpecialInstructions;
    }

    public void setEMailSpecialInstructions(String eMailSpecialInstructions) {
        this.eMailSpecialInstructions = eMailSpecialInstructions;
    }

    public String getEMailTelephoneNumber() {
        return eMailTelephoneNumber;
    }

    public void setEMailTelephoneNumber(String eMailTelephoneNumber) {
        this.eMailTelephoneNumber = eMailTelephoneNumber;
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
    
}
