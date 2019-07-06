package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PurchaseOrderDetailPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7174514206764917942L;
	
	@Basic(optional = false)
    @Column(name = "PurchaseOrderID", nullable = false)
    private int purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "PurchaseOrderDetailID", nullable = false)
    private int purchaseOrderDetailID;    
}
