package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SalesTerritoryHistory", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SalesTerritoryHistory.findAll", query = "SELECT s FROM SalesTerritoryHistory s"),
    @NamedQuery(name = "SalesTerritoryHistory.findByBusinessEntityID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesTerritoryHistory.findByTerritoryID", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.territoryID = :territoryID"),
    @NamedQuery(name = "SalesTerritoryHistory.findByStartDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.salesTerritoryHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "SalesTerritoryHistory.findByEndDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SalesTerritoryHistory.findByRowguid", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTerritoryHistory.findByModifiedDate", query = "SELECT s FROM SalesTerritoryHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTerritoryHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SalesTerritoryHistoryPK salesTerritoryHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesPerson salesPerson;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesTerritory salesTerritory;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
