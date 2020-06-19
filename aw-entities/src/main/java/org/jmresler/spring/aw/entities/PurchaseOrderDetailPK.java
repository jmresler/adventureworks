package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PurchaseOrderDetailPK implements Serializable {

	private static final long serialVersionUID = 244557690558845859L;

	@Basic(optional = false)
    @Column(name = "PurchaseOrderID")
    private int purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "PurchaseOrderDetailID")
    private int purchaseOrderDetailID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
