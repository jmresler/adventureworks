package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SpecialOffer", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "SpecialOffer.findAll", query = "SELECT s FROM SpecialOffer s"),
    @NamedQuery(name = "SpecialOffer.findBySpecialOfferID", query = "SELECT s FROM SpecialOffer s WHERE s.specialOfferID = :specialOfferID"),
    @NamedQuery(name = "SpecialOffer.findByDescription", query = "SELECT s FROM SpecialOffer s WHERE s.description = :description"),
    @NamedQuery(name = "SpecialOffer.findByDiscountPct", query = "SELECT s FROM SpecialOffer s WHERE s.discountPct = :discountPct"),
    @NamedQuery(name = "SpecialOffer.findByType", query = "SELECT s FROM SpecialOffer s WHERE s.type = :type"),
    @NamedQuery(name = "SpecialOffer.findByCategory", query = "SELECT s FROM SpecialOffer s WHERE s.category = :category"),
    @NamedQuery(name = "SpecialOffer.findByStartDate", query = "SELECT s FROM SpecialOffer s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SpecialOffer.findByEndDate", query = "SELECT s FROM SpecialOffer s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SpecialOffer.findByMinQty", query = "SELECT s FROM SpecialOffer s WHERE s.minQty = :minQty"),
    @NamedQuery(name = "SpecialOffer.findByMaxQty", query = "SELECT s FROM SpecialOffer s WHERE s.maxQty = :maxQty"),
    @NamedQuery(name = "SpecialOffer.findByRowguid", query = "SELECT s FROM SpecialOffer s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SpecialOffer.findByModifiedDate", query = "SELECT s FROM SpecialOffer s WHERE s.modifiedDate = :modifiedDate")})
public class SpecialOffer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpecialOfferID")
    private Integer specialOfferID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "DiscountPct")
    private BigDecimal discountPct;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @Column(name = "Category")
    private String category;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "MinQty")
    private int minQty;
    @Column(name = "MaxQty")
    private Integer maxQty;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOffer")
    private Collection<SpecialOfferProduct> specialOfferProductCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
