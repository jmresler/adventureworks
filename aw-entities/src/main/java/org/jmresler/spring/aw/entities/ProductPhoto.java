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
import javax.persistence.Lob;
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
@Table(name = "ProductPhoto", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductPhoto.findAll", query = "SELECT p FROM ProductPhoto p"),
    @NamedQuery(name = "ProductPhoto.findByProductPhotoID", query = "SELECT p FROM ProductPhoto p WHERE p.productPhotoID = :productPhotoID"),
    @NamedQuery(name = "ProductPhoto.findByThumbnailPhotoFileName", query = "SELECT p FROM ProductPhoto p WHERE p.thumbnailPhotoFileName = :thumbnailPhotoFileName"),
    @NamedQuery(name = "ProductPhoto.findByLargePhotoFileName", query = "SELECT p FROM ProductPhoto p WHERE p.largePhotoFileName = :largePhotoFileName"),
    @NamedQuery(name = "ProductPhoto.findByModifiedDate", query = "SELECT p FROM ProductPhoto p WHERE p.modifiedDate = :modifiedDate")})
public class ProductPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductPhotoID")
    private Integer productPhotoID;
    @Lob
    @Column(name = "ThumbNailPhoto")
    private byte[] thumbNailPhoto;
    @Column(name = "ThumbnailPhotoFileName")
    private String thumbnailPhotoFileName;
    @Lob
    @Column(name = "LargePhoto")
    private byte[] largePhoto;
    @Column(name = "LargePhotoFileName")
    private String largePhotoFileName;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productPhoto")
    private Collection<ProductProductPhoto> productProductPhotoCollection;

    public ProductPhoto() {
    }

    public ProductPhoto(Integer productPhotoID) {
        this.productPhotoID = productPhotoID;
    }

    public ProductPhoto(Integer productPhotoID, Date modifiedDate) {
        this.productPhotoID = productPhotoID;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductPhotoID() {
        return productPhotoID;
    }

    public void setProductPhotoID(Integer productPhotoID) {
        this.productPhotoID = productPhotoID;
    }

    public byte[] getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    public void setThumbNailPhoto(byte[] thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
    }

    public String getThumbnailPhotoFileName() {
        return thumbnailPhotoFileName;
    }

    public void setThumbnailPhotoFileName(String thumbnailPhotoFileName) {
        this.thumbnailPhotoFileName = thumbnailPhotoFileName;
    }

    public byte[] getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(byte[] largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoFileName() {
        return largePhotoFileName;
    }

    public void setLargePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public Collection<ProductProductPhoto> getProductProductPhotoCollection() {
        return productProductPhotoCollection;
    }

    public void setProductProductPhotoCollection(Collection<ProductProductPhoto> productProductPhotoCollection) {
        this.productProductPhotoCollection = productProductPhotoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPhotoID != null ? productPhotoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPhoto)) {
            return false;
        }
        ProductPhoto other = (ProductPhoto) object;
        if ((this.productPhotoID == null && other.productPhotoID != null) || (this.productPhotoID != null && !this.productPhotoID.equals(other.productPhotoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductPhoto[ productPhotoID=" + productPhotoID + " ]";
    }
    
}
