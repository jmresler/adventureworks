package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "Currency", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "Currency.findByModifiedDate", query = "SELECT c FROM Currency c WHERE c.modifiedDate = :modifiedDate")})
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CurrencyCode", nullable = false, length = 3)
    private String currencyCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection1;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency")
    private Collection<CountryRegionCurrency> countryRegionCurrencyCollection;

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
}
