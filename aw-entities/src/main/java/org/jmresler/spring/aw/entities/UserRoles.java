package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "UserRoles", catalog = "AdventureWorks2017", schema = "HumanResources")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
		@NamedQuery(name = "UserRoles.findById", query = "SELECT u FROM UserRoles u WHERE u.id = :id"),
		@NamedQuery(name = "UserRoles.findByRoleName", query = "SELECT u FROM UserRoles u WHERE u.roleName = :roleName") })
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Long id;
	@Basic(optional = false)
	@Column(name = "RoleName")
	private String roleName;
	@JoinColumn(name = "AppUserID_FK", referencedColumnName = "ID")
	@ManyToOne
	private AppUser appUserIDFK;

	public UserRoles() {
	}

	public UserRoles(Long id) {
		this.id = id;
	}

	public UserRoles(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public AppUser getAppUserIDFK() {
		return appUserIDFK;
	}

	public void setAppUserIDFK(AppUser appUserIDFK) {
		this.appUserIDFK = appUserIDFK;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.id);
		hash = 67 * hash + Objects.hashCode(this.roleName);
		hash = 67 * hash + Objects.hashCode(this.appUserIDFK);
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
		final UserRoles other = (UserRoles) obj;
		if (!Objects.equals(this.roleName, other.roleName)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.appUserIDFK, other.appUserIDFK)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.jmresler.spring.aw.entities.UserRoles[ id=" + id + " ]";
	}

}
