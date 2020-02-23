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


/**
 *
 * @author John
 */
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

    public WorkOrderRouting() {
    }

    public WorkOrderRouting(WorkOrderRoutingPK workOrderRoutingPK) {
        this.workOrderRoutingPK = workOrderRoutingPK;
    }

    public WorkOrderRouting(WorkOrderRoutingPK workOrderRoutingPK, Date scheduledStartDate, Date scheduledEndDate, BigDecimal plannedCost, Date modifiedDate) {
        this.workOrderRoutingPK = workOrderRoutingPK;
        this.scheduledStartDate = scheduledStartDate;
        this.scheduledEndDate = scheduledEndDate;
        this.plannedCost = plannedCost;
        this.modifiedDate = modifiedDate;
    }

    public WorkOrderRouting(int workOrderID, int productID, short operationSequence) {
        this.workOrderRoutingPK = new WorkOrderRoutingPK(workOrderID, productID, operationSequence);
    }

    public WorkOrderRoutingPK getWorkOrderRoutingPK() {
        return workOrderRoutingPK;
    }

    public void setWorkOrderRoutingPK(WorkOrderRoutingPK workOrderRoutingPK) {
        this.workOrderRoutingPK = workOrderRoutingPK;
    }

    public Date getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(Date scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public Date getScheduledEndDate() {
        return scheduledEndDate;
    }

    public void setScheduledEndDate(Date scheduledEndDate) {
        this.scheduledEndDate = scheduledEndDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public BigDecimal getActualResourceHrs() {
        return actualResourceHrs;
    }

    public void setActualResourceHrs(BigDecimal actualResourceHrs) {
        this.actualResourceHrs = actualResourceHrs;
    }

    public BigDecimal getPlannedCost() {
        return plannedCost;
    }

    public void setPlannedCost(BigDecimal plannedCost) {
        this.plannedCost = plannedCost;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workOrderRoutingPK != null ? workOrderRoutingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkOrderRouting)) {
            return false;
        }
        WorkOrderRouting other = (WorkOrderRouting) object;
        if ((this.workOrderRoutingPK == null && other.workOrderRoutingPK != null) || (this.workOrderRoutingPK != null && !this.workOrderRoutingPK.equals(other.workOrderRoutingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.WorkOrderRouting[ workOrderRoutingPK=" + workOrderRoutingPK + " ]";
    }
    
}
