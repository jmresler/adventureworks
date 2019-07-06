package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ShoppingCartItem", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingCartItem.findAll", query = "SELECT s FROM ShoppingCartItem s"),
    @NamedQuery(name = "ShoppingCartItem.findByShoppingCartItemID", query = "SELECT s FROM ShoppingCartItem s WHERE s.shoppingCartItemID = :shoppingCartItemID"),
    @NamedQuery(name = "ShoppingCartItem.findByShoppingCartID", query = "SELECT s FROM ShoppingCartItem s WHERE s.shoppingCartID = :shoppingCartID"),
    @NamedQuery(name = "ShoppingCartItem.findByQuantity", query = "SELECT s FROM ShoppingCartItem s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "ShoppingCartItem.findByProductID", query = "SELECT s FROM ShoppingCartItem s WHERE s.productID = :productID"),
    @NamedQuery(name = "ShoppingCartItem.findByDateCreated", query = "SELECT s FROM ShoppingCartItem s WHERE s.dateCreated = :dateCreated"),
    @NamedQuery(name = "ShoppingCartItem.findByModifiedDate", query = "SELECT s FROM ShoppingCartItem s WHERE s.modifiedDate = :modifiedDate")})
public class ShoppingCartItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ShoppingCartItemID", nullable = false)
    private Integer shoppingCartItemID;
    @Basic(optional = false)
    @Column(name = "ShoppingCartID", nullable = false, length = 50)
    private String shoppingCartID;
    @Basic(optional = false)
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Column(name = "DateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public ShoppingCartItem(Integer shoppingCartItemID) {
        this.shoppingCartItemID = shoppingCartItemID;
    }
    
}
