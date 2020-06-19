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
@Table(name = "SalesTaxRate", catalog = "AdventureWorks2017", schema = "Sales")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SalesTaxRateID")
    private Integer salesTaxRateID;
    @Basic(optional = false)
    @Column(name = "StateProvinceID")
    private int stateProvinceID;
    @Basic(optional = false)
    @Column(name = "TaxType")
    private short taxType;
    @Basic(optional = false)
    @Column(name = "TaxRate")
    private BigDecimal taxRate;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
