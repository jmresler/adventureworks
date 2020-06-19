/**
 * 
 */
package org.jmresler.spring.aw.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author johnm
 *
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MOTD", catalog="AdventureWorks2017", schema="System")
public class MessageOfTheDay {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
	private int id;
	@Basic(optional = false)
	@Column(name="Message")
	private String message;
	@Basic(optional=false)
	@Column(name="StartDateTime")
	private Date startDateTime;
	@Basic(optional=false)
	@Column(name="EndDateTime")
	private Date endDateTime;
	@Basic(optional=false)
	@Column(name="LastUpdate")
	private Timestamp lastUpdate;
	
	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
