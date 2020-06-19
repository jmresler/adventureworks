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
@Table(name = "vEmployeeDepartmentHistory", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({
    @NamedQuery(name = "VEmployeeDepartmentHistory.findAll", query = "SELECT v FROM VEmployeeDepartmentHistory v"),
    @NamedQuery(name = "VEmployeeDepartmentHistory.findByBusinessEntityID", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VEmployeeDepartmentHistory.findByTitle", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.title = :title"),
    @NamedQuery(name = "VEmployeeDepartmentHistory.findBySuffix", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VEmployeeDepartmentHistory.findByStartDate", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.startDate = :startDate"),
    @NamedQuery(name = "VEmployeeDepartmentHistory.findByEndDate", query = "SELECT v FROM VEmployeeDepartmentHistory v WHERE v.endDate = :endDate")})
public class VEmployeeDepartmentHistory implements Serializable {

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
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
