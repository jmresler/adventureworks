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
@Table(name = "vEmployeeDepartment", catalog = "AdventureWorks2017", schema = "HumanResources")

@NamedQueries({
    @NamedQuery(name = "VEmployeeDepartment.findAll", query = "SELECT v FROM VEmployeeDepartment v"),
    @NamedQuery(name = "VEmployeeDepartment.findByBusinessEntityID", query = "SELECT v FROM VEmployeeDepartment v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VEmployeeDepartment.findByTitle", query = "SELECT v FROM VEmployeeDepartment v WHERE v.title = :title"),
    @NamedQuery(name = "VEmployeeDepartment.findBySuffix", query = "SELECT v FROM VEmployeeDepartment v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VEmployeeDepartment.findByJobTitle", query = "SELECT v FROM VEmployeeDepartment v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VEmployeeDepartment.findByStartDate", query = "SELECT v FROM VEmployeeDepartment v WHERE v.startDate = :startDate")})
public class VEmployeeDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Column(name = "Suffix")
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public VEmployeeDepartment() {
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

	@Override
	public int hashCode() {
		return Objects.hash(businessEntityID, jobTitle, startDate, suffix, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VEmployeeDepartment other = (VEmployeeDepartment) obj;
		return businessEntityID == other.businessEntityID && Objects.equals(jobTitle, other.jobTitle)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(suffix, other.suffix)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VEmployeeDepartment [businessEntityID=").append(businessEntityID).append(", title=")
				.append(title).append(", suffix=").append(suffix).append(", jobTitle=").append(jobTitle)
				.append(", startDate=").append(startDate).append("]");
		return builder.toString();
	}
    
    
    
}
