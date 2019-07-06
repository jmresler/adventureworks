/**
 * 
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author John
 *
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AppUser", schema = "HumanResources")
@XmlRootElement
public class AppUser implements Serializable {
	
	private static final long serialVersionUID = 3090634858751634296L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name="UserName", nullable = false)
    private String userName;
    @Column(name="Password", nullable = false)
    private String password;
    @Column(name="LoginAttempts", nullable = false)
    private Short loginAttempts;
    @Column(name="LoginHint1", nullable = false)
    private String loginHint1;
    @Column(name="LoginHint2", nullable = false)
    private String loginHint2;
    @Column(name="LoginHint3", nullable = false)
    private String loginHint3;
    @Column(name="IsActive", nullable = false)
    private Boolean isActive;
    private Timestamp lastUpdate;
    
    public AppUser(long id) {
    	this.id = id;
    }
	
}
