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
@Table(name = "Illustration", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "Illustration.findAll", query = "SELECT i FROM Illustration i"),
    @NamedQuery(name = "Illustration.findByIllustrationID", query = "SELECT i FROM Illustration i WHERE i.illustrationID = :illustrationID"),
    @NamedQuery(name = "Illustration.findByDiagram", query = "SELECT i FROM Illustration i WHERE i.diagram = :diagram"),
    @NamedQuery(name = "Illustration.findByModifiedDate", query = "SELECT i FROM Illustration i WHERE i.modifiedDate = :modifiedDate")})
public class Illustration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IllustrationID")
    private Integer illustrationID;
    @Column(name = "Diagram")
    private String diagram;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "illustration")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;

    public Illustration() {
    }

    public Illustration(Integer illustrationID) {
        this.illustrationID = illustrationID;
    }

    public Illustration(Integer illustrationID, Date modifiedDate) {
        this.illustrationID = illustrationID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getIllustrationID() {
        return illustrationID;
    }

    public void setIllustrationID(Integer illustrationID) {
        this.illustrationID = illustrationID;
    }

    public String getDiagram() {
        return diagram;
    }

    public void setDiagram(String diagram) {
        this.diagram = diagram;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Collection<ProductModelIllustration> getProductModelIllustrationCollection() {
        return productModelIllustrationCollection;
    }

    public void setProductModelIllustrationCollection(Collection<ProductModelIllustration> productModelIllustrationCollection) {
        this.productModelIllustrationCollection = productModelIllustrationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (illustrationID != null ? illustrationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Illustration)) {
            return false;
        }
        Illustration other = (Illustration) object;
        if ((this.illustrationID == null && other.illustrationID != null) || (this.illustrationID != null && !this.illustrationID.equals(other.illustrationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Illustration[ illustrationID=" + illustrationID + " ]";
    }
    
}
