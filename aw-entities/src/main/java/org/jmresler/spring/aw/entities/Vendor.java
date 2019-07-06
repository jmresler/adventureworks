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
@Table(name = "Vendor", schema = "Purchasing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByBusinessEntityID", query = "SELECT v FROM Vendor v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "Vendor.findByCreditRating", query = "SELECT v FROM Vendor v WHERE v.creditRating = :creditRating"),
    @NamedQuery(name = "Vendor.findByPurchasingWebServiceURL", query = "SELECT v FROM Vendor v WHERE v.purchasingWebServiceURL = :purchasingWebServiceURL"),
    @NamedQuery(name = "Vendor.findByModifiedDate", query = "SELECT v FROM Vendor v WHERE v.modifiedDate = :modifiedDate")})
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "CreditRating", nullable = false)
    private short creditRating;
    @Column(name = "PurchasingWebServiceURL", length = 1024)
    private String purchasingWebServiceURL;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorID")
    private Collection<PurchaseOrderHeader> purchaseOrderHeaderCollection;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Collection<ProductVendor> productVendorCollection;

    public Vendor(Integer businessEntityID) {
        this.businessEntityID = businessEntityID;
    }
}
