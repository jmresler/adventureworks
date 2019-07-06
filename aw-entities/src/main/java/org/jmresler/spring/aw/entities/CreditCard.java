package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "CreditCard", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CardNumber"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c"),
    @NamedQuery(name = "CreditCard.findByCreditCardID", query = "SELECT c FROM CreditCard c WHERE c.creditCardID = :creditCardID"),
    @NamedQuery(name = "CreditCard.findByCardType", query = "SELECT c FROM CreditCard c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CreditCard.findByCardNumber", query = "SELECT c FROM CreditCard c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "CreditCard.findByExpMonth", query = "SELECT c FROM CreditCard c WHERE c.expMonth = :expMonth"),
    @NamedQuery(name = "CreditCard.findByExpYear", query = "SELECT c FROM CreditCard c WHERE c.expYear = :expYear"),
    @NamedQuery(name = "CreditCard.findByModifiedDate", query = "SELECT c FROM CreditCard c WHERE c.modifiedDate = :modifiedDate")})
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CreditCardID", nullable = false)
    private Integer creditCardID;
    @Basic(optional = false)
    @Column(name = "CardType", nullable = false, length = 50)
    private String cardType;
    @Basic(optional = false)
    @Column(name = "CardNumber", nullable = false, length = 25)
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "ExpMonth", nullable = false)
    private short expMonth;
    @Basic(optional = false)
    @Column(name = "ExpYear", nullable = false)
    private short expYear;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard")
    private Collection<PersonCreditCard> personCreditCardCollection;
    @XmlTransient
    @OneToMany(mappedBy = "creditCardID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

    public CreditCard(Integer creditCardID) {
        this.creditCardID = creditCardID;
    }
}
