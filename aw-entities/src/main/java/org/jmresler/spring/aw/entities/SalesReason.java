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
@Table(name = "SalesReason", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SalesReason.findAll", query = "SELECT s FROM SalesReason s"),
    @NamedQuery(name = "SalesReason.findBySalesReasonID", query = "SELECT s FROM SalesReason s WHERE s.salesReasonID = :salesReasonID"),
    @NamedQuery(name = "SalesReason.findByModifiedDate", query = "SELECT s FROM SalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesReason implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SalesReasonID")
    private Integer salesReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesReason")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
