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
@Table(name = "ProductModelProductDescriptionCulture", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findAll", query = "SELECT p FROM ProductModelProductDescriptionCulture p"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductModelID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByProductDescriptionID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.productDescriptionID = :productDescriptionID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByCultureID", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.productModelProductDescriptionCulturePK.cultureID = :cultureID"),
    @NamedQuery(name = "ProductModelProductDescriptionCulture.findByModifiedDate", query = "SELECT p FROM ProductModelProductDescriptionCulture p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelProductDescriptionCulture implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductModelProductDescriptionCulturePK productModelProductDescriptionCulturePK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "CultureID", referencedColumnName = "CultureID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Culture culture;
    @JoinColumn(name = "ProductDescriptionID", referencedColumnName = "ProductDescriptionID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductDescription productDescription;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;    
}
