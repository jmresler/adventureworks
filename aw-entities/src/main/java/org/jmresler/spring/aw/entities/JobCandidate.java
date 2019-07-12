/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "JobCandidate", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobCandidate.findAll", query = "SELECT j FROM JobCandidate j"),
    @NamedQuery(name = "JobCandidate.findByJobCandidateID", query = "SELECT j FROM JobCandidate j WHERE j.jobCandidateID = :jobCandidateID"),
    @NamedQuery(name = "JobCandidate.findByResume", query = "SELECT j FROM JobCandidate j WHERE j.resume = :resume"),
    @NamedQuery(name = "JobCandidate.findByModifiedDate", query = "SELECT j FROM JobCandidate j WHERE j.modifiedDate = :modifiedDate")})
public class JobCandidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JobCandidateID")
    private Integer jobCandidateID;
    @Column(name = "Resume")
    private String resume;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private Employee businessEntityID;

    public JobCandidate() {
    }

    public JobCandidate(Integer jobCandidateID) {
        this.jobCandidateID = jobCandidateID;
    }

    public JobCandidate(Integer jobCandidateID, Date modifiedDate) {
        this.jobCandidateID = jobCandidateID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getJobCandidateID() {
        return jobCandidateID;
    }

    public void setJobCandidateID(Integer jobCandidateID) {
        this.jobCandidateID = jobCandidateID;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Employee getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(Employee businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobCandidateID != null ? jobCandidateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobCandidate)) {
            return false;
        }
        JobCandidate other = (JobCandidate) object;
        if ((this.jobCandidateID == null && other.jobCandidateID != null) || (this.jobCandidateID != null && !this.jobCandidateID.equals(other.jobCandidateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.JobCandidate[ jobCandidateID=" + jobCandidateID + " ]";
    }
    
}
