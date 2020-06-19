package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ShipMethod", catalog = "AdventureWorks2017", schema = "Purchasing")
@NamedQueries({
    @NamedQuery(name = "ShipMethod.findAll", query = "SELECT s FROM ShipMethod s"),
    @NamedQuery(name = "ShipMethod.findByShipMethodID", query = "SELECT s FROM ShipMethod s WHERE s.shipMethodID = :shipMethodID"),
    @NamedQuery(name = "ShipMethod.findByShipBase", query = "SELECT s FROM ShipMethod s WHERE s.shipBase = :shipBase"),
    @NamedQuery(name = "ShipMethod.findByShipRate", query = "SELECT s FROM ShipMethod s WHERE s.shipRate = :shipRate"),
    @NamedQuery(name = "ShipMethod.findByRowguid", query = "SELECT s FROM ShipMethod s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "ShipMethod.findByModifiedDate", query = "SELECT s FROM ShipMethod s WHERE s.modifiedDate = :modifiedDate")})
public class ShipMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ShipMethodID")
    private Integer shipMethodID;
    @Basic(optional = false)
    @Column(name = "ShipBase")
    private BigDecimal shipBase;
    @Basic(optional = false)
    @Column(name = "ShipRate")
    private BigDecimal shipRate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipMethodID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
