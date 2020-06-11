/**
 * 
 */
package org.jmresler.spring.aw.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author johnm
 *
 */
@Entity
@Table(name = "CommonPasswords", catalog = "AdventureWorks2017", schema = "Person")
public class CommonPasswords {
	
	@Id
	private String password;
	
	public CommonPasswords(String password) {
		this.password = password;
	}
	
	public String getCommonPassword() {
		return password;
	}
	
}
