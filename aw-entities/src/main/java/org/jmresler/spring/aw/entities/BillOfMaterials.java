package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
@Table(name = "BillOfMaterials", schema = "Production", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ProductAssemblyID", "ComponentID", "StartDate"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "BillOfMaterialsID", nullable = false)
    private Integer billOfMaterialsID;
    @Basic(optional = false)
    @Column(name = "StartDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "BOMLevel", nullable = false)
    private short bOMLevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PerAssemblyQty", nullable = false, precision = 8, scale = 2)
    private BigDecimal perAssemblyQty;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductAssemblyID", referencedColumnName = "ProductID")
    @ManyToOne
    private Product productAssemblyID;
    @JoinColumn(name = "ComponentID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product componentID;
    @JoinColumn(name = "UnitMeasureCode", referencedColumnName = "UnitMeasureCode", nullable = false)
    @ManyToOne(optional = false)
    private UnitMeasure unitMeasureCode;

    public BillOfMaterials(Integer billOfMaterialsID) {
        this.billOfMaterialsID = billOfMaterialsID;
    }    
}
