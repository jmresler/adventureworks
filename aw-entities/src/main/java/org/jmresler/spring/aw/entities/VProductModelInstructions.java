package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
@Table(name = "vProductModelInstructions", catalog = "AdventureWorks2017", schema = "Production")

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
    @Column(name = "ProductModelID")
    private int productModelID;
    @Column(name = "Instructions")
    private String instructions;
    @Column(name = "LocationID")
    private Integer locationID;
    @Column(name = "SetupHours")
    private BigDecimal setupHours;
    @Column(name = "MachineHours")
    private BigDecimal machineHours;
    @Column(name = "LaborHours")
    private BigDecimal laborHours;
    @Column(name = "LotSize")
    private Integer lotSize;
    @Column(name = "Step")
    private String step;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public VProductModelInstructions() {
    }

    public int getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(int productModelID) {
        this.productModelID = productModelID;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public BigDecimal getSetupHours() {
        return setupHours;
    }

    public void setSetupHours(BigDecimal setupHours) {
        this.setupHours = setupHours;
    }

    public BigDecimal getMachineHours() {
        return machineHours;
    }

    public void setMachineHours(BigDecimal machineHours) {
        this.machineHours = machineHours;
    }

    public BigDecimal getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(BigDecimal laborHours) {
        this.laborHours = laborHours;
    }

    public Integer getLotSize() {
        return lotSize;
    }

    public void setLotSize(Integer lotSize) {
        this.lotSize = lotSize;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

	@Override
	public int hashCode() {
		return Objects.hash(instructions, laborHours, locationID, lotSize, machineHours, modifiedDate, productModelID,
				rowguid, setupHours, step);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VProductModelInstructions other = (VProductModelInstructions) obj;
		return Objects.equals(instructions, other.instructions) && Objects.equals(laborHours, other.laborHours)
				&& Objects.equals(locationID, other.locationID) && Objects.equals(lotSize, other.lotSize)
				&& Objects.equals(machineHours, other.machineHours) && Objects.equals(modifiedDate, other.modifiedDate)
				&& productModelID == other.productModelID && Objects.equals(rowguid, other.rowguid)
				&& Objects.equals(setupHours, other.setupHours) && Objects.equals(step, other.step);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VProductModelInstructions [productModelID=")
				.append(productModelID)
				.append(", instructions=")
				.append(instructions)
				.append(", locationID=")
				.append(locationID)
				.append(", setupHours=")
				.append(setupHours)
				.append(", machineHours=")
				.append(machineHours)
				.append(", laborHours=")
				.append(laborHours)
				.append(", lotSize=")
				.append(lotSize)
				.append(", step=")
				.append(step)
				.append(", rowguid=")
				.append(rowguid)
				.append(", modifiedDate=")
				.append(modifiedDate)
				.append("]");
		return builder.toString();
	}
    
    
}
