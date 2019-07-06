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
@Table(name = "vJobCandidate", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VJobCandidate.findAll", query = "SELECT v FROM VJobCandidate v"),
    @NamedQuery(name = "VJobCandidate.findByJobCandidateID", query = "SELECT v FROM VJobCandidate v WHERE v.jobCandidateID = :jobCandidateID"),
    @NamedQuery(name = "VJobCandidate.findByBusinessEntityID", query = "SELECT v FROM VJobCandidate v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VJobCandidate.findByPrefix", query = "SELECT v FROM VJobCandidate v WHERE v.prefix = :prefix"),
    @NamedQuery(name = "VJobCandidate.findByFirst", query = "SELECT v FROM VJobCandidate v WHERE v.first = :first"),
    @NamedQuery(name = "VJobCandidate.findByMiddle", query = "SELECT v FROM VJobCandidate v WHERE v.middle = :middle"),
    @NamedQuery(name = "VJobCandidate.findByLast", query = "SELECT v FROM VJobCandidate v WHERE v.last = :last"),
    @NamedQuery(name = "VJobCandidate.findBySuffix", query = "SELECT v FROM VJobCandidate v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VJobCandidate.findBySkills", query = "SELECT v FROM VJobCandidate v WHERE v.skills = :skills"),
    @NamedQuery(name = "VJobCandidate.findByType", query = "SELECT v FROM VJobCandidate v WHERE v.type = :type"),
    @NamedQuery(name = "VJobCandidate.findByCountryRegion", query = "SELECT v FROM VJobCandidate v WHERE v.countryRegion = :countryRegion"),
    @NamedQuery(name = "VJobCandidate.findByState", query = "SELECT v FROM VJobCandidate v WHERE v.state = :state"),
    @NamedQuery(name = "VJobCandidate.findByCity", query = "SELECT v FROM VJobCandidate v WHERE v.city = :city"),
    @NamedQuery(name = "VJobCandidate.findByPostalCode", query = "SELECT v FROM VJobCandidate v WHERE v.postalCode = :postalCode"),
    @NamedQuery(name = "VJobCandidate.findByEMail", query = "SELECT v FROM VJobCandidate v WHERE v.eMail = :eMail"),
    @NamedQuery(name = "VJobCandidate.findByWebSite", query = "SELECT v FROM VJobCandidate v WHERE v.webSite = :webSite"),
    @NamedQuery(name = "VJobCandidate.findByModifiedDate", query = "SELECT v FROM VJobCandidate v WHERE v.modifiedDate = :modifiedDate")})
public class VJobCandidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID", nullable = false)
    private int jobCandidateID;
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "Prefix", length = 30)
    private String prefix;
    @Column(name = "First", length = 30)
    private String first;
    @Column(name = "Middle", length = 30)
    private String middle;
    @Column(name = "Last", length = 30)
    private String last;
    @Column(name = "Suffix", length = 30)
    private String suffix;
    @Column(name = "Skills", length = 2147483647)
    private String skills;
    @Column(name = "Type", length = 30)
    private String type;
    @Column(name = "CountryRegion", length = 100)
    private String countryRegion;
    @Column(name = "State", length = 100)
    private String state;
    @Column(name = "City", length = 100)
    private String city;
    @Column(name = "PostalCode", length = 20)
    private String postalCode;
    @Column(name = "EMail", length = 2147483647)
    private String eMail;
    @Column(name = "WebSite", length = 2147483647)
    private String webSite;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
