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
public class ProductModelIllustrationPK implements Serializable {

	private static final long serialVersionUID = -4823937484303048573L;
	@Basic(optional = false)
    @Column(name = "ProductModelID")
    private int productModelID;
    @Basic(optional = false)
    @Column(name = "IllustrationID")
    private int illustrationID;

    public ProductModelIllustrationPK() {
    }

    public ProductModelIllustrationPK(int productModelID, int illustrationID) {
        this.productModelID = productModelID;
        this.illustrationID = illustrationID;
    }

    public int getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(int productModelID) {
        this.productModelID = productModelID;
    }

    public int getIllustrationID() {
        return illustrationID;
    }

    public void setIllustrationID(int illustrationID) {
        this.illustrationID = illustrationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productModelID;
        hash += (int) illustrationID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModelIllustrationPK)) {
            return false;
        }
        ProductModelIllustrationPK other = (ProductModelIllustrationPK) object;
        if (this.productModelID != other.productModelID) {
            return false;
        }
        if (this.illustrationID != other.illustrationID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductModelIllustrationPK[ productModelID=" + productModelID + ", illustrationID=" + illustrationID + " ]";
    }
    
}
