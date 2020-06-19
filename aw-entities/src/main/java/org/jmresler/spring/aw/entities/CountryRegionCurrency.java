package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@Table(name = "CountryRegionCurrency", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "CountryRegionCurrency.findAll", query = "SELECT c FROM CountryRegionCurrency c"),
    @NamedQuery(name = "CountryRegionCurrency.findByCountryRegionCode", query = "SELECT c FROM CountryRegionCurrency c WHERE c.countryRegionCurrencyPK.countryRegionCode = :countryRegionCode"),
    @NamedQuery(name = "CountryRegionCurrency.findByCurrencyCode", query = "SELECT c FROM CountryRegionCurrency c WHERE c.countryRegionCurrencyPK.currencyCode = :currencyCode"),
    @NamedQuery(name = "CountryRegionCurrency.findByModifiedDate", query = "SELECT c FROM CountryRegionCurrency c WHERE c.modifiedDate = :modifiedDate")})
public class CountryRegionCurrency implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CountryRegionCurrencyPK countryRegionCurrencyPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CurrencyCode", referencedColumnName = "CurrencyCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Currency currency;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
