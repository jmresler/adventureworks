/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Entity
@Table(name = "WorkOrderRouting", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "WorkOrderRouting.findAll", query = "SELECT w FROM WorkOrderRouting w"),
    @NamedQuery(name = "WorkOrderRouting.findByWorkOrderID", query = "SELECT w FROM WorkOrderRouting w WHERE w.workOrderRoutingPK.workOrderID = :workOrderID"),
    @NamedQuery(name = "WorkOrderRouting.findByProductID", query = "SELECT w FROM WorkOrderRouting w WHERE w.workOrderRoutingPK.productID = :productID"),
    @NamedQuery(name = "WorkOrderRouting.findByOperationSequence", query = "SELECT w FROM WorkOrderRouting w WHERE w.workOrderRoutingPK.operationSequence = :operationSequence"),
    @NamedQuery(name = "WorkOrderRouting.findByScheduledStartDate", query = "SELECT w FROM WorkOrderRouting w WHERE w.scheduledStartDate = :scheduledStartDate"),
    @NamedQuery(name = "WorkOrderRouting.findByScheduledEndDate", query = "SELECT w FROM WorkOrderRouting w WHERE w.scheduledEndDate = :scheduledEndDate"),
    @NamedQuery(name = "WorkOrderRouting.findByActualStartDate", query = "SELECT w FROM WorkOrderRouting w WHERE w.actualStartDate = :actualStartDate"),
    @NamedQuery(name = "WorkOrderRouting.findByActualEndDate", query = "SELECT w FROM WorkOrderRouting w WHERE w.actualEndDate = :actualEndDate"),
    @NamedQuery(name = "WorkOrderRouting.findByActualResourceHrs", query = "SELECT w FROM WorkOrderRouting w WHERE w.actualResourceHrs = :actualResourceHrs"),
    @NamedQuery(name = "WorkOrderRouting.findByPlannedCost", query = "SELECT w FROM WorkOrderRouting w WHERE w.plannedCost = :plannedCost"),
    @NamedQuery(name = "WorkOrderRouting.findByActualCost", query = "SELECT w FROM WorkOrderRouting w WHERE w.actualCost = :actualCost"),
    @NamedQuery(name = "WorkOrderRouting.findByModifiedDate", query = "SELECT w FROM WorkOrderRouting w WHERE w.modifiedDate = :modifiedDate")})
public class WorkOrderRouting implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkOrderRoutingPK workOrderRoutingPK;
    @Basic(optional = false)
    @Column(name = "ScheduledStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledStartDate;
    @Basic(optional = false)
    @Column(name = "ScheduledEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledEndDate;
    @Column(name = "ActualStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStartDate;
    @Column(name = "ActualEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDate;
    @Column(name = "ActualResourceHrs")
    private BigDecimal actualResourceHrs;
    @Basic(optional = false)
    @Column(name = "PlannedCost")
    private BigDecimal plannedCost;
    @Column(name = "ActualCost")
    private BigDecimal actualCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID")
    @ManyToOne(optional = false)
    private Location locationID;
    @JoinColumn(name = "WorkOrderID", referencedColumnName = "WorkOrderID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkOrder workOrder;


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
