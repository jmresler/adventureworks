package org.jmresler.spring.aw.entities;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class BusinessEntityAddressPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "AddressID")
    private int addressID;
    @Basic(optional = false)
    @Column(name = "AddressTypeID")
    private int addressTypeID;

	@Override
	public String toString() {
		return getClass().getName() + "[bizEntID: " + businessEntityID + ", addressID: " + addressID + "]"; 
	}
}
