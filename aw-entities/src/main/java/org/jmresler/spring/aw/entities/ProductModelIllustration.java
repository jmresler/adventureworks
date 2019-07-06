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
@Table(name = "ProductModelIllustration", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModelIllustration.findAll", query = "SELECT p FROM ProductModelIllustration p"),
    @NamedQuery(name = "ProductModelIllustration.findByProductModelID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModelIllustration.findByIllustrationID", query = "SELECT p FROM ProductModelIllustration p WHERE p.productModelIllustrationPK.illustrationID = :illustrationID"),
    @NamedQuery(name = "ProductModelIllustration.findByModifiedDate", query = "SELECT p FROM ProductModelIllustration p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModelIllustration implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductModelIllustrationPK productModelIllustrationPK;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "IllustrationID", referencedColumnName = "IllustrationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Illustration illustration;
    @JoinColumn(name = "ProductModelID", referencedColumnName = "ProductModelID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductModel productModel;    
}
