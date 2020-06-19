package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ShoppingCartItem", catalog = "AdventureWorks2017", schema = "Sales")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShoppingCartItemID")
    private Integer shoppingCartItemID;
    @Basic(optional = false)
    @Column(name = "ShoppingCartID")
    private String shoppingCartID;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
