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
public class SpecialOfferProductPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5467120618976367215L;
	@Basic(optional = false)
    @Column(name = "SpecialOfferID", nullable = false)
    private int specialOfferID;
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;    
}
