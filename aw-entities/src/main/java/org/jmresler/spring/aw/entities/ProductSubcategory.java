package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ProductSubcategory", schema = "Production", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p"),
    @NamedQuery(name = "ProductSubcategory.findByProductSubcategoryID", query = "SELECT p FROM ProductSubcategory p WHERE p.productSubcategoryID = :productSubcategoryID"),
    @NamedQuery(name = "ProductSubcategory.findByRowguid", query = "SELECT p FROM ProductSubcategory p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductSubcategory.findByModifiedDate", query = "SELECT p FROM ProductSubcategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductSubcategoryID", nullable = false)
    private Integer productSubcategoryID;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(mappedBy = "productSubcategoryID")
    private Collection<Product> productCollection;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID", nullable = false)
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;

    public ProductSubcategory(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

}
