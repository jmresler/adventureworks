package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "vProductModelInstructions", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProductModelInstructions.findAll", query = "SELECT v FROM VProductModelInstructions v"),
    @NamedQuery(name = "VProductModelInstructions.findByProductModelID", query = "SELECT v FROM VProductModelInstructions v WHERE v.productModelID = :productModelID"),
    @NamedQuery(name = "VProductModelInstructions.findByInstructions", query = "SELECT v FROM VProductModelInstructions v WHERE v.instructions = :instructions"),
    @NamedQuery(name = "VProductModelInstructions.findByLocationID", query = "SELECT v FROM VProductModelInstructions v WHERE v.locationID = :locationID"),
    @NamedQuery(name = "VProductModelInstructions.findBySetupHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.setupHours = :setupHours"),
    @NamedQuery(name = "VProductModelInstructions.findByMachineHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.machineHours = :machineHours"),
    @NamedQuery(name = "VProductModelInstructions.findByLaborHours", query = "SELECT v FROM VProductModelInstructions v WHERE v.laborHours = :laborHours"),
    @NamedQuery(name = "VProductModelInstructions.findByLotSize", query = "SELECT v FROM VProductModelInstructions v WHERE v.lotSize = :lotSize"),
    @NamedQuery(name = "VProductModelInstructions.findByStep", query = "SELECT v FROM VProductModelInstructions v WHERE v.step = :step"),
    @NamedQuery(name = "VProductModelInstructions.findByRowguid", query = "SELECT v FROM VProductModelInstructions v WHERE v.rowguid = :rowguid"),
    @NamedQuery(name = "VProductModelInstructions.findByModifiedDate", query = "SELECT v FROM VProductModelInstructions v WHERE v.modifiedDate = :modifiedDate")})
public class VProductModelInstructions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductModelID", nullable = false)
    private int productModelID;
    @Column(name = "Instructions", length = 2147483647)
    private String instructions;
    @Column(name = "LocationID")
    private Integer locationID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SetupHours", precision = 9, scale = 4)
    private BigDecimal setupHours;
    @Column(name = "MachineHours", precision = 9, scale = 4)
    private BigDecimal machineHours;
    @Column(name = "LaborHours", precision = 9, scale = 4)
    private BigDecimal laborHours;
    @Column(name = "LotSize")
    private Integer lotSize;
    @Column(name = "Step", length = 1024)
    private String step;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
}
