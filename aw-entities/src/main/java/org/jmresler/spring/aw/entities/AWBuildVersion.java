package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
@Table(name = "AWBuildVersion", catalog = "AdventureWorks2017", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "AWBuildVersion.findAll", query = "SELECT a FROM AWBuildVersion a"),
    @NamedQuery(name = "AWBuildVersion.findById", query = "SELECT a FROM AWBuildVersion a WHERE a.systemInformationID = :systemInformationID")})
public class AWBuildVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SystemInformationID", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Short systemInformationID;
    @Basic(optional = false)
    @Column(name = "[Database Version]", columnDefinition = "NVARCHAR")
    private String databaseVersion;
    @Basic(optional = false)
    @Column(name = "VersionDate")
    private Timestamp versionDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    private Timestamp modifiedDate;

	@Override
	public String toString() {
		return getClass().getName() + "[" + systemInformationID + "]"; 
	}
}
