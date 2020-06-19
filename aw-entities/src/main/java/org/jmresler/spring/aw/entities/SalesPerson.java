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
import lombok.Setter;


/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SalesPerson", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SalesPerson.findAll", query = "SELECT s FROM SalesPerson s"),
    @NamedQuery(name = "SalesPerson.findByBusinessEntityID", query = "SELECT s FROM SalesPerson s WHERE s.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesPerson.findBySalesQuota", query = "SELECT s FROM SalesPerson s WHERE s.salesQuota = :salesQuota"),
    @NamedQuery(name = "SalesPerson.findByBonus", query = "SELECT s FROM SalesPerson s WHERE s.bonus = :bonus"),
    @NamedQuery(name = "SalesPerson.findByCommissionPct", query = "SELECT s FROM SalesPerson s WHERE s.commissionPct = :commissionPct"),
    @NamedQuery(name = "SalesPerson.findBySalesYTD", query = "SELECT s FROM SalesPerson s WHERE s.salesYTD = :salesYTD"),
    @NamedQuery(name = "SalesPerson.findBySalesLastYear", query = "SELECT s FROM SalesPerson s WHERE s.salesLastYear = :salesLastYear"),
    @NamedQuery(name = "SalesPerson.findByRowguid", query = "SELECT s FROM SalesPerson s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesPerson.findByModifiedDate", query = "SELECT s FROM SalesPerson s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
    @Basic(optional = false)
    @Column(name = "Bonus")
    private BigDecimal bonus;
    @Basic(optional = false)
    @Column(name = "CommissionPct")
    private BigDecimal commissionPct;
    @Basic(optional = false)
    @Column(name = "SalesYTD")
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear")
    private BigDecimal salesLastYear;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<Store> storeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesPersonQuotaHistory> salesPersonQuotaHistoryCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
