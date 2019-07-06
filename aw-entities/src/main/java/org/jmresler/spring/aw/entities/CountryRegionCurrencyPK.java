package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class CountryRegionCurrencyPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3203122712907731708L;
	@Basic(optional = false)
    @Column(name = "CountryRegionCode", nullable = false, length = 3)
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "CurrencyCode", nullable = false, length = 3)
    private String currencyCode;
}
