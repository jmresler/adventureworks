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
@Table(name = "AddressType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a"),
    @NamedQuery(name = "AddressType.findByAddressTypeID", query = "SELECT a FROM AddressType a WHERE a.addressTypeID = :addressTypeID"),
    @NamedQuery(name = "AddressType.findByRowguid", query = "SELECT a FROM AddressType a WHERE a.rowguid = :rowguid"),
    @NamedQuery(name = "AddressType.findByModifiedDate", query = "SELECT a FROM AddressType a WHERE a.modifiedDate = :modifiedDate")})
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressTypeID")
    private Integer addressTypeID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
