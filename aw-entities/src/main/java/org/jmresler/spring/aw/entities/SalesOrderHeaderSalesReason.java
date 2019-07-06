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
@Table(name = "SalesOrderHeaderSalesReason", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrderHeaderSalesReason.findAll", query = "SELECT s FROM SalesOrderHeaderSalesReason s"),
    @NamedQuery(name = "SalesOrderHeaderSalesReason.findBySalesOrderID", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.salesOrderHeaderSalesReasonPK.salesOrderID = :salesOrderID"),
    @NamedQuery(name = "SalesOrderHeaderSalesReason.findBySalesReasonID", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.salesOrderHeaderSalesReasonPK.salesReasonID = :salesReasonID"),
    @NamedQuery(name = "SalesOrderHeaderSalesReason.findByModifiedDate", query = "SELECT s FROM SalesOrderHeaderSalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesOrderHeaderSalesReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumn(name = "SalesReasonID", referencedColumnName = "SalesReasonID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesReason salesReason;

    public SalesOrderHeaderSalesReason(SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK) {
        this.salesOrderHeaderSalesReasonPK = salesOrderHeaderSalesReasonPK;
    }    
}
