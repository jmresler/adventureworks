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
@Table(name = "AWBuildVersion", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AWBuildVersion.findAll", query = "SELECT a FROM AWBuildVersion a"),
    @NamedQuery(name = "AWBuildVersion.findBySystemInformationID", query = "SELECT a FROM AWBuildVersion a WHERE a.systemInformationID = :systemInformationID"),
    @NamedQuery(name = "AWBuildVersion.findByDatabaseVersion", query = "SELECT a FROM AWBuildVersion a WHERE a.databaseVersion = :databaseVersion"),
    @NamedQuery(name = "AWBuildVersion.findByVersionDate", query = "SELECT a FROM AWBuildVersion a WHERE a.versionDate = :versionDate"),
    @NamedQuery(name = "AWBuildVersion.findByModifiedDate", query = "SELECT a FROM AWBuildVersion a WHERE a.modifiedDate = :modifiedDate")})
public class AWBuildVersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SystemInformationID", nullable = false)
    private Short systemInformationID;
    @Basic(optional = false)
    @Column(name = "Database Version", nullable = false, length = 25)
    private String databaseVersion;
    @Basic(optional = false)
    @Column(name = "VersionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date versionDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public AWBuildVersion(Short systemInformationID) {
        this.systemInformationID = systemInformationID;
    }    
}
