package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class BusinessEntityContactPK implements Serializable {

	private static final long serialVersionUID = 0L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "PersonID")
    private int personID;
    @Basic(optional = false)
    @Column(name = "ContactTypeID")
    private int contactTypeID;


	@Override
	public String toString() {
		return getClass().getName() + "[bizEntID: " + businessEntityID + ", personID: " + personID + "]"; 
	}
}
