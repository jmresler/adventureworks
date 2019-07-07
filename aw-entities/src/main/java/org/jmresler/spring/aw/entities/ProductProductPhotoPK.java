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
public class ProductProductPhotoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "ProductPhotoID")
    private int productPhotoID;

    public ProductProductPhotoPK() {
    }

    public ProductProductPhotoPK(int productID, int productPhotoID) {
        this.productID = productID;
        this.productPhotoID = productPhotoID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductPhotoID() {
        return productPhotoID;
    }

    public void setProductPhotoID(int productPhotoID) {
        this.productPhotoID = productPhotoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        hash += (int) productPhotoID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductProductPhotoPK)) {
            return false;
        }
        ProductProductPhotoPK other = (ProductProductPhotoPK) object;
        if (this.productID != other.productID) {
            return false;
        }
        if (this.productPhotoID != other.productPhotoID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductProductPhotoPK[ productID=" + productID + ", productPhotoID=" + productPhotoID + " ]";
    }
    
}
