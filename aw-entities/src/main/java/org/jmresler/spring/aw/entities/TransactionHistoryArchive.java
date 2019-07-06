package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TransactionHistoryArchive", schema = "Production")
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "TransactionID", nullable = false)
    private Integer transactionID;
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
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
    
}
