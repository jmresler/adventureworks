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
public class SalesOrderHeaderSalesReasonPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7522297745957414910L;
	
	@Basic(optional = false)
    @Column(name = "SalesOrderID", nullable = false)
    private int salesOrderID;
    @Basic(optional = false)
    @Column(name = "SalesReasonID", nullable = false)
    private int salesReasonID;
}
