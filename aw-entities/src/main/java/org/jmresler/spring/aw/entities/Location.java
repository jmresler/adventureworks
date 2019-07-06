package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Location", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationID", query = "SELECT l FROM Location l WHERE l.locationID = :locationID"),
    @NamedQuery(name = "Location.findByCostRate", query = "SELECT l FROM Location l WHERE l.costRate = :costRate"),
    @NamedQuery(name = "Location.findByAvailability", query = "SELECT l FROM Location l WHERE l.availability = :availability"),
    @NamedQuery(name = "Location.findByModifiedDate", query = "SELECT l FROM Location l WHERE l.modifiedDate = :modifiedDate")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LocationID", nullable = false)
    private Short locationID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CostRate", nullable = false, precision = 10, scale = 4)
    private BigDecimal costRate;
    @Basic(optional = false)
    @Column(name = "Availability", nullable = false, precision = 8, scale = 2)
    private BigDecimal availability;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<ProductInventory> productInventoryCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationID")
    private Collection<WorkOrderRouting> workOrderRoutingCollection;

    public Location(Short locationID) {
        this.locationID = locationID;
    }
}
