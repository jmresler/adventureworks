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
@Table(name = "vEmployee", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VEmployee.findAll", query = "SELECT v FROM VEmployee v"),
    @NamedQuery(name = "VEmployee.findByBusinessEntityID", query = "SELECT v FROM VEmployee v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VEmployee.findByTitle", query = "SELECT v FROM VEmployee v WHERE v.title = :title"),
    @NamedQuery(name = "VEmployee.findBySuffix", query = "SELECT v FROM VEmployee v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VEmployee.findByJobTitle", query = "SELECT v FROM VEmployee v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VEmployee.findByEmailAddress", query = "SELECT v FROM VEmployee v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VEmployee.findByEmailPromotion", query = "SELECT v FROM VEmployee v WHERE v.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "VEmployee.findByAddressLine1", query = "SELECT v FROM VEmployee v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VEmployee.findByAddressLine2", query = "SELECT v FROM VEmployee v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VEmployee.findByCity", query = "SELECT v FROM VEmployee v WHERE v.city = :city"),
    @NamedQuery(name = "VEmployee.findByPostalCode", query = "SELECT v FROM VEmployee v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VEmployee.findByAdditionalContactInfo", query = "SELECT v FROM VEmployee v WHERE v.additionalContactInfo = :additionalContactInfo")})
public class VEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "Title", length = 8)
    private String title;
    @Column(name = "Suffix", length = 10)
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
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
    @Column(name = "AdditionalContactInfo", length = 2147483647)
    private String additionalContactInfo;
    
}
