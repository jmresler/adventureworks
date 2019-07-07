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

/**
 *
 * @author John
 */
@Entity
@Table(name = "ScrapReason", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScrapReason.findAll", query = "SELECT s FROM ScrapReason s"),
    @NamedQuery(name = "ScrapReason.findByScrapReasonID", query = "SELECT s FROM ScrapReason s WHERE s.scrapReasonID = :scrapReasonID"),
    @NamedQuery(name = "ScrapReason.findByModifiedDate", query = "SELECT s FROM ScrapReason s WHERE s.modifiedDate = :modifiedDate")})
public class ScrapReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ScrapReasonID")
    private Short scrapReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "scrapReasonID")
    private Collection<WorkOrder> workOrderCollection;

    public ScrapReason() {
    }

    public ScrapReason(Short scrapReasonID) {
        this.scrapReasonID = scrapReasonID;
    }

    public ScrapReason(Short scrapReasonID, Date modifiedDate) {
        this.scrapReasonID = scrapReasonID;
        this.modifiedDate = modifiedDate;
    }

    public Short getScrapReasonID() {
        return scrapReasonID;
    }

    public void setScrapReasonID(Short scrapReasonID) {
        this.scrapReasonID = scrapReasonID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<WorkOrder> getWorkOrderCollection() {
        return workOrderCollection;
    }

    public void setWorkOrderCollection(Collection<WorkOrder> workOrderCollection) {
        this.workOrderCollection = workOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scrapReasonID != null ? scrapReasonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScrapReason)) {
            return false;
        }
        ScrapReason other = (ScrapReason) object;
        if ((this.scrapReasonID == null && other.scrapReasonID != null) || (this.scrapReasonID != null && !this.scrapReasonID.equals(other.scrapReasonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ScrapReason[ scrapReasonID=" + scrapReasonID + " ]";
    }
    
}
