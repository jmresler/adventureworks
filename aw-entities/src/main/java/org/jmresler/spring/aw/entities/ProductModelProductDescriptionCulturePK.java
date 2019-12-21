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
public class ProductModelProductDescriptionCulturePK implements Serializable {

	private static final long serialVersionUID = -8415180753235183696L;
	@Basic(optional = false)
    @Column(name = "ProductModelID")
    private int productModelID;
    @Basic(optional = false)
    @Column(name = "ProductDescriptionID")
    private int productDescriptionID;
    @Basic(optional = false)
    @Column(name = "CultureID")
    private String cultureID;

    public ProductModelProductDescriptionCulturePK() {
    }

    public ProductModelProductDescriptionCulturePK(int productModelID, int productDescriptionID, String cultureID) {
        this.productModelID = productModelID;
        this.productDescriptionID = productDescriptionID;
        this.cultureID = cultureID;
    }

    public int getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(int productModelID) {
        this.productModelID = productModelID;
    }

    public int getProductDescriptionID() {
        return productDescriptionID;
    }

    public void setProductDescriptionID(int productDescriptionID) {
        this.productDescriptionID = productDescriptionID;
    }

    public String getCultureID() {
        return cultureID;
    }

    public void setCultureID(String cultureID) {
        this.cultureID = cultureID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productModelID;
        hash += (int) productDescriptionID;
        hash += (cultureID != null ? cultureID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModelProductDescriptionCulturePK)) {
            return false;
        }
        ProductModelProductDescriptionCulturePK other = (ProductModelProductDescriptionCulturePK) object;
        if (this.productModelID != other.productModelID) {
            return false;
        }
        if (this.productDescriptionID != other.productDescriptionID) {
            return false;
        }
        if ((this.cultureID == null && other.cultureID != null) || (this.cultureID != null && !this.cultureID.equals(other.cultureID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductModelProductDescriptionCulturePK[ productModelID=" + productModelID + ", productDescriptionID=" + productDescriptionID + ", cultureID=" + cultureID + " ]";
    }
    
}
