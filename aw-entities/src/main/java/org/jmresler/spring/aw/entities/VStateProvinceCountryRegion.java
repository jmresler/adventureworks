/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@Table(name = "vStateProvinceCountryRegion", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VStateProvinceCountryRegion.findAll", query = "SELECT v FROM VStateProvinceCountryRegion v"),
    @NamedQuery(name = "VStateProvinceCountryRegion.findByStateProvinceID", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.stateProvinceID = :stateProvinceID"),
    @NamedQuery(name = "VStateProvinceCountryRegion.findByStateProvinceCode", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.stateProvinceCode = :stateProvinceCode"),
    @NamedQuery(name = "VStateProvinceCountryRegion.findByTerritoryID", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.territoryID = :territoryID"),
    @NamedQuery(name = "VStateProvinceCountryRegion.findByCountryRegionCode", query = "SELECT v FROM VStateProvinceCountryRegion v WHERE v.countryRegionCode = :countryRegionCode")})
public class VStateProvinceCountryRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "StateProvinceID")
    private int stateProvinceID;
    @Basic(optional = false)
    @Column(name = "StateProvinceCode")
    private String stateProvinceCode;
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private int territoryID;
    @Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;

    public VStateProvinceCountryRegion() {
    }

    public int getStateProvinceID() {
        return stateProvinceID;
    }

    public void setStateProvinceID(int stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
    }

    public int getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(int territoryID) {
        this.territoryID = territoryID;
    }

    public String getCountryRegionCode() {
        return countryRegionCode;
    }

    public void setCountryRegionCode(String countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }
    
}
