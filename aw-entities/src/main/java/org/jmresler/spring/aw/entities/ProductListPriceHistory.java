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
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "ProductListPriceHistory", schema = "Production")
@XmlRootElement
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ListPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal listPrice;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductListPriceHistory(ProductListPriceHistoryPK productListPriceHistoryPK) {
        this.productListPriceHistoryPK = productListPriceHistoryPK;
    }
    
}
