/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TransactionHistory", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionHistory.findAll", query = "SELECT t FROM TransactionHistory t"),
    @NamedQuery(name = "TransactionHistory.findByTransactionID", query = "SELECT t FROM TransactionHistory t WHERE t.transactionID = :transactionID"),
    @NamedQuery(name = "TransactionHistory.findByReferenceOrderID", query = "SELECT t FROM TransactionHistory t WHERE t.referenceOrderID = :referenceOrderID"),
    @NamedQuery(name = "TransactionHistory.findByReferenceOrderLineID", query = "SELECT t FROM TransactionHistory t WHERE t.referenceOrderLineID = :referenceOrderLineID"),
    @NamedQuery(name = "TransactionHistory.findByTransactionDate", query = "SELECT t FROM TransactionHistory t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "TransactionHistory.findByTransactionType", query = "SELECT t FROM TransactionHistory t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "TransactionHistory.findByQuantity", query = "SELECT t FROM TransactionHistory t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TransactionHistory.findByActualCost", query = "SELECT t FROM TransactionHistory t WHERE t.actualCost = :actualCost"),
    @NamedQuery(name = "TransactionHistory.findByModifiedDate", query = "SELECT t FROM TransactionHistory t WHERE t.modifiedDate = :modifiedDate")})
public class TransactionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TransactionID")
    private Integer transactionID;
    @Basic(optional = false)
    @Column(name = "ReferenceOrderID")
    private int referenceOrderID;
    @Basic(optional = false)
    @Column(name = "ReferenceOrderLineID")
    private int referenceOrderLineID;
    @Basic(optional = false)
    @Column(name = "TransactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Basic(optional = false)
    @Column(name = "TransactionType")
    private String transactionType;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ActualCost")
    private BigDecimal actualCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product productID;

    public TransactionHistory() {
    }

    public TransactionHistory(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionHistory(Integer transactionID, int referenceOrderID, int referenceOrderLineID, Date transactionDate, String transactionType, int quantity, BigDecimal actualCost, Date modifiedDate) {
        this.transactionID = transactionID;
        this.referenceOrderID = referenceOrderID;
        this.referenceOrderLineID = referenceOrderLineID;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.actualCost = actualCost;
        this.modifiedDate = modifiedDate;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public int getReferenceOrderID() {
        return referenceOrderID;
    }

    public void setReferenceOrderID(int referenceOrderID) {
        this.referenceOrderID = referenceOrderID;
    }

    public int getReferenceOrderLineID() {
        return referenceOrderLineID;
    }

    public void setReferenceOrderLineID(int referenceOrderLineID) {
        this.referenceOrderLineID = referenceOrderLineID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionID != null ? transactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionHistory)) {
            return false;
        }
        TransactionHistory other = (TransactionHistory) object;
        if ((this.transactionID == null && other.transactionID != null) || (this.transactionID != null && !this.transactionID.equals(other.transactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.TransactionHistory[ transactionID=" + transactionID + " ]";
    }
    
}
