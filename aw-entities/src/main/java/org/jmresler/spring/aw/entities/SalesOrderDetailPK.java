package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@Embeddable
public class SalesOrderDetailPK implements Serializable {

	private static final long serialVersionUID = -3593922870029780321L;

	@Basic(optional = false)
    @Column(name = "SalesOrderID")
    private int salesOrderID;
    @Basic(optional = false)
    @Column(name = "SalesOrderDetailID")
    private int salesOrderDetailID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
