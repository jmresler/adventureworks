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
@Table(name = "vJobCandidateEmployment", schema = "HumanResources")
@XmlRootElement
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
    @Column(name = "JobCandidateID", nullable = false)
    private int jobCandidateID;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "OrgName", length = 100)
    private String orgName;
    @Column(name = "JobTitle", length = 100)
    private String jobTitle;
    @Column(name = "Responsibility", length = 2147483647)
    private String responsibility;
    @Column(name = "FunctionCategory", length = 2147483647)
    private String functionCategory;
    @Column(name = "IndustryCategory", length = 2147483647)
    private String industryCategory;
    @Column(name = "CountryRegion", length = 2147483647)
    private String countryRegion;
    @Column(name = "State", length = 2147483647)
    private String state;
    @Column(name = "City", length = 2147483647)
    private String city;
}
