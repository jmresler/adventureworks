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
@Table(name = "ErrorLog", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErrorLog.findAll", query = "SELECT e FROM ErrorLog e"),
    @NamedQuery(name = "ErrorLog.findByErrorLogID", query = "SELECT e FROM ErrorLog e WHERE e.errorLogID = :errorLogID"),
    @NamedQuery(name = "ErrorLog.findByErrorTime", query = "SELECT e FROM ErrorLog e WHERE e.errorTime = :errorTime"),
    @NamedQuery(name = "ErrorLog.findByUserName", query = "SELECT e FROM ErrorLog e WHERE e.userName = :userName"),
    @NamedQuery(name = "ErrorLog.findByErrorNumber", query = "SELECT e FROM ErrorLog e WHERE e.errorNumber = :errorNumber"),
    @NamedQuery(name = "ErrorLog.findByErrorSeverity", query = "SELECT e FROM ErrorLog e WHERE e.errorSeverity = :errorSeverity"),
    @NamedQuery(name = "ErrorLog.findByErrorState", query = "SELECT e FROM ErrorLog e WHERE e.errorState = :errorState"),
    @NamedQuery(name = "ErrorLog.findByErrorProcedure", query = "SELECT e FROM ErrorLog e WHERE e.errorProcedure = :errorProcedure"),
    @NamedQuery(name = "ErrorLog.findByErrorLine", query = "SELECT e FROM ErrorLog e WHERE e.errorLine = :errorLine"),
    @NamedQuery(name = "ErrorLog.findByErrorMessage", query = "SELECT e FROM ErrorLog e WHERE e.errorMessage = :errorMessage")})
public class ErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ErrorLogID", nullable = false)
    private Integer errorLogID;
    @Basic(optional = false)
    @Column(name = "ErrorTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date errorTime;
    @Basic(optional = false)
    @Column(name = "UserName", nullable = false, length = 128)
    private String userName;
    @Basic(optional = false)
    @Column(name = "ErrorNumber", nullable = false)
    private int errorNumber;
    @Column(name = "ErrorSeverity")
    private Integer errorSeverity;
    @Column(name = "ErrorState")
    private Integer errorState;
    @Column(name = "ErrorProcedure", length = 126)
    private String errorProcedure;
    @Column(name = "ErrorLine")
    private Integer errorLine;
    @Basic(optional = false)
    @Column(name = "ErrorMessage", nullable = false, length = 4000)
    private String errorMessage;

    public ErrorLog(Integer errorLogID) {
        this.errorLogID = errorLogID;
    }    
}
