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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "JobCandidate", catalog = "AdventureWorks2017", schema = "HumanResources")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
