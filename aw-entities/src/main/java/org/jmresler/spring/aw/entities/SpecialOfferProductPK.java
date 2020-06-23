package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
@Embeddable
public class SpecialOfferProductPK implements Serializable {

	private static final long serialVersionUID = 4615784628738305583L;

	@Basic(optional = false)
    @Column(name = "SpecialOfferID")
    private int specialOfferID;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
