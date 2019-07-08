package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "AppUser.findByLoginHintAnswer1", query = "SELECT a FROM AppUser a WHERE a.loginHintAnswer1 = :loginHintAnswer1"),
    @NamedQuery(name = "AppUser.findByLoginHint2", query = "SELECT a FROM AppUser a WHERE a.loginHint2 = :loginHint2"),
    @NamedQuery(name = "AppUser.findByLoginHintAnswer2", query = "SELECT a FROM AppUser a WHERE a.loginHintAnswer2 = :loginHintAnswer2"),
    @NamedQuery(name = "AppUser.findByLoginHint3", query = "SELECT a FROM AppUser a WHERE a.loginHint3 = :loginHint3"),
    @NamedQuery(name = "AppUser.findByLoginHintAnswer3", query = "SELECT a FROM AppUser a WHERE a.loginHintAnswer3 = :loginHintAnswer3"),
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
    @Column(name = "LoginHintAnswer1")
    private String loginHintAnswer1;
    @Basic(optional = false)
    @Column(name = "LoginHint2")
    private String loginHint2;
    @Basic(optional = false)
    @Column(name = "LoginHintAnswer2")
    private String loginHintAnswer2;
    @Basic(optional = false)
    @Column(name = "LoginHint3")
    private String loginHint3;
    @Basic(optional = false)
    @Column(name = "LoginHintAnswer3")
    private String loginHintAnswer3;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @OneToMany(mappedBy = "appUserIDFK")
    private Collection<UserRoles> userRolesCollection;

    public AppUser() {
    }

    public AppUser(Long id) {
        this.id = id;
    }

    public AppUser(Long id, String userName, String password, short loginAttempts, String loginHint1, String loginHintAnswer1, String loginHint2, String loginHintAnswer2, String loginHint3, String loginHintAnswer3, Date lastUpdate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.loginAttempts = loginAttempts;
        this.loginHint1 = loginHint1;
        this.loginHintAnswer1 = loginHintAnswer1;
        this.loginHint2 = loginHint2;
        this.loginHintAnswer2 = loginHintAnswer2;
        this.loginHint3 = loginHint3;
        this.loginHintAnswer3 = loginHintAnswer3;
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

    public String getLoginHintAnswer1() {
        return loginHintAnswer1;
    }

    public void setLoginHintAnswer1(String loginHintAnswer1) {
        this.loginHintAnswer1 = loginHintAnswer1;
    }

    public String getLoginHint2() {
        return loginHint2;
    }

    public void setLoginHint2(String loginHint2) {
        this.loginHint2 = loginHint2;
    }

    public String getLoginHintAnswer2() {
        return loginHintAnswer2;
    }

    public void setLoginHintAnswer2(String loginHintAnswer2) {
        this.loginHintAnswer2 = loginHintAnswer2;
    }

    public String getLoginHint3() {
        return loginHint3;
    }

    public void setLoginHint3(String loginHint3) {
        this.loginHint3 = loginHint3;
    }

    public String getLoginHintAnswer3() {
        return loginHintAnswer3;
    }

    public void setLoginHintAnswer3(String loginHintAnswer3) {
        this.loginHintAnswer3 = loginHintAnswer3;
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

    @XmlTransient
    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.userName);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + this.loginAttempts;
        hash = 97 * hash + Objects.hashCode(this.loginHint1);
        hash = 97 * hash + Objects.hashCode(this.loginHintAnswer1);
        hash = 97 * hash + Objects.hashCode(this.loginHint2);
        hash = 97 * hash + Objects.hashCode(this.loginHintAnswer2);
        hash = 97 * hash + Objects.hashCode(this.loginHint3);
        hash = 97 * hash + Objects.hashCode(this.loginHintAnswer3);
        hash = 97 * hash + Objects.hashCode(this.isActive);
        hash = 97 * hash + Objects.hashCode(this.lastUpdate);
        hash = 97 * hash + Objects.hashCode(this.userRolesCollection);
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
        final AppUser other = (AppUser) obj;
        if (this.loginAttempts != other.loginAttempts) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.loginHint1, other.loginHint1)) {
            return false;
        }
        if (!Objects.equals(this.loginHintAnswer1, other.loginHintAnswer1)) {
            return false;
        }
        if (!Objects.equals(this.loginHint2, other.loginHint2)) {
            return false;
        }
        if (!Objects.equals(this.loginHintAnswer2, other.loginHintAnswer2)) {
            return false;
        }
        if (!Objects.equals(this.loginHint3, other.loginHint3)) {
            return false;
        }
        if (!Objects.equals(this.loginHintAnswer3, other.loginHintAnswer3)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.isActive, other.isActive)) {
            return false;
        }
        if (!Objects.equals(this.lastUpdate, other.lastUpdate)) {
            return false;
        }
        if (!Objects.equals(this.userRolesCollection, other.userRolesCollection)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.AppUser[ id=" + id + " ]";
    }
    
}
