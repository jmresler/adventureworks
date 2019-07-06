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
@Table(name = "UnitMeasure", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitMeasure.findAll", query = "SELECT u FROM UnitMeasure u"),
    @NamedQuery(name = "UnitMeasure.findByUnitMeasureCode", query = "SELECT u FROM UnitMeasure u WHERE u.unitMeasureCode = :unitMeasureCode"),
    @NamedQuery(name = "UnitMeasure.findByModifiedDate", query = "SELECT u FROM UnitMeasure u WHERE u.modifiedDate = :modifiedDate")})
public class UnitMeasure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UnitMeasureCode", nullable = false, length = 3)
    private String unitMeasureCode;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "sizeUnitMeasureCode")
    private Collection<Product> productCollection;
    @XmlTransient
    @OneToMany(mappedBy = "weightUnitMeasureCode")
    private Collection<Product> productCollection1;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitMeasureCode")
    private Collection<BillOfMaterials> billOfMaterialsCollection;

    public UnitMeasure(String unitMeasureCode) {
        this.unitMeasureCode = unitMeasureCode;
    }
    
}
