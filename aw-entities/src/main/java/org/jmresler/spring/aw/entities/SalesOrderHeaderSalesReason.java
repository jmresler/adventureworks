/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "SalesOrderHeaderSalesReason", catalog = "AdventureWorks2017", schema = "Sales")
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
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "SalesOrderID", referencedColumnName = "SalesOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesOrderHeader salesOrderHeader;
    @JoinColumn(name = "SalesReasonID", referencedColumnName = "SalesReasonID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SalesReason salesReason;

    public SalesOrderHeaderSalesReason() {
    }

    public SalesOrderHeaderSalesReason(SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK) {
        this.salesOrderHeaderSalesReasonPK = salesOrderHeaderSalesReasonPK;
    }

    public SalesOrderHeaderSalesReason(SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK, Date modifiedDate) {
        this.salesOrderHeaderSalesReasonPK = salesOrderHeaderSalesReasonPK;
        this.modifiedDate = modifiedDate;
    }

    public SalesOrderHeaderSalesReason(int salesOrderID, int salesReasonID) {
        this.salesOrderHeaderSalesReasonPK = new SalesOrderHeaderSalesReasonPK(salesOrderID, salesReasonID);
    }

    public SalesOrderHeaderSalesReasonPK getSalesOrderHeaderSalesReasonPK() {
        return salesOrderHeaderSalesReasonPK;
    }

    public void setSalesOrderHeaderSalesReasonPK(SalesOrderHeaderSalesReasonPK salesOrderHeaderSalesReasonPK) {
        this.salesOrderHeaderSalesReasonPK = salesOrderHeaderSalesReasonPK;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public SalesOrderHeader getSalesOrderHeader() {
        return salesOrderHeader;
    }

    public void setSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
        this.salesOrderHeader = salesOrderHeader;
    }

    public SalesReason getSalesReason() {
        return salesReason;
    }

    public void setSalesReason(SalesReason salesReason) {
        this.salesReason = salesReason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesOrderHeaderSalesReasonPK != null ? salesOrderHeaderSalesReasonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderHeaderSalesReason)) {
            return false;
        }
        SalesOrderHeaderSalesReason other = (SalesOrderHeaderSalesReason) object;
        if ((this.salesOrderHeaderSalesReasonPK == null && other.salesOrderHeaderSalesReasonPK != null) || (this.salesOrderHeaderSalesReasonPK != null && !this.salesOrderHeaderSalesReasonPK.equals(other.salesOrderHeaderSalesReasonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesOrderHeaderSalesReason[ salesOrderHeaderSalesReasonPK=" + salesOrderHeaderSalesReasonPK + " ]";
    }
    
}
