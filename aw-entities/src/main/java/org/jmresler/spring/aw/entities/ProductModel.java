package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "ProductModel", catalog = "AdventureWorks2017", schema = "Production")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductModelID")
    private Integer productModelID;
    @Column(name = "CatalogDescription")
    private String catalogDescription;
    @Column(name = "Instructions")
    private String instructions;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;
    @OneToMany(mappedBy = "productModelID")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productModel")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
