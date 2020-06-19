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
public class CountryRegionCurrencyPK implements Serializable {

	private static final long serialVersionUID = 1l;

	@Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "CurrencyCode")
    private String currencyCode;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
