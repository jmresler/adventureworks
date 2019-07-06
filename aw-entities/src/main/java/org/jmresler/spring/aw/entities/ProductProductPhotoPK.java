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
public class ProductProductPhotoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 184964012835664259L;
	
	@Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Column(name = "ProductPhotoID", nullable = false)
    private int productPhotoID;    
}
