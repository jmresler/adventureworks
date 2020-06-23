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

import lombok.EqualsAndHashCode;
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
@Table(name = "ProductCostHistory", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductCostHistory.findAll", query = "SELECT p FROM ProductCostHistory p"),
    @NamedQuery(name = "ProductCostHistory.findByProductID", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.productID = :productID"),
    @NamedQuery(name = "ProductCostHistory.findByStartDate", query = "SELECT p FROM ProductCostHistory p WHERE p.productCostHistoryPK.startDate = :startDate"),
    @NamedQuery(name = "ProductCostHistory.findByEndDate", query = "SELECT p FROM ProductCostHistory p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "ProductCostHistory.findByStandardCost", query = "SELECT p FROM ProductCostHistory p WHERE p.standardCost = :standardCost"),
    @NamedQuery(name = "ProductCostHistory.findByModifiedDate", query = "SELECT p FROM ProductCostHistory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductCostHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ProductCostHistoryPK productCostHistoryPK;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "StandardCost")
    private BigDecimal standardCost;
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
