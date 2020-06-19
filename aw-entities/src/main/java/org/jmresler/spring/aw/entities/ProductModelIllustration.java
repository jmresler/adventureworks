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
@Table(name = "ProductModelIllustration", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "ProductModelIllustration.findAll", query = "SELECT p FROM ProductModelIllustration p"),
    @NamedQuery(name = "ProductModelIllustration.findByProductModelID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModelIllustration.findByIllustrationID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.illustrationID = :illustrationID"),
    @NamedQuery(name = "ProductModelIllustration.findByModifiedDate", query = "SELECT p FROM ProductModelIllustration p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelIllustration implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductModelIllustrationPK productModelIllustrationPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "IllustrationID", referencedColumnName = "IllustrationID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Illustration illustration;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
