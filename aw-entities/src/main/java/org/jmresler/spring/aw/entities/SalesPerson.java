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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SalesPerson", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private Integer businessEntityID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalesQuota", precision = 19, scale = 4)
    private BigDecimal salesQuota;
    @Basic(optional = false)
    @Column(name = "Bonus", nullable = false, precision = 19, scale = 4)
    private BigDecimal bonus;
    @Basic(optional = false)
    @Column(name = "CommissionPct", nullable = false, precision = 10, scale = 4)
    private BigDecimal commissionPct;
    @Basic(optional = false)
    @Column(name = "SalesYTD", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesYTD;
    @Basic(optional = false)
    @Column(name = "SalesLastYear", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesLastYear;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @XmlTransient
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<Store> storeCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesTerritoryHistory> salesTerritoryHistoryCollection;
    @XmlTransient
    @OneToMany(mappedBy = "salesPersonID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesPerson")
    private Collection<SalesPersonQuotaHistory> salesPersonQuotaHistoryCollection;

    public SalesPerson(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }
}
