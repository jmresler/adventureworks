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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;

import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "StateProvince", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "StateProvince.findAll", query = "SELECT s FROM StateProvince s"),
    @NamedQuery(name = "StateProvince.findByStateProvinceID", query = "SELECT s FROM StateProvince s WHERE s.stateProvinceID = :stateProvinceID"),
    @NamedQuery(name = "StateProvince.findByStateProvinceCode", query = "SELECT s FROM StateProvince s WHERE s.stateProvinceCode = :stateProvinceCode"),
    @NamedQuery(name = "StateProvince.findByTerritoryID", query = "SELECT s FROM StateProvince s WHERE s.territoryID = :territoryID"),
    @NamedQuery(name = "StateProvince.findByRowguid", query = "SELECT s FROM StateProvince s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "StateProvince.findByModifiedDate", query = "SELECT s FROM StateProvince s WHERE s.modifiedDate = :modifiedDate")})
public class StateProvince implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StateProvinceID")
    private Integer stateProvinceID;
    @Basic(optional = false)
    @Column(name = "StateProvinceCode")
    private String stateProvinceCode;
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private int territoryID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateProvinceID")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "CountryRegionCode", referencedColumnName = "CountryRegionCode")
    @ManyToOne(optional = false)
    private CountryRegion countryRegionCode;


	@Override
	public String toString() {
		return getClass().getName() + "[" + stateProvinceCode + "]"; 
	}
}
