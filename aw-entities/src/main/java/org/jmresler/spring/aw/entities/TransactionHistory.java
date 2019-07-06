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
@Table(name = "TransactionHistory", schema = "Production")
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
    @Column(name = "TransactionID", nullable = false)
    private Integer transactionID;
    @Basic(optional = false)
    @Column(name = "ReferenceOrderID", nullable = false)
    private int referenceOrderID;
    @Basic(optional = false)
    @Column(name = "ReferenceOrderLineID", nullable = false)
    private int referenceOrderLineID;
    @Basic(optional = false)
    @Column(name = "TransactionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Basic(optional = false)
    @Column(name = "TransactionType", nullable = false, length = 1)
    private String transactionType;
    @Basic(optional = false)
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ActualCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal actualCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;

    public TransactionHistory(Integer transactionID) {
        this.transactionID = transactionID;
    }
    
}
