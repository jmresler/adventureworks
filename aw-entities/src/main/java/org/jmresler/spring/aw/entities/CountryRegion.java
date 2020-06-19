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
@Table(name = "CountryRegion", catalog = "AdventureWorks2017", schema = "Person")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
