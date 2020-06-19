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
@Table(name = "ProductDescription", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ProductDescription.findAll", query = "SELECT p FROM ProductDescription p"),
    @NamedQuery(name = "ProductDescription.findByProductDescriptionID", query = "SELECT p FROM ProductDescription p WHERE p.productDescriptionID = :productDescriptionID"),
    @NamedQuery(name = "ProductDescription.findByDescription", query = "SELECT p FROM ProductDescription p WHERE p.description = :description"),
    @NamedQuery(name = "ProductDescription.findByRowguid", query = "SELECT p FROM ProductDescription p WHERE p.rowguid = :rowguid"),
    @NamedQuery(name = "ProductDescription.findByModifiedDate", query = "SELECT p FROM ProductDescription p WHERE p.modifiedDate = :modifiedDate")})
public class ProductDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductDescriptionID")
    private Integer productDescriptionID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDescription")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
