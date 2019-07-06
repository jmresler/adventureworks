package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vSalesPerson", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSalesPerson.findAll", query = "SELECT v FROM VSalesPerson v"),
    @NamedQuery(name = "VSalesPerson.findByBusinessEntityID", query = "SELECT v FROM VSalesPerson v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VSalesPerson.findByTitle", query = "SELECT v FROM VSalesPerson v WHERE v.title = :title"),
    @NamedQuery(name = "VSalesPerson.findBySuffix", query = "SELECT v FROM VSalesPerson v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VSalesPerson.findByJobTitle", query = "SELECT v FROM VSalesPerson v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VSalesPerson.findByEmailAddress", query = "SELECT v FROM VSalesPerson v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VSalesPerson.findByEmailPromotion", query = "SELECT v FROM VSalesPerson v WHERE v.emailPromotion = :emailPromotion"),
    @NamedQuery(name = "VSalesPerson.findByAddressLine1", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VSalesPerson.findByAddressLine2", query = "SELECT v FROM VSalesPerson v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VSalesPerson.findByCity", query = "SELECT v FROM VSalesPerson v WHERE v.city = :city"),
    @NamedQuery(name = "VSalesPerson.findByPostalCode", query = "SELECT v FROM VSalesPerson v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VSalesPerson.findByTerritoryGroup", query = "SELECT v FROM VSalesPerson v WHERE v.territoryGroup = :territoryGroup"),
    @NamedQuery(name = "VSalesPerson.findBySalesQuota", query = "SELECT v FROM VSalesPerson v WHERE v.salesQuota = :salesQuota"),
    @NamedQuery(name = "VSalesPerson.findBySalesYTD", query = "SELECT v FROM VSalesPerson v WHERE v.salesYTD = :salesYTD"),
    @NamedQuery(name = "VSalesPerson.findBySalesLastYear", query = "SELECT v FROM VSalesPerson v WHERE v.salesLastYear = :salesLastYear")})
public class VSalesPerson implements Serializable {

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
    @Column(name = "TerritoryGroup", length = 50)
    private String territoryGroup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota", precision = 19, scale = 4)
    private BigDecimal salesQuota;
    @Basic(optional = false)
    @Column(name = "SalesYTD", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesLastYear;
    
}
