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
public class ProductModelProductDescriptionCulturePK implements Serializable {

	private static final long serialVersionUID = -8415180753235183696L;

	@Basic(optional = false)
    @Column(name = "ProductModelID")
    private int productModelID;
    @Basic(optional = false)
    @Column(name = "ProductDescriptionID")
    private int productDescriptionID;
    @Basic(optional = false)
    @Column(name = "CultureID")
    private String cultureID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
