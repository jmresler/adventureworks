package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
@Table(name = "CurrencyRate", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CurrencyRateDate", "FromCurrencyCode", "ToCurrencyCode"})})
@XmlRootElement
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
    @Basic(optional = false)
    @Column(name = "CurrencyRateID", nullable = false)
    private Integer currencyRateID;
    @Basic(optional = false)
    @Column(name = "CurrencyRateDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date currencyRateDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AverageRate", nullable = false, precision = 19, scale = 4)
    private BigDecimal averageRate;
    @Basic(optional = false)
    @Column(name = "EndOfDayRate", nullable = false, precision = 19, scale = 4)
    private BigDecimal endOfDayRate;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "FromCurrencyCode", referencedColumnName = "CurrencyCode", nullable = false)
    @ManyToOne(optional = false)
    private Currency fromCurrencyCode;
    @JoinColumn(name = "ToCurrencyCode", referencedColumnName = "CurrencyCode", nullable = false)
    @ManyToOne(optional = false)
    private Currency toCurrencyCode;
    @XmlTransient
    @OneToMany(mappedBy = "currencyRateID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

    public CurrencyRate(Integer currencyRateID) {
        this.currencyRateID = currencyRateID;
    }
}
