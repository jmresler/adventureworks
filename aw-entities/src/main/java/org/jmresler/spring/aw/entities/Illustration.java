package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Illustration", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "Illustration.findAll", query = "SELECT i FROM Illustration i"),
    @NamedQuery(name = "Illustration.findByIllustrationID", query = "SELECT i FROM Illustration i WHERE i.illustrationID = :illustrationID"),
    @NamedQuery(name = "Illustration.findByDiagram", query = "SELECT i FROM Illustration i WHERE i.diagram = :diagram"),
    @NamedQuery(name = "Illustration.findByModifiedDate", query = "SELECT i FROM Illustration i WHERE i.modifiedDate = :modifiedDate")})
public class Illustration implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IllustrationID")
    private Integer illustrationID;
    @Column(name = "Diagram")
    private String diagram;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "illustration")
    private Collection<ProductModelIllustration> productModelIllustrationCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
