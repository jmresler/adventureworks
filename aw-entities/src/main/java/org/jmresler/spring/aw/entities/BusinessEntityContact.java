package org.jmresler.spring.aw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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


/**
 *
 * @author John
 */
@Entity
@Table(name = "BusinessEntityContact", catalog = "AdventureWorks2017", schema = "Person")

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
    @JsonIgnore
    @JoinColumn(name = "ContactTypeID", referencedColumnName = "ContactTypeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContactType contactType;
    @JsonIgnore
    @JoinColumn(name = "PersonID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public BusinessEntityContact() {
    }

    public BusinessEntityContact(BusinessEntityContactPK businessEntityContactPK) {
        this.businessEntityContactPK = businessEntityContactPK;
    }

    public BusinessEntityContact(BusinessEntityContactPK businessEntityContactPK, String rowguid, Date modifiedDate) {
        this.businessEntityContactPK = businessEntityContactPK;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public BusinessEntityContact(int businessEntityID, int personID, int contactTypeID) {
        this.businessEntityContactPK = new BusinessEntityContactPK(businessEntityID, personID, contactTypeID);
    }

    public BusinessEntityContactPK getBusinessEntityContactPK() {
        return businessEntityContactPK;
    }

    public void setBusinessEntityContactPK(BusinessEntityContactPK businessEntityContactPK) {
        this.businessEntityContactPK = businessEntityContactPK;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessEntityContactPK != null ? businessEntityContactPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessEntityContact)) {
            return false;
        }
        BusinessEntityContact other = (BusinessEntityContact) object;
        if ((this.businessEntityContactPK == null && other.businessEntityContactPK != null) || (this.businessEntityContactPK != null && !this.businessEntityContactPK.equals(other.businessEntityContactPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.BusinessEntityContact[ businessEntityContactPK=" + businessEntityContactPK + " ]";
    }
    
}
