package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SalesTerritory", catalog = "AdventureWorks2017", schema = "Sales")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TerritoryID")
    private Integer territoryID;
    
    @Basic(optional = false)
    @Column(name = "CountryRegionCode")
    private String countryRegionCode;
    
    // FIXME - This fix, using [Group] would break standardized JPA (I believe)
    //  
    // 		    SQL Server notoriously uses non-standard SQL such as allowing databases
    // 		    to have terms that map to SQL clauses such as group... as a result, the
    // 		    short term fix is to add braces to each side to distinguish the Group
    // 		    column name
    @Basic(optional = false)
    @Column(name = "[Group]")
    private String group;
    
    @Basic(optional = false)
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    
    @Basic(optional = false)
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
    
    @Basic(optional = false)
    @Column(name = "CostYTD")
    private BigDecimal costYTD;
    
    @Basic(optional = false)
    @Column(name = "CostLastYear")
    private BigDecimal costLastYear;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @OneToMany(mappedBy = "territoryID")
    private Collection<Customer> customerCollection;
    
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesPerson> salesPersonCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesTerritory")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    
    @OneToMany(mappedBy = "territoryID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

    @Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
