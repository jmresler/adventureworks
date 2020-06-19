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
@Table(name = "PhoneNumberType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "PhoneNumberType.findAll", query = "SELECT p FROM PhoneNumberType p"),
    @NamedQuery(name = "PhoneNumberType.findByPhoneNumberTypeID", query = "SELECT p FROM PhoneNumberType p WHERE p.phoneNumberTypeID = :phoneNumberTypeID"),
    @NamedQuery(name = "PhoneNumberType.findByModifiedDate", query = "SELECT p FROM PhoneNumberType p WHERE p.modifiedDate = :modifiedDate")})
public class PhoneNumberType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhoneNumberTypeID")
    private Integer phoneNumberTypeID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneNumberType")
    private Collection<PersonPhone> personPhoneCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
