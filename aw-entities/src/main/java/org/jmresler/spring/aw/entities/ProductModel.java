package org.jmresler.spring.aw.entities;

import java.io.Serializable;
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
@Table(name = "ProductModel", schema = "Production", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModel.findAll", query = "SELECT p FROM ProductModel p"),
    @NamedQuery(name = "ProductModel.findByProductModelID", query = "SELECT p FROM ProductModel p WHERE p.productModelID = :productModelID"),
    @NamedQuery(name = "ProductModel.findByCatalogDescription", query = "SELECT p FROM ProductModel p WHERE p.catalogDescription = :catalogDescription"),
    @NamedQuery(name = "ProductModel.findByInstructions", query = "SELECT p FROM ProductModel p WHERE p.instructions = :instructions"),
    @NamedQuery(name = "ProductModel.findByRowguid", query = "SELECT p FROM ProductModel p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductModel.findByModifiedDate", query = "SELECT p FROM ProductModel p WHERE p.modifiedDate = :modifiedDate")})
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductModelID", nullable = false)
    private Integer productModelID;
    @Column(name = "CatalogDescription", length = 2147483647)
    private String catalogDescription;
    @Column(name = "Instructions", length = 2147483647)
    private String instructions;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;
    @XmlTransient
    @OneToMany(mappedBy = "productModelID")
    private Collection<Product> productCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public ProductModel(Integer productModelID) {
        this.productModelID = productModelID;
    }    
}
