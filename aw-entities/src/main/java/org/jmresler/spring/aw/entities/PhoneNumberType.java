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
@Table(name = "PhoneNumberType", schema = "Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneNumberType.findAll", query = "SELECT p FROM PhoneNumberType p"),
    @NamedQuery(name = "PhoneNumberType.findByPhoneNumberTypeID", query = "SELECT p FROM PhoneNumberType p WHERE p.phoneNumberTypeID = :phoneNumberTypeID"),
    @NamedQuery(name = "PhoneNumberType.findByModifiedDate", query = "SELECT p FROM PhoneNumberType p WHERE p.modifiedDate = :modifiedDate")})
public class PhoneNumberType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PhoneNumberTypeID")
    private Integer phoneNumberTypeID;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneNumberType")
    private Collection<PersonPhone> personPhoneCollection;

    public PhoneNumberType(Integer phoneNumberTypeID) {
        this.phoneNumberTypeID = phoneNumberTypeID;
    }
}
