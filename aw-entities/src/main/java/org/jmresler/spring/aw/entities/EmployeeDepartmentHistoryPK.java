package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class EmployeeDepartmentHistoryPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private short departmentID;
    @Basic(optional = false)
    @Column(name = "ShiftID")
    private short shiftID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
