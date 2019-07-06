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
@Table(name = "ProductInventory", schema = "Production")
@XmlRootElement
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
    @Column(name = "Shelf", nullable = false, length = 10)
    private String shelf;
    @Basic(optional = false)
    @Column(name = "Bin", nullable = false)
    private short bin;
    @Basic(optional = false)
    @Column(name = "Quantity", nullable = false)
    private short quantity;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductInventory(ProductInventoryPK productInventoryPK) {
        this.productInventoryPK = productInventoryPK;
    }
}
