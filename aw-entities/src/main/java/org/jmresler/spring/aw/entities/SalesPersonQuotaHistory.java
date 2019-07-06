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
@Table(name = "SalesPersonQuotaHistory", schema = "Sales", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SalesQuota", nullable = false, precision = 19, scale = 4)
    private BigDecimal salesQuota;
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

    public SalesPersonQuotaHistory(SalesPersonQuotaHistoryPK salesPersonQuotaHistoryPK) {
        this.salesPersonQuotaHistoryPK = salesPersonQuotaHistoryPK;
    }    
}
