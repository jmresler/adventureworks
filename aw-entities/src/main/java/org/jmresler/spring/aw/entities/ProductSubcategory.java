package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "ProductSubcategory", catalog = "AdventureWorks2017", schema = "Production")

@NamedQueries({
    @NamedQuery(name = "ProductSubcategory.findAll", query = "SELECT p FROM ProductSubcategory p"),
    @NamedQuery(name = "ProductSubcategory.findByProductSubcategoryID", query = "SELECT p FROM ProductSubcategory p WHERE p.productSubcategoryID = :productSubcategoryID"),
    @NamedQuery(name = "ProductSubcategory.findByRowguid", query = "SELECT p FROM ProductSubcategory p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductSubcategory.findByModifiedDate", query = "SELECT p FROM ProductSubcategory p WHERE p.modifiedDate = :modifiedDate")})
public class ProductSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductSubcategoryID")
    private Integer productSubcategoryID;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "productSubcategoryID")
    private Collection<Product> productCollection;
    
    @JsonManagedReference
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID")
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
