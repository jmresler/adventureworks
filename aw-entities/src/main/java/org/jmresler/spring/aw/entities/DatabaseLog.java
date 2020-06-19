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
import javax.persistence.Lob;
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
@Table(name = "DatabaseLog", catalog = "AdventureWorks2017", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "DatabaseLog.findAll", query = "SELECT d FROM DatabaseLog d"),
    @NamedQuery(name = "DatabaseLog.findById", query = "SELECT d FROM DatabaseLog d WHERE d.databaseLogID = :databaseLogID")})
public class DatabaseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DatabaseLogID")
    private Integer databaseLogID;
    @Temporal(TemporalType.TIME)
    @Basic(optional = false)
    @Column(name = "PostTime", columnDefinition = "DATETIME NOT NULL")
    private Date postTime;
    @Basic(optional = false)
    @Column(name = "DatabaseUser", columnDefinition = "SYSNAME(NVARCHAR(128)) NOT NULL")
    private String databaseUser;
    @Basic(optional = false)
    @Column(name = "Event", columnDefinition = "SYSNAME(NVARCHAR(128)) NOT NULL")
    private String event;
    @Basic(optional = true)
    @Column(name = "Schema", columnDefinition = "SYSNAME(NVARCHAR(128)) NULL")
    private String schema;
    @Basic(optional = true)
    @Column(name = "Object", columnDefinition = "SYSNAME(NVARCHAR(128)) NULL")
    private String dbObject;
    @Lob
    @Basic(optional = false)
    @Column(name = "TSQL", columnDefinition = "NVARCHAR(MAX) NOT NULL")
    private String tSQL;
    @Basic(optional = true)
    @Column(name = "XmlEvent", columnDefinition = "XML(.)")
    private String xmlEvent;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
