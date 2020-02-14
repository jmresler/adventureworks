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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John
 */
@Entity
@Table(name = "ContactType", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"),
    @NamedQuery(name = "ContactType.findByContactTypeID", query = "SELECT c FROM ContactType c WHERE c.contactTypeID = :contactTypeID"),
    @NamedQuery(name = "ContactType.findByModifiedDate", query = "SELECT c FROM ContactType c WHERE c.modifiedDate = :modifiedDate")})
public class ContactType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContactTypeID")
    private Integer contactTypeID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactType")
    private Collection<BusinessEntityContact> businessEntityContactCollection;

    public ContactType() {
    }

    public ContactType(Integer contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public ContactType(Integer contactTypeID, Date modifiedDate) {
        this.contactTypeID = contactTypeID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(Integer contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<BusinessEntityContact> getBusinessEntityContactCollection() {
        return businessEntityContactCollection;
    }

    public void setBusinessEntityContactCollection(Collection<BusinessEntityContact> businessEntityContactCollection) {
        this.businessEntityContactCollection = businessEntityContactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactTypeID != null ? contactTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
        if ((this.contactTypeID == null && other.contactTypeID != null) || (this.contactTypeID != null && !this.contactTypeID.equals(other.contactTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ContactType[ contactTypeID=" + contactTypeID + " ]";
    }
    
}
