/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "ShoppingCartItem", catalog = "AdventureWorks2017", schema = "Sales")
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

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Integer shoppingCartItemID) {
        this.shoppingCartItemID = shoppingCartItemID;
    }

    public ShoppingCartItem(Integer shoppingCartItemID, String shoppingCartID, int quantity, int productID, Date dateCreated, Date modifiedDate) {
        this.shoppingCartItemID = shoppingCartItemID;
        this.shoppingCartID = shoppingCartID;
        this.quantity = quantity;
        this.productID = productID;
        this.dateCreated = dateCreated;
        this.modifiedDate = modifiedDate;
    }

    public Integer getShoppingCartItemID() {
        return shoppingCartItemID;
    }

    public void setShoppingCartItemID(Integer shoppingCartItemID) {
        this.shoppingCartItemID = shoppingCartItemID;
    }

    public String getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(String shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingCartItemID != null ? shoppingCartItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCartItem)) {
            return false;
        }
        ShoppingCartItem other = (ShoppingCartItem) object;
        if ((this.shoppingCartItemID == null && other.shoppingCartItemID != null) || (this.shoppingCartItemID != null && !this.shoppingCartItemID.equals(other.shoppingCartItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ShoppingCartItem[ shoppingCartItemID=" + shoppingCartItemID + " ]";
    }
    
}
