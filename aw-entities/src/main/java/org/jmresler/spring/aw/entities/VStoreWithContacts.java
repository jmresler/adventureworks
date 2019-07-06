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
@Table(name = "vStoreWithContacts", schema = "Sales")
@XmlRootElement
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
