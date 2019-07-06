package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "StateProvince", schema = "Person")
@XmlRootElement
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
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateProvinceID")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "CountryRegionCode", referencedColumnName = "CountryRegionCode")
    @ManyToOne(optional = false)
    private CountryRegion countryRegionCode;

    public StateProvince(Integer stateProvinceID) {
        this.stateProvinceID = stateProvinceID;
    }
}
