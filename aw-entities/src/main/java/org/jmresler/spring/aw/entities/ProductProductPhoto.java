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
@Table(name = "ProductProductPhoto", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductProductPhoto.findAll", query = "SELECT p FROM ProductProductPhoto p"),
    @NamedQuery(name = "ProductProductPhoto.findByProductID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productID = :productID"),
    @NamedQuery(name = "ProductProductPhoto.findByProductPhotoID", query = "SELECT p FROM ProductProductPhoto p WHERE p.productProductPhotoPK.productPhotoID = :productPhotoID"),
    @NamedQuery(name = "ProductProductPhoto.findByModifiedDate", query = "SELECT p FROM ProductProductPhoto p WHERE p.modifiedDate = :modifiedDate")})
public class ProductProductPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductProductPhotoPK productProductPhotoPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ProductPhotoID", referencedColumnName = "ProductPhotoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductPhoto productPhoto;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
