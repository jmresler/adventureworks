package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

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
public class ProductModelIllustrationPK implements Serializable {

	private static final long serialVersionUID = -4823937484303048573L;

	@Basic(optional = false)
    @Column(name = "ProductModelID")
    private int productModelID;
    @Basic(optional = false)
    @Column(name = "IllustrationID")
    private int illustrationID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
