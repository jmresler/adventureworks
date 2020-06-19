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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
