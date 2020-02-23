package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
@Table(name = "Location", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationID", query = "SELECT l FROM Location l WHERE l.locationID = :locationID"),
    @NamedQuery(name = "Location.findByCostRate", query = "SELECT l FROM Location l WHERE l.costRate = :costRate"),
    @NamedQuery(name = "Location.findByAvailability", query = "SELECT l FROM Location l WHERE l.availability = :availability"),
    @NamedQuery(name = "Location.findByModifiedDate", query = "SELECT l FROM Location l WHERE l.modifiedDate = :modifiedDate")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocationID")
    private Short locationID;
    @Basic(optional = false)
    @Column(name = "CostRate")
    private BigDecimal costRate;
    @Basic(optional = false)
    @Column(name = "Availability")
    private BigDecimal availability;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<ProductInventory> productInventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationID")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;

    public Location() {
    }

    public Location(Short locationID) {
        this.locationID = locationID;
    }

    public Location(Short locationID, BigDecimal costRate, BigDecimal availability, Date modifiedDate) {
        this.locationID = locationID;
        this.costRate = costRate;
        this.availability = availability;
        this.modifiedDate = modifiedDate;
    }

    public Short getLocationID() {
        return locationID;
    }

    public void setLocationID(Short locationID) {
        this.locationID = locationID;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getAvailability() {
        return availability;
    }

    public void setAvailability(BigDecimal availability) {
        this.availability = availability;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<ProductInventory> getProductInventoryCollection() {
        return productInventoryCollection;
    }

    public void setProductInventoryCollection(Collection<ProductInventory> productInventoryCollection) {
        this.productInventoryCollection = productInventoryCollection;
    }

    public Collection<WorkOrderRouting> getWorkOrderRoutingCollection() {
        return workOrderRoutingCollection;
    }

    public void setWorkOrderRoutingCollection(Collection<WorkOrderRouting> workOrderRoutingCollection) {
        this.workOrderRoutingCollection = workOrderRoutingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationID != null ? locationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationID == null && other.locationID != null) || (this.locationID != null && !this.locationID.equals(other.locationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Location[ locationID=" + locationID + " ]";
    }
    
}
