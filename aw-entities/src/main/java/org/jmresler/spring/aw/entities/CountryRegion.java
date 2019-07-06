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
@Table(name = "CountryRegion", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryRegion.findAll", query = "SELECT c FROM CountryRegion c"),
    @NamedQuery(name = "CountryRegion.findByCountryRegionCode", query = "SELECT c FROM CountryRegion c WHERE c.countryRegionCode = :countryRegionCode"),
    @NamedQuery(name = "CountryRegion.findByModifiedDate", query = "SELECT c FROM CountryRegion c WHERE c.modifiedDate = :modifiedDate")})
public class CountryRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryRegionCode")
    private Collection<StateProvince> stateProvinceCollection;

    public CountryRegion(String countryRegionCode) {
        this.countryRegionCode = countryRegionCode;
    }
}
