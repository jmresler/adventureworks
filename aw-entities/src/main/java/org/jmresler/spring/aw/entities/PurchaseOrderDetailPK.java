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
public class PurchaseOrderDetailPK implements Serializable {

	private static final long serialVersionUID = 244557690558845859L;
	@Basic(optional = false)
    @Column(name = "PurchaseOrderID")
    private int purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "PurchaseOrderDetailID")
    private int purchaseOrderDetailID;

    public PurchaseOrderDetailPK() {
    }

    public PurchaseOrderDetailPK(int purchaseOrderID, int purchaseOrderDetailID) {
        this.purchaseOrderID = purchaseOrderID;
        this.purchaseOrderDetailID = purchaseOrderDetailID;
    }

    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public int getPurchaseOrderDetailID() {
        return purchaseOrderDetailID;
    }

    public void setPurchaseOrderDetailID(int purchaseOrderDetailID) {
        this.purchaseOrderDetailID = purchaseOrderDetailID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) purchaseOrderID;
        hash += (int) purchaseOrderDetailID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetailPK)) {
            return false;
        }
        PurchaseOrderDetailPK other = (PurchaseOrderDetailPK) object;
        if (this.purchaseOrderID != other.purchaseOrderID) {
            return false;
        }
        if (this.purchaseOrderDetailID != other.purchaseOrderDetailID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PurchaseOrderDetailPK[ purchaseOrderID=" + purchaseOrderID + ", purchaseOrderDetailID=" + purchaseOrderDetailID + " ]";
    }
    
}
