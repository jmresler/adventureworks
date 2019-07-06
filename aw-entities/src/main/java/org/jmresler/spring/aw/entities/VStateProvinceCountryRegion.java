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
@Table(name = "vStateProvinceCountryRegion", schema = "Person")
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
    
}
