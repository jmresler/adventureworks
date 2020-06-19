package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "EmailAddress", catalog = "AdventureWorks2017", schema = "Person")
@NamedQueries({
    @NamedQuery(name = "EmailAddress.findAll", query = "SELECT e FROM EmailAddress e"),
    @NamedQuery(name = "EmailAddress.findByBusinessEntityID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "EmailAddress.findByEmailAddressID", query = "SELECT e FROM EmailAddress e WHERE e.emailAddressPK.emailAddressID = :emailAddressID"),
    @NamedQuery(name = "EmailAddress.findByEmailAddress", query = "SELECT e FROM EmailAddress e WHERE e.emailAddress = :emailAddress"),
    @NamedQuery(name = "EmailAddress.findByRowguid", query = "SELECT e FROM EmailAddress e WHERE e.rowguid = :rowguid"),
    @NamedQuery(name = "EmailAddress.findByModifiedDate", query = "SELECT e FROM EmailAddress e WHERE e.modifiedDate = :modifiedDate")})
public class EmailAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EmailAddressPK emailAddressPK;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
