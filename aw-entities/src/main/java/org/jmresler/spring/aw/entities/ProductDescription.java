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
@Table(name = "ProductDescription", schema = "Production", uniqueConstraints = {@UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDescription.findAll", query = "SELECT p FROM ProductDescription p"),
    @NamedQuery(name = "ProductDescription.findByProductDescriptionID", query = "SELECT p FROM ProductDescription p WHERE p.productDescriptionID = :productDescriptionID"),
    @NamedQuery(name = "ProductDescription.findByDescription", query = "SELECT p FROM ProductDescription p WHERE p.description = :description"),
    @NamedQuery(name = "ProductDescription.findByRowguid", query = "SELECT p FROM ProductDescription p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductDescription.findByModifiedDate", query = "SELECT p FROM ProductDescription p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductDescriptionID", nullable = false)
    private Integer productDescriptionID;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 400)
    private String description;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDescription")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public ProductDescription(Integer productDescriptionID) {
        this.productDescriptionID = productDescriptionID;
    }
}
