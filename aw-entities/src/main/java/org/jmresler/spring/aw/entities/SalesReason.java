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
@Table(name = "SalesReason", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesReason.findAll", query = "SELECT s FROM SalesReason s"),
    @NamedQuery(name = "SalesReason.findBySalesReasonID", query = "SELECT s FROM SalesReason s WHERE s.salesReasonID = :salesReasonID"),
    @NamedQuery(name = "SalesReason.findByModifiedDate", query = "SELECT s FROM SalesReason s WHERE s.modifiedDate = :modifiedDate")})
public class SalesReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SalesReasonID", nullable = false)
    private Integer salesReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesReason")
    private Collection<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasonCollection;

    public SalesReason(Integer salesReasonID) {
        this.salesReasonID = salesReasonID;
    }    
}
