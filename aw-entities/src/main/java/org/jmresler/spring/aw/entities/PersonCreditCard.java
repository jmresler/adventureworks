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
@Table(name = "PersonCreditCard", schema = "Sales")
@XmlRootElement
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
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CreditCardID", referencedColumnName = "CreditCardID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CreditCard creditCard;

    public PersonCreditCard(PersonCreditCardPK personCreditCardPK) {
        this.personCreditCardPK = personCreditCardPK;
    }    
}
