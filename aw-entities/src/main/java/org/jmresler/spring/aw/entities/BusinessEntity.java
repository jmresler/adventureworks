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
import javax.persistence.OneToOne;
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
@Table(name = "BusinessEntity", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessEntity.findAll", query = "SELECT b FROM BusinessEntity b"),
    @NamedQuery(name = "BusinessEntity.findByBusinessEntityID", query = "SELECT b FROM BusinessEntity b WHERE b.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "BusinessEntity.findByRowguid", query = "SELECT b FROM BusinessEntity b WHERE b.rowguid = :rowguid"),
    @NamedQuery(name = "BusinessEntity.findByModifiedDate", query = "SELECT b FROM BusinessEntity b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Person person;

    public BusinessEntity(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }
}
