package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "BusinessEntityContact", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessEntityContact.findAll", query = "SELECT b FROM BusinessEntityContact b"),
    @NamedQuery(name = "BusinessEntityContact.findByBusinessEntityID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "BusinessEntityContact.findByPersonID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.personID = :personID"),
    @NamedQuery(name = "BusinessEntityContact.findByContactTypeID", query = "SELECT b FROM BusinessEntityContact b WHERE b.businessEntityContactPK.contactTypeID = :contactTypeID"),
    @NamedQuery(name = "BusinessEntityContact.findByRowguid", query = "SELECT b FROM BusinessEntityContact b WHERE b.rowguid = :rowguid"),
    @NamedQuery(name = "BusinessEntityContact.findByModifiedDate", query = "SELECT b FROM BusinessEntityContact b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntityContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessEntityContactPK businessEntityContactPK;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BusinessEntity businessEntity;
    @JoinColumn(name = "ContactTypeID", referencedColumnName = "ContactTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContactType contactType;
    @JoinColumn(name = "PersonID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public BusinessEntityContact(BusinessEntityContactPK businessEntityContactPK) {
        this.businessEntityContactPK = businessEntityContactPK;
    }
}
