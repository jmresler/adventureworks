/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jmresler.spring.aw.entities;

import java.io.Serializable;
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "vProductModelCatalogDescription", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VProductModelCatalogDescription.findAll", query = "SELECT v FROM VProductModelCatalogDescription v"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByProductModelID", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productModelID = :productModelID"),
    @NamedQuery(name = "VProductModelCatalogDescription.findBySummary", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.summary = :summary"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByManufacturer", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.manufacturer = :manufacturer"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByCopyright", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.copyright = :copyright"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByProductURL", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productURL = :productURL"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByWarrantyPeriod", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.warrantyPeriod = :warrantyPeriod"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByWarrantyDescription", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.warrantyDescription = :warrantyDescription"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByNoOfYears", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.noOfYears = :noOfYears"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByMaintenanceDescription", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.maintenanceDescription = :maintenanceDescription"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByWheel", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.wheel = :wheel"),
    @NamedQuery(name = "VProductModelCatalogDescription.findBySaddle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.saddle = :saddle"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByPedal", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pedal = :pedal"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByBikeFrame", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.bikeFrame = :bikeFrame"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByCrankset", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.crankset = :crankset"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByPictureAngle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pictureAngle = :pictureAngle"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByPictureSize", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.pictureSize = :pictureSize"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByProductPhotoID", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productPhotoID = :productPhotoID"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByMaterial", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.material = :material"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByColor", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.color = :color"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByProductLine", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.productLine = :productLine"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByStyle", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.style = :style"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByRiderExperience", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.riderExperience = :riderExperience"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByRowguid", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.rowguid = :rowguid"),
    @NamedQuery(name = "VProductModelCatalogDescription.findByModifiedDate", query = "SELECT v FROM VProductModelCatalogDescription v WHERE v.modifiedDate = :modifiedDate")})
public class VProductModelCatalogDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductModelID")
    private int productModelID;
    @Column(name = "Summary")
    private String summary;
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Column(name = "Copyright")
    private String copyright;
    @Column(name = "ProductURL")
    private String productURL;
    @Column(name = "WarrantyPeriod")
    private String warrantyPeriod;
    @Column(name = "WarrantyDescription")
    private String warrantyDescription;
    @Column(name = "NoOfYears")
    private String noOfYears;
    @Column(name = "MaintenanceDescription")
    private String maintenanceDescription;
    @Column(name = "Wheel")
    private String wheel;
    @Column(name = "Saddle")
    private String saddle;
    @Column(name = "Pedal")
    private String pedal;
    @Column(name = "BikeFrame")
    private String bikeFrame;
    @Column(name = "Crankset")
    private String crankset;
    @Column(name = "PictureAngle")
    private String pictureAngle;
    @Column(name = "PictureSize")
    private String pictureSize;
    @Column(name = "ProductPhotoID")
    private String productPhotoID;
    @Column(name = "Material")
    private String material;
    @Column(name = "Color")
    private String color;
    @Column(name = "ProductLine")
    private String productLine;
    @Column(name = "Style")
    private String style;
    @Column(name = "RiderExperience")
    private String riderExperience;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public VProductModelCatalogDescription() {
    }

    public int getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(int productModelID) {
        this.productModelID = productModelID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyDescription() {
        return warrantyDescription;
    }

    public void setWarrantyDescription(String warrantyDescription) {
        this.warrantyDescription = warrantyDescription;
    }

    public String getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(String noOfYears) {
        this.noOfYears = noOfYears;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getSaddle() {
        return saddle;
    }

    public void setSaddle(String saddle) {
        this.saddle = saddle;
    }

    public String getPedal() {
        return pedal;
    }

    public void setPedal(String pedal) {
        this.pedal = pedal;
    }

    public String getBikeFrame() {
        return bikeFrame;
    }

    public void setBikeFrame(String bikeFrame) {
        this.bikeFrame = bikeFrame;
    }

    public String getCrankset() {
        return crankset;
    }

    public void setCrankset(String crankset) {
        this.crankset = crankset;
    }

    public String getPictureAngle() {
        return pictureAngle;
    }

    public void setPictureAngle(String pictureAngle) {
        this.pictureAngle = pictureAngle;
    }

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize;
    }

    public String getProductPhotoID() {
        return productPhotoID;
    }

    public void setProductPhotoID(String productPhotoID) {
        this.productPhotoID = productPhotoID;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getRiderExperience() {
        return riderExperience;
    }

    public void setRiderExperience(String riderExperience) {
        this.riderExperience = riderExperience;
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
    
}