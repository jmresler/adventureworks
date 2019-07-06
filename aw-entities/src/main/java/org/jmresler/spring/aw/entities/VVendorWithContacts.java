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
@Table(name = "vVendorWithContacts", schema = "Purchasing")
@XmlRootElement
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

}
