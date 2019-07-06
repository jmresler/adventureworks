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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Entity
@Table(name = "WorkOrder", schema = "Production")
@XmlRootElement
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
    @Column(name = "WorkOrderID", nullable = false)
    private Integer workOrderID;
    @Basic(optional = false)
    @Column(name = "OrderQty", nullable = false)
    private int orderQty;
    @Basic(optional = false)
    @Column(name = "StockedQty", nullable = false)
    private int stockedQty;
    @Basic(optional = false)
    @Column(name = "ScrappedQty", nullable = false)
    private short scrappedQty;
    @Basic(optional = false)
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "DueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workOrder")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;
    @JoinColumn(name = "ScrapReasonID", referencedColumnName = "ScrapReasonID")
    @ManyToOne
    private ScrapReason scrapReasonID;

    public WorkOrder(Integer workOrderID) {
        this.workOrderID = workOrderID;
    }
}
