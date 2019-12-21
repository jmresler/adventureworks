package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

/**
 *
 * @author John
 */
@Embeddable
public class ProductDocumentPK implements Serializable {

	private static final long serialVersionUID = -709653329338590593L;
	@Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Lob
    @Column(name = "DocumentNode")
    private byte[] documentNode;

    public ProductDocumentPK() {
    }

    public ProductDocumentPK(int productID, byte[] documentNode) {
        this.productID = productID;
        this.documentNode = documentNode;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public byte[] getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(byte[] documentNode) {
        this.documentNode = documentNode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        hash += (documentNode != null ? documentNode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDocumentPK)) {
            return false;
        }
        ProductDocumentPK other = (ProductDocumentPK) object;
        if (this.productID != other.productID) {
            return false;
        }
        if ((this.documentNode == null && other.documentNode != null) || (this.documentNode != null && !this.documentNode.equals(other.documentNode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductDocumentPK[ productID=" + productID + ", documentNode=" + documentNode + " ]";
    }
    
}
