package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SalesTaxRate", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"StateProvinceID", "TaxType"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesTaxRate.findAll", query = "SELECT s FROM SalesTaxRate s"),
    @NamedQuery(name = "SalesTaxRate.findBySalesTaxRateID", query = "SELECT s FROM SalesTaxRate s WHERE s.salesTaxRateID = :salesTaxRateID"),
    @NamedQuery(name = "SalesTaxRate.findByStateProvinceID", query = "SELECT s FROM SalesTaxRate s WHERE s.stateProvinceID = :stateProvinceID"),
    @NamedQuery(name = "SalesTaxRate.findByTaxType", query = "SELECT s FROM SalesTaxRate s WHERE s.taxType = :taxType"),
    @NamedQuery(name = "SalesTaxRate.findByTaxRate", query = "SELECT s FROM SalesTaxRate s WHERE s.taxRate = :taxRate"),
    @NamedQuery(name = "SalesTaxRate.findByRowguid", query = "SELECT s FROM SalesTaxRate s WHERE s.rowguid = :rowguid"),
    @NamedQuery(name = "SalesTaxRate.findByModifiedDate", query = "SELECT s FROM SalesTaxRate s WHERE s.modifiedDate = :modifiedDate")})
public class SalesTaxRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SalesTaxRateID", nullable = false)
    private Integer salesTaxRateID;
    @Basic(optional = false)
    @Column(name = "StateProvinceID", nullable = false)
    private int stateProvinceID;
    @Basic(optional = false)
    @Column(name = "TaxType", nullable = false)
    private short taxType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TaxRate", nullable = false, precision = 10, scale = 4)
    private BigDecimal taxRate;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public SalesTaxRate(Integer salesTaxRateID) {
        this.salesTaxRateID = salesTaxRateID;
    }    
}
