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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ProductPhoto", catalog = "AdventureWorks2017", schema = "Production")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
