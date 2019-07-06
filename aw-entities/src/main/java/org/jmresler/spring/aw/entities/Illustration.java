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
@Table(name = "Illustration", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Illustration.findAll", query = "SELECT i FROM Illustration i"),
    @NamedQuery(name = "Illustration.findByIllustrationID", query = "SELECT i FROM Illustration i WHERE i.illustrationID = :illustrationID"),
    @NamedQuery(name = "Illustration.findByDiagram", query = "SELECT i FROM Illustration i WHERE i.diagram = :diagram"),
    @NamedQuery(name = "Illustration.findByModifiedDate", query = "SELECT i FROM Illustration i WHERE i.modifiedDate = :modifiedDate")})
public class Illustration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IllustrationID", nullable = false)
    private Integer illustrationID;
    @Column(name = "Diagram", length = 2147483647)
    private String diagram;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "illustration")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;

    public Illustration(Integer illustrationID) {
        this.illustrationID = illustrationID;
    }
}
