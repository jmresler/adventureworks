package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
@Entity
@Table(name = "PersonCreditCard", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "PersonCreditCard.findAll", query = "SELECT p FROM PersonCreditCard p"),
    @NamedQuery(name = "PersonCreditCard.findByBusinessEntityID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "PersonCreditCard.findByCreditCardID", query = "SELECT p FROM PersonCreditCard p WHERE p.personCreditCardPK.creditCardID = :creditCardID"),
    @NamedQuery(name = "PersonCreditCard.findByModifiedDate", query = "SELECT p FROM PersonCreditCard p WHERE p.modifiedDate = :modifiedDate")})
public class PersonCreditCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PersonCreditCardPK personCreditCardPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CreditCard creditCard;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
