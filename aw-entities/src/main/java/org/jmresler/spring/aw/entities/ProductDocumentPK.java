package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
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
public class ProductDocumentPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6648476092677720769L;
	@Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Lob
    @Column(name = "DocumentNode", nullable = false)
    private byte[] documentNode;
}
