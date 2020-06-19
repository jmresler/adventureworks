package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "ErrorLog", catalog = "AdventureWorks2017", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ErrorLog.findAll", query = "SELECT e FROM ErrorLog e"),
    @NamedQuery(name = "ErrorLog.findById", query = "SELECT e FROM ErrorLog e WHERE e.errorLogID = :errorLogID")})
public class ErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ErrorLogID")
    private Integer errorLogID;
    @Basic(optional = false)
    @Column(name = "ErrorTime")
    private Timestamp errorTime;
    @Basic(optional = false)
    @Column(name = "UserName", columnDefinition = "SYSNAME(NVARCHAR(128)) NOT NULL")
    private String userName;
    @Basic(optional = false)
    @Column(name = "ErrorNumber")
    private Integer errorNumber;
    @Basic(optional = true)
    @Column(name = "ErrorSeverity")
    private Integer errorSeverity;
    @Basic(optional = true)
    @Column(name = "ErrorState")
    private Integer errorState;
    @Basic(optional = true)
    @Column(name = "ErrorProcedure", columnDefinition = "NVARCHAR(126) NULL")
    private String errorProcedure;
    @Basic(optional = true)
    @Column(name = "ErrorLine")
    private Integer errorLine;    
    @Basic(optional = false)
    @Column(name = "ErrorMessage", columnDefinition = "NVARCHAR(4000) NOT NULL")
    private String errorMessage;    
    
	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
