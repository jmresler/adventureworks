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

import lombok.EqualsAndHashCode;

import lombok.Setter;

import lombok.Getter;

import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ContactType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"),
    @NamedQuery(name = "ContactType.findByContactTypeID", query = "SELECT c FROM ContactType c WHERE c.contactTypeID = :contactTypeID"),
    @NamedQuery(name = "ContactType.findByModifiedDate", query = "SELECT c FROM ContactType c WHERE c.modifiedDate = :modifiedDate")})
public class ContactType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContactTypeID")
    private Integer contactTypeID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactType")
    private Collection<BusinessEntityContact> businessEntityContactCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
