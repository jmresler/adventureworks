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

/**
 *
 * @author John
 */
@Entity
@Table(name = "vJobCandidateEducation", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VJobCandidateEducation.findAll", query = "SELECT v FROM VJobCandidateEducation v"),
    @NamedQuery(name = "VJobCandidateEducation.findByJobCandidateID", query = "SELECT v FROM VJobCandidateEducation v WHERE v.jobCandidateID = :jobCandidateID"),
    @NamedQuery(name = "VJobCandidateEducation.findByLevel", query = "SELECT v FROM VJobCandidateEducation v WHERE v.level = :level"),
    @NamedQuery(name = "VJobCandidateEducation.findByStartDate", query = "SELECT v FROM VJobCandidateEducation v WHERE v.startDate = :startDate"),
    @NamedQuery(name = "VJobCandidateEducation.findByEndDate", query = "SELECT v FROM VJobCandidateEducation v WHERE v.endDate = :endDate"),
    @NamedQuery(name = "VJobCandidateEducation.findByDegree", query = "SELECT v FROM VJobCandidateEducation v WHERE v.degree = :degree"),
    @NamedQuery(name = "VJobCandidateEducation.findByMajor", query = "SELECT v FROM VJobCandidateEducation v WHERE v.major = :major"),
    @NamedQuery(name = "VJobCandidateEducation.findByMinor", query = "SELECT v FROM VJobCandidateEducation v WHERE v.minor = :minor"),
    @NamedQuery(name = "VJobCandidateEducation.findByGpa", query = "SELECT v FROM VJobCandidateEducation v WHERE v.gpa = :gpa"),
    @NamedQuery(name = "VJobCandidateEducation.findByGPAScale", query = "SELECT v FROM VJobCandidateEducation v WHERE v.gPAScale = :gPAScale"),
    @NamedQuery(name = "VJobCandidateEducation.findBySchool", query = "SELECT v FROM VJobCandidateEducation v WHERE v.school = :school"),
    @NamedQuery(name = "VJobCandidateEducation.findByCountryRegion", query = "SELECT v FROM VJobCandidateEducation v WHERE v.countryRegion = :countryRegion"),
    @NamedQuery(name = "VJobCandidateEducation.findByState", query = "SELECT v FROM VJobCandidateEducation v WHERE v.state = :state"),
    @NamedQuery(name = "VJobCandidateEducation.findByCity", query = "SELECT v FROM VJobCandidateEducation v WHERE v.city = :city")})
public class VJobCandidateEducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private int jobCandidateID;
    @Column(name = "Level")
    private String level;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "Degree")
    private String degree;
    @Column(name = "Major")
    private String major;
    @Column(name = "Minor")
    private String minor;
    @Column(name = "GPA")
    private String gpa;
    @Column(name = "GPAScale")
    private String gPAScale;
    @Column(name = "School")
    private String school;
    @Column(name = "CountryRegion")
    private String countryRegion;
    @Column(name = "State")
    private String state;
    @Column(name = "City")
    private String city;

    public VJobCandidateEducation() {
    }

    public int getJobCandidateID() {
        return jobCandidateID;
    }

    public void setJobCandidateID(int jobCandidateID) {
        this.jobCandidateID = jobCandidateID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getGPAScale() {
        return gPAScale;
    }

    public void setGPAScale(String gPAScale) {
        this.gPAScale = gPAScale;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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
