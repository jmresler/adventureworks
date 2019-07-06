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
@Table(name = "SpecialOfferProduct", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
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
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialOfferProduct")
    private Collection<SalesOrderDetail> salesOrderDetailCollection;
    @JoinColumn(name = "SpecialOfferID", referencedColumnName = "SpecialOfferID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SpecialOffer specialOffer;

    public SpecialOfferProduct(SpecialOfferProductPK specialOfferProductPK) {
        this.specialOfferProductPK = specialOfferProductPK;
    }    
}
