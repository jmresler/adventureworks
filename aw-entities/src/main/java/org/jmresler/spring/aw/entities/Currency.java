/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "Currency", catalog = "AdventureWorks2017", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "Currency.findByModifiedDate", query = "SELECT c FROM Currency c WHERE c.modifiedDate = :modifiedDate")})
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CurrencyCode")
    private String currencyCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toCurrencyCode")
    private Collection<CurrencyRate> currencyRateCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency")
    private Collection<CountryRegionCurrency> countryRegionCurrencyCollection;

    public Currency() {
    }

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Currency(String currencyCode, Date modifiedDate) {
        this.currencyCode = currencyCode;
        this.modifiedDate = modifiedDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<CurrencyRate> getCurrencyRateCollection() {
        return currencyRateCollection;
    }

    public void setCurrencyRateCollection(Collection<CurrencyRate> currencyRateCollection) {
        this.currencyRateCollection = currencyRateCollection;
    }

    @XmlTransient
    public Collection<CurrencyRate> getCurrencyRateCollection1() {
        return currencyRateCollection1;
    }

    public void setCurrencyRateCollection1(Collection<CurrencyRate> currencyRateCollection1) {
        this.currencyRateCollection1 = currencyRateCollection1;
    }

    @XmlTransient
    public Collection<CountryRegionCurrency> getCountryRegionCurrencyCollection() {
        return countryRegionCurrencyCollection;
    }

    public void setCountryRegionCurrencyCollection(Collection<CountryRegionCurrency> countryRegionCurrencyCollection) {
        this.countryRegionCurrencyCollection = countryRegionCurrencyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyCode != null ? currencyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyCode == null && other.currencyCode != null) || (this.currencyCode != null && !this.currencyCode.equals(other.currencyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Currency[ currencyCode=" + currencyCode + " ]";
    }
    
}
