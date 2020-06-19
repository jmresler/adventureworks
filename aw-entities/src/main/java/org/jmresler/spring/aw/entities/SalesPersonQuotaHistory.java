package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SalesPersonQuotaHistory", catalog = "AdventureWorks2017", schema = "Sales")

@NamedQueries({
    @NamedQuery(name = "SalesPersonQuotaHistory.findAll", query = "SELECT s FROM SalesPersonQuotaHistory s"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByBusinessEntityID", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByQuotaDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesPersonQuotaHistoryPK.quotaDate = :quotaDate"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findBySalesQuota", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.salesQuota = :salesQuota"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByRowguid", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesPersonQuotaHistory.findByModifiedDate", query = "SELECT s FROM SalesPersonQuotaHistory s WHERE s.modifiedDate = :modifiedDate")})
public class SalesPersonQuotaHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK;
    @Basic(optional = false)
    @Column(name = "SalesQuota")
    private BigDecimal salesQuota;
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
