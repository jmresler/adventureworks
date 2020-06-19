package org.jmresler.spring.aw.entities.views;

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

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "vJobCandidate", catalog = "AdventureWorks2017", schema = "HumanResources")

// FIXME - There's a problem with the SQL Server syntax in these queries that
//		   is breaking the query

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
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "[Name.Prefix]")
    private String prefix;
    @Column(name = "[Name.First]")
    private String first;
    @Column(name = "[Name.Middle]")
    private String middle;
    @Column(name = "[Name.Last]")
    private String last;
    @Column(name = "[Name.Suffix]")
    private String suffix;
    @Column(name = "Skills")
    private String skills;
    @Column(name = "[Addr.Type]")
    private String type;
    @Column(name = "[Addr.Loc.CountryRegion]")
    private String countryRegion;
    @Column(name = "[Addr.Loc.State]")
    private String state;
    @Column(name = "[Addr.Loc.City]")
    private String city;
    @Column(name = "[Addr.PostalCode]")
    private String postalCode;
    @Column(name = "EMail")
    private String eMail;
    @Column(name = "WebSite")
    private String webSite;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}   
}
