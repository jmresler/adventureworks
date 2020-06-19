/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "WorkOrder", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "WorkOrder.findAll", query = "SELECT w FROM WorkOrder w"),
    @NamedQuery(name = "WorkOrder.findByWorkOrderID", query = "SELECT w FROM WorkOrder w WHERE w.workOrderID = :workOrderID"),
    @NamedQuery(name = "WorkOrder.findByOrderQty", query = "SELECT w FROM WorkOrder w WHERE w.orderQty = :orderQty"),
    @NamedQuery(name = "WorkOrder.findByStockedQty", query = "SELECT w FROM WorkOrder w WHERE w.stockedQty = :stockedQty"),
    @NamedQuery(name = "WorkOrder.findByScrappedQty", query = "SELECT w FROM WorkOrder w WHERE w.scrappedQty = :scrappedQty"),
    @NamedQuery(name = "WorkOrder.findByStartDate", query = "SELECT w FROM WorkOrder w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "WorkOrder.findByEndDate", query = "SELECT w FROM WorkOrder w WHERE w.endDate = :endDate"),
    @NamedQuery(name = "WorkOrder.findByDueDate", query = "SELECT w FROM WorkOrder w WHERE w.dueDate = :dueDate"),
    @NamedQuery(name = "WorkOrder.findByModifiedDate", query = "SELECT w FROM WorkOrder w WHERE w.modifiedDate = :modifiedDate")})
public class WorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "WorkOrderID")
    private Integer workOrderID;
    @Basic(optional = false)
    @Column(name = "OrderQty")
    private int orderQty;
    @Basic(optional = false)
    @Column(name = "StockedQty")
    private int stockedQty;
    @Basic(optional = false)
    @Column(name = "ScrappedQty")
    private short scrappedQty;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "DueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workOrder")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product productID;
    @JoinColumn(name = "ScrapReasonID", referencedColumnName = "ScrapReasonID")
    @ManyToOne
    private ScrapReason scrapReasonID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
