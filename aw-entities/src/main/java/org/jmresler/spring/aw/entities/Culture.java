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

/**
 *
 * @author John
 */
@Entity
@Table(name = "Culture", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "Culture.findAll", query = "SELECT c FROM Culture c"),
    @NamedQuery(name = "Culture.findByCultureID", query = "SELECT c FROM Culture c WHERE c.cultureID = :cultureID"),
    @NamedQuery(name = "Culture.findByModifiedDate", query = "SELECT c FROM Culture c WHERE c.modifiedDate = :modifiedDate")})
public class Culture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CultureID")
    private String cultureID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culture")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public Culture() {
    }

    public Culture(String cultureID) {
        this.cultureID = cultureID;
    }

    public Culture(String cultureID, Date modifiedDate) {
        this.cultureID = cultureID;
        this.modifiedDate = modifiedDate;
    }

    public String getCultureID() {
        return cultureID;
    }

    public void setCultureID(String cultureID) {
        this.cultureID = cultureID;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<ProductModelProductDescriptionCulture> getProductModelProductDescriptionCultureCollection() {
        return productModelProductDescriptionCultureCollection;
    }

    public void setProductModelProductDescriptionCultureCollection(Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection) {
        this.productModelProductDescriptionCultureCollection = productModelProductDescriptionCultureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cultureID != null ? cultureID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Culture)) {
            return false;
        }
        Culture other = (Culture) object;
        if ((this.cultureID == null && other.cultureID != null) || (this.cultureID != null && !this.cultureID.equals(other.cultureID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Culture[ cultureID=" + cultureID + " ]";
    }
    
}
