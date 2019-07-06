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
import javax.persistence.UniqueConstraint;
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
@Table(name = "SalesTerritoryHistory", schema = "Sales", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesPerson salesPerson;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesTerritory salesTerritory;

    public SalesTerritoryHistory(SalesTerritoryHistoryPK salesTerritoryHistoryPK) {
        this.salesTerritoryHistoryPK = salesTerritoryHistoryPK;
    }
    
}
