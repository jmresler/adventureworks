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
public class SalesOrderDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SalesOrderID")
    private int salesOrderID;
    @Basic(optional = false)
    @Column(name = "SalesOrderDetailID")
    private int salesOrderDetailID;

    public SalesOrderDetailPK() {
    }

    public SalesOrderDetailPK(int salesOrderID, int salesOrderDetailID) {
        this.salesOrderID = salesOrderID;
        this.salesOrderDetailID = salesOrderDetailID;
    }

    public int getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getSalesOrderDetailID() {
        return salesOrderDetailID;
    }

    public void setSalesOrderDetailID(int salesOrderDetailID) {
        this.salesOrderDetailID = salesOrderDetailID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) salesOrderID;
        hash += (int) salesOrderDetailID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderDetailPK)) {
            return false;
        }
        SalesOrderDetailPK other = (SalesOrderDetailPK) object;
        if (this.salesOrderID != other.salesOrderID) {
            return false;
        }
        if (this.salesOrderDetailID != other.salesOrderDetailID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.SalesOrderDetailPK[ salesOrderID=" + salesOrderID + ", salesOrderDetailID=" + salesOrderDetailID + " ]";
    }
    
}
