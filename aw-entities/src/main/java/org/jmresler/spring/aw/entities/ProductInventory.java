package org.jmresler.spring.aw.entities;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "ProductInventory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductInventory.findAll", query = "SELECT p FROM ProductInventory p"),
    @NamedQuery(name = "ProductInventory.findByProductID", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.productID = :productID"),
    @NamedQuery(name = "ProductInventory.findByLocationID", query = "SELECT p FROM ProductInventory p WHERE p.productInventoryPK.locationID = :locationID"),
    @NamedQuery(name = "ProductInventory.findByShelf", query = "SELECT p FROM ProductInventory p WHERE p.shelf = :shelf"),
    @NamedQuery(name = "ProductInventory.findByBin", query = "SELECT p FROM ProductInventory p WHERE p.bin = :bin"),
    @NamedQuery(name = "ProductInventory.findByQuantity", query = "SELECT p FROM ProductInventory p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "ProductInventory.findByRowguid", query = "SELECT p FROM ProductInventory p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductInventory.findByModifiedDate", query = "SELECT p FROM ProductInventory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductInventoryPK productInventoryPK;
    
    @Basic(optional = false)
    @Column(name = "Shelf")
    private String shelf;
    
    @Basic(optional = false)
    @Column(name = "Bin")
    private short bin;
    
    @Basic(optional = false)
    @Column(name = "Quantity")
    private short quantity;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonManagedReference
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    
    @JsonManagedReference
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
