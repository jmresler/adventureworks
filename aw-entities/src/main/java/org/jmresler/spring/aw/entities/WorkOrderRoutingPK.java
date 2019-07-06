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
public class WorkOrderRoutingPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6383223373468488386L;
	@Basic(optional = false)
    @Column(name = "WorkOrderID", nullable = false)
    private int workOrderID;
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Column(name = "OperationSequence", nullable = false)
    private short operationSequence;
    
}
