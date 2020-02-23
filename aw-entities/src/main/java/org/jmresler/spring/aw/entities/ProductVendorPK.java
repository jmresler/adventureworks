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
public class ProductVendorPK implements Serializable {

	private static final long serialVersionUID = 6297674065713020340L;

	@Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;

    public ProductVendorPK() {
    }

    public ProductVendorPK(int productID, int businessEntityID) {
        this.productID = productID;
        this.businessEntityID = businessEntityID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        hash += (int) businessEntityID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductVendorPK)) {
            return false;
        }
        ProductVendorPK other = (ProductVendorPK) object;
        if (this.productID != other.productID) {
            return false;
        }
        if (this.businessEntityID != other.businessEntityID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductVendorPK[ productID=" + productID + ", businessEntityID=" + businessEntityID + " ]";
    }
    
}
