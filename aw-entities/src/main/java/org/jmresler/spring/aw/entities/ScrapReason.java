package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "ScrapReason", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScrapReason.findAll", query = "SELECT s FROM ScrapReason s"),
    @NamedQuery(name = "ScrapReason.findByScrapReasonID", query = "SELECT s FROM ScrapReason s WHERE s.scrapReasonID = :scrapReasonID"),
    @NamedQuery(name = "ScrapReason.findByModifiedDate", query = "SELECT s FROM ScrapReason s WHERE s.modifiedDate = :modifiedDate")})
public class ScrapReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ScrapReasonID", nullable = false)
    private Short scrapReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(mappedBy = "scrapReasonID")
    private Collection<WorkOrder> workOrderCollection;

    public ScrapReason(Short scrapReasonID) {
        this.scrapReasonID = scrapReasonID;
    }
    
}
