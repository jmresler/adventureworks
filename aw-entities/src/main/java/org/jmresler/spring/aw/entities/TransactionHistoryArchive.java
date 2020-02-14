package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "TransactionHistoryArchive", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "TransactionHistoryArchive.findAll", query = "SELECT t FROM TransactionHistoryArchive t"),
    @NamedQuery(name = "TransactionHistoryArchive.findByTransactionID", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.transactionID = :transactionID"),
    @NamedQuery(name = "TransactionHistoryArchive.findByProductID", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.productID = :productID"),
    @NamedQuery(name = "TransactionHistoryArchive.findByReferenceOrderID", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.referenceOrderID = :referenceOrderID"),
    @NamedQuery(name = "TransactionHistoryArchive.findByReferenceOrderLineID", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.referenceOrderLineID = :referenceOrderLineID"),
    @NamedQuery(name = "TransactionHistoryArchive.findByTransactionDate", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "TransactionHistoryArchive.findByTransactionType", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "TransactionHistoryArchive.findByQuantity", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TransactionHistoryArchive.findByActualCost", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.actualCost = :actualCost"),
    @NamedQuery(name = "TransactionHistoryArchive.findByModifiedDate", query = "SELECT t FROM TransactionHistoryArchive t WHERE t.modifiedDate = :modifiedDate")})
public class TransactionHistoryArchive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TransactionID")
    private Integer transactionID;
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
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
    @Basic(optional = false)
    @Column(name = "ActualCost")
    private BigDecimal actualCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public TransactionHistoryArchive() {
    }

    public TransactionHistoryArchive(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionHistoryArchive(Integer transactionID, int productID, int referenceOrderID, int referenceOrderLineID, Date transactionDate, String transactionType, int quantity, BigDecimal actualCost, Date modifiedDate) {
        this.transactionID = transactionID;
        this.productID = productID;
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionID != null ? transactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionHistoryArchive)) {
            return false;
        }
        TransactionHistoryArchive other = (TransactionHistoryArchive) object;
        if ((this.transactionID == null && other.transactionID != null) || (this.transactionID != null && !this.transactionID.equals(other.transactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.TransactionHistoryArchive[ transactionID=" + transactionID + " ]";
    }
    
}
