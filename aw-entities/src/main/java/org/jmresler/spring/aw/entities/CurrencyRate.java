package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CurrencyRate", catalog = "AdventureWorks2017", schema = "Sales")
@NamedQueries({
    @NamedQuery(name = "CurrencyRate.findAll", query = "SELECT c FROM CurrencyRate c"),
    @NamedQuery(name = "CurrencyRate.findByCurrencyRateID", query = "SELECT c FROM CurrencyRate c WHERE c.currencyRateID = :currencyRateID"),
    @NamedQuery(name = "CurrencyRate.findByCurrencyRateDate", query = "SELECT c FROM CurrencyRate c WHERE c.currencyRateDate = :currencyRateDate"),
    @NamedQuery(name = "CurrencyRate.findByAverageRate", query = "SELECT c FROM CurrencyRate c WHERE c.averageRate = :averageRate"),
    @NamedQuery(name = "CurrencyRate.findByEndOfDayRate", query = "SELECT c FROM CurrencyRate c WHERE c.endOfDayRate = :endOfDayRate"),
    @NamedQuery(name = "CurrencyRate.findByModifiedDate", query = "SELECT c FROM CurrencyRate c WHERE c.modifiedDate = :modifiedDate")})
public class CurrencyRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CurrencyRateID")
    private Integer currencyRateID;
    @Basic(optional = false)
    @Column(name = "CurrencyRateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currencyRateDate;
    @Basic(optional = false)
    @Column(name = "AverageRate")
    private BigDecimal averageRate;
    @Basic(optional = false)
    @Column(name = "EndOfDayRate")
    private BigDecimal endOfDayRate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "FromCurrencyCode", referencedColumnName = "CurrencyCode")
    @ManyToOne(optional = false)
    private Currency fromCurrencyCode;
    @JoinColumn(name = "ToCurrencyCode", referencedColumnName = "CurrencyCode")
    @ManyToOne(optional = false)
    private Currency toCurrencyCode;
    @OneToMany(mappedBy = "currencyRateID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
