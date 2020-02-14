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

/**
 *
 * @author John
 */
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

    public CountryRegionCurrency() {
    }

    public CountryRegionCurrency(CountryRegionCurrencyPK countryRegionCurrencyPK) {
        this.countryRegionCurrencyPK = countryRegionCurrencyPK;
    }

    public CountryRegionCurrency(CountryRegionCurrencyPK countryRegionCurrencyPK, Date modifiedDate) {
        this.countryRegionCurrencyPK = countryRegionCurrencyPK;
        this.modifiedDate = modifiedDate;
    }

    public CountryRegionCurrency(String countryRegionCode, String currencyCode) {
        this.countryRegionCurrencyPK = new CountryRegionCurrencyPK(countryRegionCode, currencyCode);
    }

    public CountryRegionCurrencyPK getCountryRegionCurrencyPK() {
        return countryRegionCurrencyPK;
    }

    public void setCountryRegionCurrencyPK(CountryRegionCurrencyPK countryRegionCurrencyPK) {
        this.countryRegionCurrencyPK = countryRegionCurrencyPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryRegionCurrencyPK != null ? countryRegionCurrencyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryRegionCurrency)) {
            return false;
        }
        CountryRegionCurrency other = (CountryRegionCurrency) object;
        if ((this.countryRegionCurrencyPK == null && other.countryRegionCurrencyPK != null) || (this.countryRegionCurrencyPK != null && !this.countryRegionCurrencyPK.equals(other.countryRegionCurrencyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.CountryRegionCurrency[ countryRegionCurrencyPK=" + countryRegionCurrencyPK + " ]";
    }
    
}
