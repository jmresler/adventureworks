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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Embeddable
public class ProductListPriceHistoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    public ProductListPriceHistoryPK() {
    }

    public ProductListPriceHistoryPK(int productID, Date startDate) {
        this.productID = productID;
        this.startDate = startDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        hash += (startDate != null ? startDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductListPriceHistoryPK)) {
            return false;
        }
        ProductListPriceHistoryPK other = (ProductListPriceHistoryPK) object;
        if (this.productID != other.productID) {
            return false;
        }
        if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductListPriceHistoryPK[ productID=" + productID + ", startDate=" + startDate + " ]";
    }
    
}
