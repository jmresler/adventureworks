package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "vIndividualCustomer", schema = "Sales")
@XmlRootElement
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
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "Title", length = 8)
    private String title;
    @Column(name = "Suffix", length = 10)
    private String suffix;
    @Column(name = "EmailAddress", length = 50)
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "EmailPromotion", nullable = false)
    private int emailPromotion;
    @Basic(optional = false)
    @Column(name = "AddressLine1", nullable = false, length = 60)
    private String addressLine1;
    @Column(name = "AddressLine2", length = 60)
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "City", nullable = false, length = 30)
    private String city;
    @Basic(optional = false)
    @Column(name = "PostalCode", nullable = false, length = 15)
    private String postalCode;
    @Column(name = "Demographics", length = 2147483647)
    private String demographics;    
}
