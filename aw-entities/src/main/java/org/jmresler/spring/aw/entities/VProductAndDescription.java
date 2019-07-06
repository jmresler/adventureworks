package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "vProductAndDescription", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProductAndDescription.findAll", query = "SELECT v FROM VProductAndDescription v"),
    @NamedQuery(name = "VProductAndDescription.findByProductID", query = "SELECT v FROM VProductAndDescription v WHERE v.productID = :productID"),
    @NamedQuery(name = "VProductAndDescription.findByCultureID", query = "SELECT v FROM VProductAndDescription v WHERE v.cultureID = :cultureID"),
    @NamedQuery(name = "VProductAndDescription.findByDescription", query = "SELECT v FROM VProductAndDescription v WHERE v.description = :description")})
public class VProductAndDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductID", nullable = false)
    private int productID;
    @Basic(optional = false)
    @Column(name = "CultureID", nullable = false, length = 6)
    private String cultureID;
    @Basic(optional = false)
    @Column(name = "Description", nullable = false, length = 400)
    private String description;
    
}
