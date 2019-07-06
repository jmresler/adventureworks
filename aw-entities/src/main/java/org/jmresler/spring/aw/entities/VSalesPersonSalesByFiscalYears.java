package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "vSalesPersonSalesByFiscalYears", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findAll", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findBySalesPersonID", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.salesPersonID = :salesPersonID"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByFullName", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByJobTitle", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.jobTitle = :jobTitle"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a = :a"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA1", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a1 = :a1"),
    @NamedQuery(name = "VSalesPersonSalesByFiscalYears.findByA2", query = "SELECT v FROM VSalesPersonSalesByFiscalYears v WHERE v.a2 = :a2")})
public class VSalesPersonSalesByFiscalYears implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SalesPersonID")
    private Integer salesPersonID;
    @Column(name = "FullName", length = 152)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "JobTitle", nullable = false, length = 50)
    private String jobTitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "2002", precision = 19, scale = 4)
    private BigDecimal a;
    @Column(name = "2003", precision = 19, scale = 4)
    private BigDecimal a1;
    @Column(name = "2004", precision = 19, scale = 4)
    private BigDecimal a2;
    
}
