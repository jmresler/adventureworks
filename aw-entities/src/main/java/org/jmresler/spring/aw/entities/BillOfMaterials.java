package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "BillOfMaterials", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "BillOfMaterials.findAll", query = "SELECT b FROM BillOfMaterials b"),
    @NamedQuery(name = "BillOfMaterials.findByBillOfMaterialsID", query = "SELECT b FROM BillOfMaterials b WHERE b.billOfMaterialsID = :billOfMaterialsID"),
    @NamedQuery(name = "BillOfMaterials.findByStartDate", query = "SELECT b FROM BillOfMaterials b WHERE b.startDate = :startDate"),
    @NamedQuery(name = "BillOfMaterials.findByEndDate", query = "SELECT b FROM BillOfMaterials b WHERE b.endDate = :endDate"),
    @NamedQuery(name = "BillOfMaterials.findByBOMLevel", query = "SELECT b FROM BillOfMaterials b WHERE b.bOMLevel = :bOMLevel"),
    @NamedQuery(name = "BillOfMaterials.findByPerAssemblyQty", query = "SELECT b FROM BillOfMaterials b WHERE b.perAssemblyQty = :perAssemblyQty"),
    @NamedQuery(name = "BillOfMaterials.findByModifiedDate", query = "SELECT b FROM BillOfMaterials b WHERE b.modifiedDate = :modifiedDate")})
public class BillOfMaterials implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BillOfMaterialsID")
    private Integer billOfMaterialsID;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "BOMLevel")
    private short bOMLevel;
    @Basic(optional = false)
    @Column(name = "PerAssemblyQty")
    private BigDecimal perAssemblyQty;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductAssemblyID", referencedColumnName = "ProductID")
    @ManyToOne
    private Product productAssemblyID;
    @JoinColumn(name = "ComponentID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product componentID;
    @JoinColumn(name = "UnitMeasureCode", referencedColumnName = "UnitMeasureCode")
    @ManyToOne(optional = false)
    private UnitMeasure unitMeasureCode;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
