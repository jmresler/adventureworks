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
public class BusinessEntityAddressPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5677559807910594057L;

	@Basic(optional = false)
	@Column(name = "BusinessEntityID")
	private int businessEntityID;
	@Basic(optional = false)
	@Column(name = "AddressID")
	private int addressID;
	@Basic(optional = false)
	@Column(name = "AddressTypeID")
	private int addressTypeID;

}
