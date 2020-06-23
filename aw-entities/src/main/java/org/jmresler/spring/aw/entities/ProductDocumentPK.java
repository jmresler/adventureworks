package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
