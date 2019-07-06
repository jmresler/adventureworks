package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ProductPhoto", schema = "Production")
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
    @Basic(optional = false)
    @Column(name = "ProductPhotoID", nullable = false)
    private Integer productPhotoID;
    @Lob
    @Column(name = "ThumbNailPhoto")
    private byte[] thumbNailPhoto;
    @Column(name = "ThumbnailPhotoFileName", length = 50)
    private String thumbnailPhotoFileName;
    @Lob
    @Column(name = "LargePhoto")
    private byte[] largePhoto;
    @Column(name = "LargePhotoFileName", length = 50)
    private String largePhotoFileName;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productPhoto")
    private Collection<ProductProductPhoto> productProductPhotoCollection;

    public ProductPhoto(Integer productPhotoID) {
        this.productPhotoID = productPhotoID;
    }
}
