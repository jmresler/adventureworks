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
@Table(name = "Culture", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Culture.findAll", query = "SELECT c FROM Culture c"),
    @NamedQuery(name = "Culture.findByCultureID", query = "SELECT c FROM Culture c WHERE c.cultureID = :cultureID"),
    @NamedQuery(name = "Culture.findByModifiedDate", query = "SELECT c FROM Culture c WHERE c.modifiedDate = :modifiedDate")})
public class Culture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CultureID", nullable = false, length = 6)
    private String cultureID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culture")
    private Collection<ProductModelProductDescriptionCulture> productModelProductDescriptionCultureCollection;

    public Culture(String cultureID) {
        this.cultureID = cultureID;
    }
}
