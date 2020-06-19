/**
 * 
 */
package org.jmresler.spring.aw.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author johnm
 *
 */
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@NamedQueries(value = 
	{@NamedQuery(name = "CommonPasswords.findAll", query = "SELECT p From CommonPasswords p"),
	 @NamedQuery(name = "CommonPasswords.findPassword", query = "SELECT p FROM CommonPasswords p WHERE p.password = :password")})
@Table(name = "CommonPasswords", catalog = "AdventureWorks2017", schema = "System")
public class CommonPasswords {
	
	@Id
	private String password;

	
	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
