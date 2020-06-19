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
@Table(name = "Vendor", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByBusinessEntityID", query = "SELECT v FROM Vendor v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Vendor.findByCreditRating", query = "SELECT v FROM Vendor v WHERE v.creditRating = :creditRating"),
    @NamedQuery(name = "Vendor.findByPurchasingWebServiceURL", query = "SELECT v FROM Vendor v WHERE v.purchasingWebServiceURL = :purchasingWebServiceURL"),
    @NamedQuery(name = "Vendor.findByModifiedDate", query = "SELECT v FROM Vendor v WHERE v.modifiedDate = :modifiedDate")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "CreditRating")
    private short creditRating;
    @Column(name = "PurchasingWebServiceURL")
    private String purchasingWebServiceURL;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Collection<ProductVendor> productVendorCollection;


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
