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
@Table(name = "AddressType", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressType.findAll", query = "SELECT a FROM AddressType a"),
    @NamedQuery(name = "AddressType.findByAddressTypeID", query = "SELECT a FROM AddressType a WHERE a.addressTypeID = :addressTypeID"),
    @NamedQuery(name = "AddressType.findByRowguid", query = "SELECT a FROM AddressType a WHERE a.rowguid = :rowguid"),
    @NamedQuery(name = "AddressType.findByModifiedDate", query = "SELECT a FROM AddressType a WHERE a.modifiedDate = :modifiedDate")})
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressType")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;

    public AddressType(Integer addressTypeID) {
        this.addressTypeID = addressTypeID;
    }
}
