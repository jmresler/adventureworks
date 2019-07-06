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
@Table(name = "vEmployeeDepartment", schema = "HumanResources")
@XmlRootElement
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
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "Title", length = 8)
    private String title;
    @Column(name = "Suffix", length = 10)
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
}
