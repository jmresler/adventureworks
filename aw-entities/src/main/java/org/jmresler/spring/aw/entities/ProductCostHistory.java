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
@Table(name = "ProductCostHistory", schema = "Production")
@XmlRootElement
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "StandardCost", nullable = false, precision = 19, scale = 4)
    private BigDecimal standardCost;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductCostHistory(ProductCostHistoryPK productCostHistoryPK) {
        this.productCostHistoryPK = productCostHistoryPK;
    }    
}
