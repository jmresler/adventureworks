package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "AWBuildVersion", catalog = "AdventureWorks2017", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AWBuildVersion.findAll", query = "SELECT a FROM AWBuildVersion a"),
    @NamedQuery(name = "AWBuildVersion.findById", query = "SELECT a FROM AWBuildVersion a WHERE a.systemInformationID = :systemInformationID")})
public class AWBuildVersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SystemInformationID")
    private Short systemInformationID;
    @Basic(optional = false)
    @Column(name = "[Database Version]")
    private String databaseVersion;
    @Temporal(TemporalType.TIME)
    @Basic(optional = false)
    @Column(name = "VersionDate")
    private Date versionDate;
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    public AWBuildVersion() {
    }

    public AWBuildVersion(Short systemInformationID) {
        this.systemInformationID = systemInformationID;
    }

    public AWBuildVersion(Short systemInformationID, String databaseVersion, Date versionDate, Date modifiedDate) {
        this.systemInformationID = systemInformationID;
        this.databaseVersion = databaseVersion;
        this.versionDate = versionDate;
        this.modifiedDate = modifiedDate;
    }

    public Short getSystemInformationID() {
        return systemInformationID;
    }

    public void setSystemInformationID(Short systemInformationID) {
        this.systemInformationID = systemInformationID;
    }

    public String getDatabaseVersion() {
        return databaseVersion;
    }

    public void setDatabaseVersion(String databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.systemInformationID);
        hash = 83 * hash + Objects.hashCode(this.databaseVersion);
        hash = 83 * hash + Objects.hashCode(this.versionDate);
        hash = 83 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AWBuildVersion other = (AWBuildVersion) obj;
        if (!Objects.equals(this.databaseVersion, other.databaseVersion)) {
            return false;
        }
        if (!Objects.equals(this.systemInformationID, other.systemInformationID)) {
            return false;
        }
        if (!Objects.equals(this.versionDate, other.versionDate)) {
            return false;
        }
        if (!Objects.equals(this.modifiedDate, other.modifiedDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AWBuildVersion{" + "systemInformationID=" + systemInformationID + ", databaseVersion=" + databaseVersion + ", versionDate=" + versionDate + ", modifiedDate=" + modifiedDate + '}';
    }

    
}
