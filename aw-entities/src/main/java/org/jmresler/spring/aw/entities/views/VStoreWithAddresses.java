package org.jmresler.spring.aw.entities.views;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "vStoreWithAddresses", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "VStoreWithAddresses.findAll", query = "SELECT v FROM VStoreWithAddresses v"),
    @NamedQuery(name = "VStoreWithAddresses.findByBusinessEntityID", query = "SELECT v FROM VStoreWithAddresses v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VStoreWithAddresses.findByAddressLine1", query = "SELECT v FROM VStoreWithAddresses v WHERE v.addressLine1 = :addressLine1"),
    @NamedQuery(name = "VStoreWithAddresses.findByAddressLine2", query = "SELECT v FROM VStoreWithAddresses v WHERE v.addressLine2 = :addressLine2"),
    @NamedQuery(name = "VStoreWithAddresses.findByCity", query = "SELECT v FROM VStoreWithAddresses v WHERE v.city = :city"),
    @NamedQuery(name = "VStoreWithAddresses.findByPostalCode", query = "SELECT v FROM VStoreWithAddresses v WHERE v.postalCode = :postalCode")})
public class VStoreWithAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private String postalCode;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
