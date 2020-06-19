package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SpecialOfferProduct", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SpecialOfferProduct.findAll", query = "SELECT s FROM SpecialOfferProduct s"),
    @NamedQuery(name = "SpecialOfferProduct.findBySpecialOfferID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.specialOfferID = :specialOfferID"),
    @NamedQuery(name = "SpecialOfferProduct.findByProductID", query = "SELECT s FROM SpecialOfferProduct s WHERE s.specialOfferProductPK.productID = :productID"),
    @NamedQuery(name = "SpecialOfferProduct.findByRowguid", query = "SELECT s FROM SpecialOfferProduct s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SpecialOfferProduct.findByModifiedDate", query = "SELECT s FROM SpecialOfferProduct s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOfferProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SpecialOfferProductPK specialOfferProductPK;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOfferProduct")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;
    @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpecialOffer specialOffer;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
