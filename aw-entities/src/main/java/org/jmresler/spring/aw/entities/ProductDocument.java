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
@Table(name = "ProductDocument", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductDocument.findAll", query = "SELECT p FROM ProductDocument p"),
    @NamedQuery(name = "ProductDocument.findByProductID", query = "SELECT p FROM ProductDocument p WHERE p.productDocumentPK.productID = :productID"),
    @NamedQuery(name = "ProductDocument.findByModifiedDate", query = "SELECT p FROM ProductDocument p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductDocumentPK productDocumentPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "DocumentNode", referencedColumnName = "DocumentNode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
