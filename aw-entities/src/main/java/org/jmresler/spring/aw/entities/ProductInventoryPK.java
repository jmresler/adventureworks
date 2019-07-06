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
public class ProductInventoryPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1634200726867793981L;
	
	@Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Column(name = "LocationID", nullable = false)
    private short locationID;    
}
