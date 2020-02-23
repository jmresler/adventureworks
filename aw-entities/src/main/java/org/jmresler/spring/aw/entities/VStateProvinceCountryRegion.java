package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author John
 */
@Entity
@Table(name = "vStateProvinceCountryRegion", catalog = "AdventureWorks2017", schema = "Person")

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

	@Override
	public int hashCode() {
		return Objects.hash(countryRegionCode, stateProvinceCode, stateProvinceID, territoryID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VStateProvinceCountryRegion other = (VStateProvinceCountryRegion) obj;
		return Objects.equals(countryRegionCode, other.countryRegionCode)
				&& Objects.equals(stateProvinceCode, other.stateProvinceCode)
				&& stateProvinceID == other.stateProvinceID && territoryID == other.territoryID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VStateProvinceCountryRegion [stateProvinceID=")
				.append(stateProvinceID)
				.append(", stateProvinceCode=")
				.append(stateProvinceCode)
				.append(", territoryID=")
				.append(territoryID)
				.append(", countryRegionCode=")
				.append(countryRegionCode)
				.append("]");
		return builder.toString();
	}
    
    
    
}
