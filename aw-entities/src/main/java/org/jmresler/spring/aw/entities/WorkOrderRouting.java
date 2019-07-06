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
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "WorkOrderRouting", schema = "Production")
@XmlRootElement
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
    @Column(name = "ScheduledStartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledStartDate;
    @Basic(optional = false)
    @Column(name = "ScheduledEndDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledEndDate;
    @Column(name = "ActualStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualStartDate;
    @Column(name = "ActualEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualEndDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ActualResourceHrs", precision = 9, scale = 4)
    private BigDecimal actualResourceHrs;
    @Basic(optional = false)
    @Column(name = "PlannedCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal plannedCost;
    @Column(name = "ActualCost", precision = 19, scale = 4)
    private BigDecimal actualCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", nullable = false)
    @ManyToOne(optional = false)
    private Location locationID;
    @JoinColumn(name = "WorkOrderID", referencedColumnName = "WorkOrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WorkOrder workOrder;

    public WorkOrderRouting(WorkOrderRoutingPK workOrderRoutingPK) {
        this.workOrderRoutingPK = workOrderRoutingPK;
    }
    
}
