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
@Table(name = "vPersonDemographics", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPersonDemographics.findAll", query = "SELECT v FROM VPersonDemographics v"),
    @NamedQuery(name = "VPersonDemographics.findByBusinessEntityID", query = "SELECT v FROM VPersonDemographics v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VPersonDemographics.findByTotalPurchaseYTD", query = "SELECT v FROM VPersonDemographics v WHERE v.totalPurchaseYTD = :totalPurchaseYTD"),
    @NamedQuery(name = "VPersonDemographics.findByDateFirstPurchase", query = "SELECT v FROM VPersonDemographics v WHERE v.dateFirstPurchase = :dateFirstPurchase"),
    @NamedQuery(name = "VPersonDemographics.findByBirthDate", query = "SELECT v FROM VPersonDemographics v WHERE v.birthDate = :birthDate"),
    @NamedQuery(name = "VPersonDemographics.findByMaritalStatus", query = "SELECT v FROM VPersonDemographics v WHERE v.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "VPersonDemographics.findByYearlyIncome", query = "SELECT v FROM VPersonDemographics v WHERE v.yearlyIncome = :yearlyIncome"),
    @NamedQuery(name = "VPersonDemographics.findByGender", query = "SELECT v FROM VPersonDemographics v WHERE v.gender = :gender"),
    @NamedQuery(name = "VPersonDemographics.findByTotalChildren", query = "SELECT v FROM VPersonDemographics v WHERE v.totalChildren = :totalChildren"),
    @NamedQuery(name = "VPersonDemographics.findByNumberChildrenAtHome", query = "SELECT v FROM VPersonDemographics v WHERE v.numberChildrenAtHome = :numberChildrenAtHome"),
    @NamedQuery(name = "VPersonDemographics.findByEducation", query = "SELECT v FROM VPersonDemographics v WHERE v.education = :education"),
    @NamedQuery(name = "VPersonDemographics.findByOccupation", query = "SELECT v FROM VPersonDemographics v WHERE v.occupation = :occupation"),
    @NamedQuery(name = "VPersonDemographics.findByHomeOwnerFlag", query = "SELECT v FROM VPersonDemographics v WHERE v.homeOwnerFlag = :homeOwnerFlag"),
    @NamedQuery(name = "VPersonDemographics.findByNumberCarsOwned", query = "SELECT v FROM VPersonDemographics v WHERE v.numberCarsOwned = :numberCarsOwned")})
public class VPersonDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalPurchaseYTD", precision = 19, scale = 4)
    private BigDecimal totalPurchaseYTD;
    @Column(name = "DateFirstPurchase")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFirstPurchase;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "MaritalStatus", length = 1)
    private String maritalStatus;
    @Column(name = "YearlyIncome", length = 30)
    private String yearlyIncome;
    @Column(name = "Gender", length = 1)
    private String gender;
    @Column(name = "TotalChildren")
    private Integer totalChildren;
    @Column(name = "NumberChildrenAtHome")
    private Integer numberChildrenAtHome;
    @Column(name = "Education", length = 30)
    private String education;
    @Column(name = "Occupation", length = 30)
    private String occupation;
    @Column(name = "HomeOwnerFlag")
    private Boolean homeOwnerFlag;
    @Column(name = "NumberCarsOwned")
    private Integer numberCarsOwned;
    
}
