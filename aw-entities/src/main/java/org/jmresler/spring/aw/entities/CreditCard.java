package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CreditCard", catalog = "AdventureWorks2017", schema = "Sales")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CreditCardID")
    private Integer creditCardID;
    @Basic(optional = false)
    @Column(name = "CardType")
    private String cardType;
    @Basic(optional = false)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "ExpMonth")
    private short expMonth;
    @Basic(optional = false)
    @Column(name = "ExpYear")
    private short expYear;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard")
    private Collection<PersonCreditCard> personCreditCardCollection;
    @OneToMany(mappedBy = "creditCardID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
