package org.jmresler.spring.aw.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BusinessEntity", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "BusinessEntity.findAll", query = "SELECT b FROM BusinessEntity b"),
    @NamedQuery(name = "BusinessEntity.findByBusinessEntityID", query = "SELECT b FROM BusinessEntity b WHERE b.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "BusinessEntity.findByRowguid", query = "SELECT b FROM BusinessEntity b WHERE b.rowguid = :rowguid"),
    @NamedQuery(name = "BusinessEntity.findByModifiedDate", query = "SELECT b FROM BusinessEntity b WHERE b.modifiedDate = :modifiedDate")})
public class BusinessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityContact> businessEntityContactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Collection<BusinessEntityAddress> businessEntityAddressCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "businessEntity")
    private Person person;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
