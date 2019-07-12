/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "PhoneNumberType", catalog = "AdventureWorks2017", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneNumberType.findAll", query = "SELECT p FROM PhoneNumberType p"),
    @NamedQuery(name = "PhoneNumberType.findByPhoneNumberTypeID", query = "SELECT p FROM PhoneNumberType p WHERE p.phoneNumberTypeID = :phoneNumberTypeID"),
    @NamedQuery(name = "PhoneNumberType.findByModifiedDate", query = "SELECT p FROM PhoneNumberType p WHERE p.modifiedDate = :modifiedDate")})
public class PhoneNumberType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhoneNumberTypeID")
    private Integer phoneNumberTypeID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneNumberType")
    private Collection<PersonPhone> personPhoneCollection;

    public PhoneNumberType() {
    }

    public PhoneNumberType(Integer phoneNumberTypeID) {
        this.phoneNumberTypeID = phoneNumberTypeID;
    }

    public PhoneNumberType(Integer phoneNumberTypeID, Date modifiedDate) {
        this.phoneNumberTypeID = phoneNumberTypeID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getPhoneNumberTypeID() {
        return phoneNumberTypeID;
    }

    public void setPhoneNumberTypeID(Integer phoneNumberTypeID) {
        this.phoneNumberTypeID = phoneNumberTypeID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<PersonPhone> getPersonPhoneCollection() {
        return personPhoneCollection;
    }

    public void setPersonPhoneCollection(Collection<PersonPhone> personPhoneCollection) {
        this.personPhoneCollection = personPhoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneNumberTypeID != null ? phoneNumberTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhoneNumberType)) {
            return false;
        }
        PhoneNumberType other = (PhoneNumberType) object;
        if ((this.phoneNumberTypeID == null && other.phoneNumberTypeID != null) || (this.phoneNumberTypeID != null && !this.phoneNumberTypeID.equals(other.phoneNumberTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.PhoneNumberType[ phoneNumberTypeID=" + phoneNumberTypeID + " ]";
    }
    
}
