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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "Customer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "Customer.findByPersonID", query = "SELECT c FROM Customer c WHERE c.personID = :personID"),
    @NamedQuery(name = "Customer.findByAccountNumber", query = "SELECT c FROM Customer c WHERE c.accountNumber = :accountNumber"),
    @NamedQuery(name = "Customer.findByRowguid", query = "SELECT c FROM Customer c WHERE c.rowguid = :rowguid"),
    @NamedQuery(name = "Customer.findByModifiedDate", query = "SELECT c FROM Customer c WHERE c.modifiedDate = :modifiedDate")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private Integer customerID;
    
    @Column(name = "PersonID")
    private Integer personID;
    
    @Basic(optional = false)
    @Column(name = "AccountNumber")
    private String accountNumber;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    
    @JoinColumn(name = "StoreID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private Store storeID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
