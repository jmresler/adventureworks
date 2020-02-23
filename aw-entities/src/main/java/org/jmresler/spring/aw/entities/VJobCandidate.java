package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
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

    public VJobCandidate() {
    }

    public int getJobCandidateID() {
        return jobCandidateID;
    }

    public void setJobCandidateID(int jobCandidateID) {
        this.jobCandidateID = jobCandidateID;
    }

    public Integer getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

	@Override
	public int hashCode() {
		return Objects.hash(businessEntityID, 
							city, 
							countryRegion, 
							eMail, 
							first, 
							jobCandidateID, 
							last, 
							middle,
							modifiedDate, 
							postalCode, 
							prefix, 
							skills, 
							state, 
							suffix, 
							type, 
							webSite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VJobCandidate other = (VJobCandidate) obj;
		return Objects.equals(businessEntityID, other.businessEntityID) && Objects.equals(city, other.city)
				&& Objects.equals(countryRegion, other.countryRegion) && Objects.equals(eMail, other.eMail)
				&& Objects.equals(first, other.first) && jobCandidateID == other.jobCandidateID
				&& Objects.equals(last, other.last) && Objects.equals(middle, other.middle)
				&& Objects.equals(modifiedDate, other.modifiedDate) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(prefix, other.prefix) && Objects.equals(skills, other.skills)
				&& Objects.equals(state, other.state) && Objects.equals(suffix, other.suffix)
				&& Objects.equals(type, other.type) && Objects.equals(webSite, other.webSite);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VJobCandidate [jobCandidateID=")
				.append(jobCandidateID)
				.append(", businessEntityID=")
				.append(businessEntityID)
				.append(", prefix=")
				.append(prefix)
				.append(", first=")
				.append(first)
				.append(", middle=")
				.append(middle)
				.append(", last=")
				.append(last)
				.append(", suffix=")
				.append(suffix)
				.append(", skills=")
				.append(skills)
				.append(", type=")
				.append(type)
				.append(", countryRegion=")
				.append(countryRegion)
				.append(", state=")
				.append(state)
				.append(", city=")
				.append(city)
				.append(", postalCode=")
				.append(postalCode)
				.append(", eMail=")
				.append(eMail)
				.append(", webSite=")
				.append(webSite)
				.append(", modifiedDate=")
				.append(modifiedDate)
				.append("]");
		return builder.toString();
	}

    
}
