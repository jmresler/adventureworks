package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductInventoryPK implements Serializable {

	private static final long serialVersionUID = -8614896804358874816L;

	@Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "LocationID")
    private short locationID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
