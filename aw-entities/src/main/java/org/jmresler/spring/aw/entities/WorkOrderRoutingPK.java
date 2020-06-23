/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class WorkOrderRoutingPK implements Serializable {

	private static final long serialVersionUID = -3004998570935904636L;
	
	@Basic(optional = false)
    @Column(name = "WorkOrderID")
    private int workOrderID;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "OperationSequence")
    private short operationSequence;


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
