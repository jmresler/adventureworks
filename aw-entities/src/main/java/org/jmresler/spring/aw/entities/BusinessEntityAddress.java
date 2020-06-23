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
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "BusinessEntityAddress", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "BusinessEntityAddress.findAll", query = "SELECT b FROM BusinessEntityAddress b"),
    @NamedQuery(name = "BusinessEntityAddress.findByBusinessEntityID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "BusinessEntityAddress.findByAddressID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressID = :addressID"),
    @NamedQuery(name = "BusinessEntityAddress.findByAddressTypeID", query = "SELECT b FROM BusinessEntityAddress b WHERE b.businessEntityAddressPK.addressTypeID = :addressTypeID"),
    @NamedQuery(name = "BusinessEntityAddress.findByRowguid", query = "SELECT b FROM BusinessEntityAddress b WHERE b.rowguid = :rowguid"),
    @NamedQuery(name = "BusinessEntityAddress.findByModifiedDate", query = "SELECT b FROM BusinessEntityAddress b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntityAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected BusinessEntityAddressPK businessEntityAddressPK;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonIgnore
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Address address;
    
    @JsonIgnore
    @JoinColumn(name = "AddressTypeID", referencedColumnName = "AddressTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AddressType addressType;
    
    @JsonBackReference
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BusinessEntity businessEntity;

    
	@Override
	public String toString() {
		return getClass().getName() + "[rowguid: " + rowguid + ", Date: " + modifiedDate + "]"; 
	}
}
