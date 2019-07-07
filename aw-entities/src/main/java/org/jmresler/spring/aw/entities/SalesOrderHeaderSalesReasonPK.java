/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author John
 */
@Embeddable
public class SalesOrderHeaderSalesReasonPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SalesOrderID")
    private int salesOrderID;
    @Basic(optional = false)
    @Column(name = "SalesReasonID")
    private int salesReasonID;

    public SalesOrderHeaderSalesReasonPK() {
    }

    public SalesOrderHeaderSalesReasonPK(int salesOrderID, int salesReasonID) {
        this.salesOrderID = salesOrderID;
        this.salesReasonID = salesReasonID;
    }

    public int getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getSalesReasonID() {
        return salesReasonID;
    }

    public void setSalesReasonID(int salesReasonID) {
        this.salesReasonID = salesReasonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) salesOrderID;
        hash += (int) salesReasonID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderHeaderSalesReasonPK)) {
            return false;
        }
        SalesOrderHeaderSalesReasonPK other = (SalesOrderHeaderSalesReasonPK) object;
        if (this.salesOrderID != other.salesOrderID) {
            return false;
        }
        if (this.salesReasonID != other.salesReasonID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesOrderHeaderSalesReasonPK[ salesOrderID=" + salesOrderID + ", salesReasonID=" + salesReasonID + " ]";
    }
    
}
