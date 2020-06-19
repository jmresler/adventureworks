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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
