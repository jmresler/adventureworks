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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Entity
@Table(name = "PersonPhone", catalog = "AdventureWorks2017", schema = "Person")

@NamedQueries({
    @NamedQuery(name = "PersonPhone.findAll", query = "SELECT p FROM PersonPhone p"),
    @NamedQuery(name = "PersonPhone.findByBusinessEntityID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "PersonPhone.findByPhoneNumberTypeID", query = "SELECT p FROM PersonPhone p WHERE p.personPhonePK.phoneNumberTypeID = :phoneNumberTypeID"),
    @NamedQuery(name = "PersonPhone.findByModifiedDate", query = "SELECT p FROM PersonPhone p WHERE p.modifiedDate = :modifiedDate")})
public class PersonPhone implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PersonPhonePK personPhonePK;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    
    @JsonBackReference
    @JoinColumn(name = "PhoneNumberTypeID", referencedColumnName = "PhoneNumberTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PhoneNumberType phoneNumberType;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
