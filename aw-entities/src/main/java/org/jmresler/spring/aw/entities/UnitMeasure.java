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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "UnitMeasure", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "UnitMeasure.findAll", query = "SELECT u FROM UnitMeasure u"),
    @NamedQuery(name = "UnitMeasure.findByUnitMeasureCode", query = "SELECT u FROM UnitMeasure u WHERE u.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "UnitMeasure.findByModifiedDate", query = "SELECT u FROM UnitMeasure u WHERE u.modifiedDate = :modifiedDate")})
public class UnitMeasure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode")
    private String unitMeasureCode;
    
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @JsonBackReference
    @OneToMany(mappedBy = "sizeUnitMeasureCode")
    private Collection<Product> productCollection;
    
    @JsonBackReference
    @OneToMany(mappedBy = "weightUnitMeasureCode")
    private Collection<Product> productCollection1;
    
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitMeasureCode")
    private Collection<BillOfMaterials> billOfMaterialsCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + unitMeasureCode + "]"; 
	}
}
