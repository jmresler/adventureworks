package org.jmresler.spring.aw.entities.views;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author John
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "vProductAndDescription", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "VProductAndDescription.findAll", query = "SELECT v FROM VProductAndDescription v"),
    @NamedQuery(name = "VProductAndDescription.findByProductID", query = "SELECT v FROM VProductAndDescription v WHERE v.productID = :productID"),
    @NamedQuery(name = "VProductAndDescription.findByCultureID", query = "SELECT v FROM VProductAndDescription v WHERE v.cultureID = :cultureID"),
    @NamedQuery(name = "VProductAndDescription.findByDescription", query = "SELECT v FROM VProductAndDescription v WHERE v.description = :description")})
public class VProductAndDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @Column(name = "CultureID")
    private String cultureID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
