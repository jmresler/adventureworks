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
@Table(name = "vAdditionalContactInfo", schema = "Person")
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
    
}
