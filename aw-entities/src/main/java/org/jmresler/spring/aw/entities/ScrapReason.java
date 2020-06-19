package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "ScrapReason", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "ScrapReason.findAll", query = "SELECT s FROM ScrapReason s"),
    @NamedQuery(name = "ScrapReason.findByScrapReasonID", query = "SELECT s FROM ScrapReason s WHERE s.scrapReasonID = :scrapReasonID"),
    @NamedQuery(name = "ScrapReason.findByModifiedDate", query = "SELECT s FROM ScrapReason s WHERE s.modifiedDate = :modifiedDate")})
public class ScrapReason implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ScrapReasonID")
    private Short scrapReasonID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "scrapReasonID")
    private Collection<WorkOrder> workOrderCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
