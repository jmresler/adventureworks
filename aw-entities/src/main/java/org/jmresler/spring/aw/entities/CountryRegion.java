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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CountryRegion", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryRegion.findAll", query = "SELECT c FROM CountryRegion c"),
    @NamedQuery(name = "CountryRegion.findByCountryRegionCode", query = "SELECT c FROM CountryRegion c WHERE c.countryRegionCode = :countryRegionCode"),
    @NamedQuery(name = "CountryRegion.findByModifiedDate", query = "SELECT c FROM CountryRegion c WHERE c.modifiedDate = :modifiedDate")})
public class CountryRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryRegionCode")
    private Collection<StateProvince> stateProvinceCollection;

    public CountryRegion() {
    }

    public CountryRegion(String countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }

    public CountryRegion(String countryRegionCode, Date modifiedDate) {
        this.countryRegionCode = countryRegionCode;
        this.modifiedDate = modifiedDate;
    }

    public String getCountryRegionCode() {
        return countryRegionCode;
    }

    public void setCountryRegionCode(String countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<StateProvince> getStateProvinceCollection() {
        return stateProvinceCollection;
    }

    public void setStateProvinceCollection(Collection<StateProvince> stateProvinceCollection) {
        this.stateProvinceCollection = stateProvinceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryRegionCode != null ? countryRegionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryRegion)) {
            return false;
        }
        CountryRegion other = (CountryRegion) object;
        if ((this.countryRegionCode == null && other.countryRegionCode != null) || (this.countryRegionCode != null && !this.countryRegionCode.equals(other.countryRegionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.CountryRegion[ countryRegionCode=" + countryRegionCode + " ]";
    }
    
}
