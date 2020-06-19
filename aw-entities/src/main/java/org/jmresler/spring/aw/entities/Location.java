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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
