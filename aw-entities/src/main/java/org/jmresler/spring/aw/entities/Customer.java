package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Customer", schema = "Sales", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"AccountNumber"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "Customer.findByPersonID", query = "SELECT c FROM Customer c WHERE c.personID = :personID"),
    @NamedQuery(name = "Customer.findByAccountNumber", query = "SELECT c FROM Customer c WHERE c.accountNumber = :accountNumber"),
    @NamedQuery(name = "Customer.findByRowguid", query = "SELECT c FROM Customer c WHERE c.rowguid = :rowguid"),
    @NamedQuery(name = "Customer.findByModifiedDate", query = "SELECT c FROM Customer c WHERE c.modifiedDate = :modifiedDate")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;
    @Column(name = "PersonID")
    private Integer personID;
    @Basic(optional = false)
    @Column(name = "AccountNumber", nullable = false, length = 10)
    private String accountNumber;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "TerritoryID", referencedColumnName = "TerritoryID")
    @ManyToOne
    private SalesTerritory territoryID;
    @JoinColumn(name = "StoreID", referencedColumnName = "BusinessEntityID")
    @ManyToOne
    private Store storeID;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<SalesOrderHeader> salesOrderHeaderCollection;

    public Customer(Integer customerID) {
        this.customerID = customerID;
    }
}
