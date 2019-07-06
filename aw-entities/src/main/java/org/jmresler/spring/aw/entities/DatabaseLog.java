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
@Table(name = "DatabaseLog", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatabaseLog.findAll", query = "SELECT d FROM DatabaseLog d"),
    @NamedQuery(name = "DatabaseLog.findByDatabaseLogID", query = "SELECT d FROM DatabaseLog d WHERE d.databaseLogID = :databaseLogID"),
    @NamedQuery(name = "DatabaseLog.findByPostTime", query = "SELECT d FROM DatabaseLog d WHERE d.postTime = :postTime"),
    @NamedQuery(name = "DatabaseLog.findByDatabaseUser", query = "SELECT d FROM DatabaseLog d WHERE d.databaseUser = :databaseUser"),
    @NamedQuery(name = "DatabaseLog.findByEvent", query = "SELECT d FROM DatabaseLog d WHERE d.event = :event"),
    @NamedQuery(name = "DatabaseLog.findBySchema", query = "SELECT d FROM DatabaseLog d WHERE d.schema = :schema"),
    @NamedQuery(name = "DatabaseLog.findByObject", query = "SELECT d FROM DatabaseLog d WHERE d.object = :object"),
    @NamedQuery(name = "DatabaseLog.findByTsql", query = "SELECT d FROM DatabaseLog d WHERE d.tsql = :tsql"),
    @NamedQuery(name = "DatabaseLog.findByXmlEvent", query = "SELECT d FROM DatabaseLog d WHERE d.xmlEvent = :xmlEvent")})
public class DatabaseLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DatabaseLogID", nullable = false)
    private Integer databaseLogID;
    @Basic(optional = false)
    @Column(name = "PostTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postTime;
    @Basic(optional = false)
    @Column(name = "DatabaseUser", nullable = false, length = 128)
    private String databaseUser;
    @Basic(optional = false)
    @Column(name = "Event", nullable = false, length = 128)
    private String event;
    @Column(name = "Schema", length = 128)
    private String schema;
    @Column(name = "Object", length = 128)
    private String object;
    @Basic(optional = false)
    @Column(name = "TSQL", nullable = false, length = 2147483647)
    private String tsql;
    @Basic(optional = false)
    @Column(name = "XmlEvent", nullable = false, length = 2147483647)
    private String xmlEvent;

    public DatabaseLog(Integer databaseLogID) {
        this.databaseLogID = databaseLogID;
    }
}
