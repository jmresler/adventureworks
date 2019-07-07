/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "ErrorLog", catalog = "AdventureWorks2017", schema = "dbo")
@XmlRootElement
public class ErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ErrorLogID")
    private Integer errorLogID;
    @Basic(optional = false)
    @Column(name = "ErrorTime")
    private Date errorTime;
    @Basic(optional = false)
    @Column(name = "UserName")
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
    @Column(name = "ErrorProcedure")
    private String errorProcedure;
    @Basic(optional = true)
    @Column(name = "ErrorLine")
    private Integer errorLine;    
    @Basic(optional = false)
    @Column(name = "ErrorMessage")
    private String errorMessage;    
    
    public ErrorLog() {
    }

    public ErrorLog(Integer errorLogID) {
        this.errorLogID = errorLogID;
    }
    
    
    public ErrorLog(Integer errorLogID, Date ErrorTime, String userName, Integer errorNumber, Integer errorSeverity, Integer errorState, String errorProcedure, Integer errorLine, String errorMessage) {
        this.errorLogID = errorLogID;
        this.errorTime = ErrorTime;
        this.userName = userName;
        this.errorNumber = errorNumber;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
        this.errorProcedure = errorProcedure;
        this.errorLine = errorLine;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorLogID() {
        return errorLogID;
    }

    public void setErrorLogID(Integer errorLogID) {
        this.errorLogID = errorLogID;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date ErrorTime) {
        this.errorTime = ErrorTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }

    public String getErrorProcedure() {
        return errorProcedure;
    }

    public void setErrorProcedure(String errorProcedure) {
        this.errorProcedure = errorProcedure;
    }

    public Integer getErrorLine() {
        return errorLine;
    }

    public void setErrorLine(Integer errorLine) {
        this.errorLine = errorLine;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.errorLogID);
        hash = 11 * hash + Objects.hashCode(this.errorTime);
        hash = 11 * hash + Objects.hashCode(this.userName);
        hash = 11 * hash + Objects.hashCode(this.errorNumber);
        hash = 11 * hash + Objects.hashCode(this.errorSeverity);
        hash = 11 * hash + Objects.hashCode(this.errorState);
        hash = 11 * hash + Objects.hashCode(this.errorProcedure);
        hash = 11 * hash + Objects.hashCode(this.errorLine);
        hash = 11 * hash + Objects.hashCode(this.errorMessage);
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
        final ErrorLog other = (ErrorLog) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.errorProcedure, other.errorProcedure)) {
            return false;
        }
        if (!Objects.equals(this.errorMessage, other.errorMessage)) {
            return false;
        }
        if (!Objects.equals(this.errorLogID, other.errorLogID)) {
            return false;
        }
        if (!Objects.equals(this.errorTime, other.errorTime)) {
            return false;
        }
        if (!Objects.equals(this.errorNumber, other.errorNumber)) {
            return false;
        }
        if (!Objects.equals(this.errorSeverity, other.errorSeverity)) {
            return false;
        }
        if (!Objects.equals(this.errorState, other.errorState)) {
            return false;
        }
        if (!Objects.equals(this.errorLine, other.errorLine)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ErrorLog{" + "errorLogID=" + errorLogID + ", ErrorTime=" + errorTime + ", userName=" + userName + ", errorNumber=" + errorNumber + ", errorSeverity=" + errorSeverity + ", errorState=" + errorState + ", errorProcedure=" + errorProcedure + ", errorLine=" + errorLine + ", errorMessage=" + errorMessage + '}';
    }
    
    
}
