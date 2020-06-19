package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ProductListPriceHistory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductListPriceHistory.findAll", query = "SELECT p FROM ProductListPriceHistory p"),
    @NamedQuery(name = "ProductListPriceHistory.findByProductID", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.productID = :productID"),
    @NamedQuery(name = "ProductListPriceHistory.findByStartDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.productListPriceHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "ProductListPriceHistory.findByEndDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "ProductListPriceHistory.findByListPrice", query = "SELECT p FROM ProductListPriceHistory p WHERE p.listPrice = :listPrice"),
    @NamedQuery(name = "ProductListPriceHistory.findByModifiedDate", query = "SELECT p FROM ProductListPriceHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductListPriceHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductListPriceHistoryPK productListPriceHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "ListPrice")
    private BigDecimal listPrice;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
