package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "SpecialOffer", schema = "Sales", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "SpecialOfferID", nullable = false)
    private Integer specialOfferID;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 255)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DiscountPct", nullable = false, precision = 10, scale = 4)
    private BigDecimal discountPct;
    @Basic(optional = false)
    @Column(name = "Type", nullable = false, length = 50)
    private String type;
    @Basic(optional = false)
    @Column(name = "Category", nullable = false, length = 50)
    private String category;
    @Basic(optional = false)
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "MinQty", nullable = false)
    private int minQty;
    @Column(name = "MaxQty")
    private Integer maxQty;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOffer")
    private Collection<SpecialOfferProduct> specialOfferProductCollection;

    public SpecialOffer(Integer specialOfferID) {
        this.specialOfferID = specialOfferID;
    }
}
