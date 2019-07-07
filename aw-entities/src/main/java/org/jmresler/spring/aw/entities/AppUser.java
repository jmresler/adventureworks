/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "AppUser", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findById", query = "SELECT a FROM AppUser a WHERE a.id = :id"),
    @NamedQuery(name = "AppUser.findByUserName", query = "SELECT a FROM AppUser a WHERE a.userName = :userName"),
    @NamedQuery(name = "AppUser.findByPassword", query = "SELECT a FROM AppUser a WHERE a.password = :password"),
    @NamedQuery(name = "AppUser.findByLoginAttempts", query = "SELECT a FROM AppUser a WHERE a.loginAttempts = :loginAttempts"),
    @NamedQuery(name = "AppUser.findByLoginHint1", query = "SELECT a FROM AppUser a WHERE a.loginHint1 = :loginHint1"),
    @NamedQuery(name = "AppUser.findByLoginHint2", query = "SELECT a FROM AppUser a WHERE a.loginHint2 = :loginHint2"),
    @NamedQuery(name = "AppUser.findByLoginHint3", query = "SELECT a FROM AppUser a WHERE a.loginHint3 = :loginHint3"),
    @NamedQuery(name = "AppUser.findByIsActive", query = "SELECT a FROM AppUser a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AppUser.findByLastUpdate", query = "SELECT a FROM AppUser a WHERE a.lastUpdate = :lastUpdate")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "LoginAttempts")
    private short loginAttempts;
    @Basic(optional = false)
    @Column(name = "LoginHint1")
    private String loginHint1;
    @Basic(optional = false)
    @Column(name = "LoginHint2")
    private String loginHint2;
    @Basic(optional = false)
    @Column(name = "LoginHint3")
    private String loginHint3;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public AppUser() {
    }

    public AppUser(Long id) {
        this.id = id;
    }

    public AppUser(Long id, String userName, String password, short loginAttempts, String loginHint1, String loginHint2, String loginHint3, Date lastUpdate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.loginAttempts = loginAttempts;
        this.loginHint1 = loginHint1;
        this.loginHint2 = loginHint2;
        this.loginHint3 = loginHint3;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(short loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLoginHint1() {
        return loginHint1;
    }

    public void setLoginHint1(String loginHint1) {
        this.loginHint1 = loginHint1;
    }

    public String getLoginHint2() {
        return loginHint2;
    }

    public void setLoginHint2(String loginHint2) {
        this.loginHint2 = loginHint2;
    }

    public String getLoginHint3() {
        return loginHint3;
    }

    public void setLoginHint3(String loginHint3) {
        this.loginHint3 = loginHint3;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.AppUser[ id=" + id + " ]";
    }
    
}
