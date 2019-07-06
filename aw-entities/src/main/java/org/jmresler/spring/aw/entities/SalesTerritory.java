package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
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
@Table(name = "SalesTerritory", schema = "Sales", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesTerritory.findAll", query = "SELECT s FROM SalesTerritory s"),
    @NamedQuery(name = "SalesTerritory.findByTerritoryID", query = "SELECT s FROM SalesTerritory s WHERE s.territoryID = :territoryID"),
    @NamedQuery(name = "SalesTerritory.findByCountryRegionCode", query = "SELECT s FROM SalesTerritory s WHERE s.countryRegionCode = :countryRegionCode"),
    @NamedQuery(name = "SalesTerritory.findByGroup", query = "SELECT s FROM SalesTerritory s WHERE s.group = :group"),
    @NamedQuery(name = "SalesTerritory.findBySalesYTD", query = "SELECT s FROM SalesTerritory s WHERE s.salesYTD = :salesYTD"),
    @NamedQuery(name = "SalesTerritory.findBySalesLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.salesLastYear = :salesLastYear"),
    @NamedQuery(name = "SalesTerritory.findByCostYTD", query = "SELECT s FROM SalesTerritory s WHERE s.costYTD = :costYTD"),
    @NamedQuery(name = "SalesTerritory.findByCostLastYear", query = "SELECT s FROM SalesTerritory s WHERE s.costLastYear = :costLastYear"),
    @NamedQuery(name = "SalesTerritory.findByRowguid", query = "SELECT s FROM SalesTerritory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTerritory.findByModifiedDate", query = "SELECT s FROM SalesTerritory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TerritoryID", nullable = false)
    private Integer territoryID;
    @Basic(optional = false)
    @Column(name = "CountryRegionCode", nullable = false, length = 3)
    private String countryRegionCode;
    @Basic(optional = false)
    @Column(name = "Group", nullable = false, length = 50)
    private String group;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SalesYTD", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesLastYear;
    @Basic(optional = false)
    @Column(name = "CostYTD", nullable = false, precision = 19, scale = 4)
    private BigDecimal costYTD;
    @Basic(optional = false)
    @Column(name = "CostLastYear", nullable = false, precision = 19, scale = 4)
    private BigDecimal costLastYear;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(mappedBy = "territoryID")
    private Collection<Customer> customerCollection;
    @XmlTransient
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesPerson> salesPersonCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesTerritory")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    @XmlTransient
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

    public SalesTerritory(Integer territoryID) {
        this.territoryID = territoryID;
    }
}
