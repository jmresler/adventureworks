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

/**
 *
 * @author John
 */
@Entity
@Table(name = "vJobCandidateEmployment", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
    @NamedQuery(name = "VJobCandidateEmployment.findAll", query = "SELECT v FROM VJobCandidateEmployment v"),
    @NamedQuery(name = "VJobCandidateEmployment.findByJobCandidateID", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.jobCandidateID = :jobCandidateID"),
    @NamedQuery(name = "VJobCandidateEmployment.findByStartDate", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.startDate = :startDate"),
    @NamedQuery(name = "VJobCandidateEmployment.findByEndDate", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.endDate = :endDate"),
    @NamedQuery(name = "VJobCandidateEmployment.findByOrgName", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.orgName = :orgName"),
    @NamedQuery(name = "VJobCandidateEmployment.findByJobTitle", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VJobCandidateEmployment.findByResponsibility", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.responsibility = :responsibility"),
    @NamedQuery(name = "VJobCandidateEmployment.findByFunctionCategory", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.functionCategory = :functionCategory"),
    @NamedQuery(name = "VJobCandidateEmployment.findByIndustryCategory", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.industryCategory = :industryCategory"),
    @NamedQuery(name = "VJobCandidateEmployment.findByCountryRegion", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.countryRegion = :countryRegion"),
    @NamedQuery(name = "VJobCandidateEmployment.findByState", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.state = :state"),
    @NamedQuery(name = "VJobCandidateEmployment.findByCity", query = "SELECT v FROM VJobCandidateEmployment v WHERE v.city = :city")})
public class VJobCandidateEmployment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "OrgName")
    private String orgName;
    @Column(name = "JobTitle")
    private String jobTitle;
    @Column(name = "Responsibility")
    private String responsibility;
    @Column(name = "FunctionCategory")
    private String functionCategory;
    @Column(name = "IndustryCategory")
    private String industryCategory;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;

    public VJobCandidateEmployment() {
    }

    public int getJobCandidateID() {
        return jobCandidateID;
    }

    public void setJobCandidateID(int jobCandidateID) {
        this.jobCandidateID = jobCandidateID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getFunctionCategory() {
        return functionCategory;
    }

    public void setFunctionCategory(String functionCategory) {
        this.functionCategory = functionCategory;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
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
    
}
