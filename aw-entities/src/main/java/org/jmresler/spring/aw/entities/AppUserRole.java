/**
 *
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p><em>
 * It is quite likely that the table redesign has made this class obsolete. I haven't pulled it yet
 * though because when it did not exist previously, an EclipseLink exception occurred due to a missing
 * entity I believe was related to this object.
 * </em></p>
 * @author johnm
 *
 */
@Entity
@Table(name = "AppUserRole", catalog = "AdventureWorks2017", schema = "HumanResources")
public class AppUserRole implements Serializable {

    @Id
    private long appUserId;
    @Id
    private long userRoleId;

    /**
     *
     */
    public AppUserRole() {
        // TODO Auto-generated constructor stub
    }

    public AppUserRole(long appUserId, long userRoleId) {
        super();
        this.appUserId = appUserId;
        this.userRoleId = userRoleId;
    }

    /**
     * @return the appUserId
     */
    public long getAppUserId() {
        return appUserId;
    }

    /**
     * @param appUserId the appUserId to set
     */
    public void setAppUserId(long appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * @return the userRoleId
     */
    public long getUserRoleId() {
        return userRoleId;
    }

    /**
     * @param userRoleId the userRoleId to set
     */
    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("org.jmresler.aw.entities.AppUserRole [appUserId=");
        builder.append(appUserId);
        builder.append(", userRoleId=");
        builder.append(userRoleId);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, userRoleId);
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
        AppUserRole other = (AppUserRole) obj;
        return appUserId == other.appUserId && userRoleId == other.userRoleId;
    }

}
