package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author johnm
 */
@Entity
@Table(name = "AppUser", catalog = "AdventureWorks2017", schema = "HumanResources")
@NamedQueries({ @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
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
		@NamedQuery(name = "AppUser.findByLastUpdate", query = "SELECT a FROM AppUser a WHERE a.lastUpdate = :lastUpdate"),
		@NamedQuery(name = "AppUser.findByAppUserIdFK", query = "SELECT a FROM AppUser a WHERE a.appUserIdFK = :appUserIdFK") })
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
	private int loginAttempts;
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
	@Basic(optional = false)
	@Column(name = "IsActive")
	private boolean isActive;
	@Basic(optional = false)
	@Column(name = "LastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@Basic(optional = false)
	@Column(name = "AppUserIdFK")
	private long appUserIdFK;
	@JoinTable(name = "AppUserRole", joinColumns = {
			@JoinColumn(name = "UserId", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "UserRoleId", referencedColumnName = "ID") })
	@ManyToMany
	private List<UserRoles> userRoleList;

	public AppUser() {
	}

	public AppUser(Long id) {
		this.id = id;
	}

	public AppUser(Long id, String userName, String password, int loginAttempts, String loginHint1,
			String loginHintAnswer1, String loginHint2, String loginHintAnswer2, String loginHint3,
			String loginHintAnswer3, boolean isActive, Date lastUpdate, long appUserIdFK) {
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
		this.isActive = isActive;
		this.lastUpdate = lastUpdate;
		this.appUserIdFK = appUserIdFK;
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

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
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

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public long getAppUserIdFK() {
		return appUserIdFK;
	}

	public void setAppUserIdFK(long appUserIdFK) {
		this.appUserIdFK = appUserIdFK;
	}

	public List<UserRoles> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoles> userRoleList) {
		this.userRoleList = userRoleList;
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
		return "org.jmresler.aw.entities.AppUser[ id=" + id + " ]";
	}

}
