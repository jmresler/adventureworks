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
import javax.xml.bind.annotation.XmlRootElement;
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
@Entity
@Table(name = "CountryRegionCurrency", schema = "Sales")
@XmlRootElement
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
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CurrencyCode", referencedColumnName = "CurrencyCode", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Currency currency;

    public CountryRegionCurrency(CountryRegionCurrencyPK countryRegionCurrencyPK) {
        this.countryRegionCurrencyPK = countryRegionCurrencyPK;
    }
    
}
