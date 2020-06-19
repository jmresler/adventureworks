package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "Store", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
    @NamedQuery(name = "Store.findByBusinessEntityID", query = "SELECT s FROM Store s WHERE s.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Store.findByDemographics", query = "SELECT s FROM Store s WHERE s.demographics = :demographics"),
    @NamedQuery(name = "Store.findByRowguid", query = "SELECT s FROM Store s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "Store.findByModifiedDate", query = "SELECT s FROM Store s WHERE s.modifiedDate = :modifiedDate")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Column(name = "Demographics")
    private String demographics;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "storeID")
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "SalesPersonID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private SalesPerson salesPersonID;


	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
