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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "TransactionHistory", catalog = "AdventureWorks2017", schema = "Production")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @Basic(optional = false)
    @Column(name = "ActualCost")
    private BigDecimal actualCost;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product productID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
