package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@ToString(of = {"addressID","businessEntityAddressCollection"})
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Address", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressID", query = "SELECT a FROM Address a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "Address.findByAddressLine1", query = "SELECT a FROM Address a WHERE a.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Address.findByAddressLine2", query = "SELECT a FROM Address a WHERE a.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Address.findByRowguid", query = "SELECT a FROM Address a WHERE a.rowguid = :rowguid"),
    @NamedQuery(name = "Address.findByModifiedDate", query = "SELECT a FROM Address a WHERE a.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Address.countAddress", query = "SELECT COUNT(a.addressID) FROM Address a"),
    @NamedQuery(name = "Address.findAddressLine1", query = "SELECT a.addressLine1 FROM Address a"),
    @NamedQuery(name = "Address.findSpatialLocation", query = "SELECT CAST(a.spatialLocation AS VARCHAR(500)) FROM Address a")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AddressID")
    private Integer addressID;
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
    @Lob
    @Column(name = "SpatialLocation")
    private byte[] spatialLocation;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "StateProvinceID", referencedColumnName = "StateProvinceID")
    @ManyToOne(optional = false)
    private StateProvince stateProvinceID;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.EAGER)
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

    public Address(Integer addressID) {
        this.addressID = addressID;
    }
}
