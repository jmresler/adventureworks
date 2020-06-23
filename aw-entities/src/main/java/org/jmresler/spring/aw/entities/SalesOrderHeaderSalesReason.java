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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "SalesOrderHeaderSalesReason", catalog = "AdventureWorks2017", schema = "Sales")
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
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    
    @JsonBackReference
    @JoinColumn(name = "SalesReasonID", referencedColumnName = "SalesReasonID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesReason salesReason;


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
