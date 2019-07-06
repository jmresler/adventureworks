package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ShipMethod", schema = "Purchasing", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "ShipMethodID", nullable = false)
    private Integer shipMethodID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ShipBase", nullable = false, precision = 19, scale = 4)
    private BigDecimal shipBase;
    @Basic(optional = false)
    @Column(name = "ShipRate", nullable = false, precision = 19, scale = 4)
    private BigDecimal shipRate;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipMethodID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;

    public ShipMethod(Integer shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

}
