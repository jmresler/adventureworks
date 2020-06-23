package org.jmresler.spring.aw.entities.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "vProductView", catalog = "AdventureWorks2017", schema = "Production")
@NamedQueries({
    @NamedQuery(name = "VProductView.findAll", query = "SELECT v FROM VProductView v")})
public class VProductView implements Serializable {

	@SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
	
    @Id
    @Basic(optional = false)
    @Column(name = "PROD_ID")
    private Integer productID;

    @Basic(optional = false)
    @Column(name = "PROD_NAME")
    private String productName;

    @Basic(optional = false)
    @Column(name = "PROD_NUMBER")
    private String productNumber;

    @Basic(optional = false)
    @Column(name = "COLOR")
    private String productColor;
    
    @Basic(optional = false)
    @Column(name = "LIST_PRICE")
    private BigDecimal productListPrice;
    
    @Basic(optional = false)
    @Column(name = "SIZE")
    private String productSize;
    
    @Basic(optional = false)
    @Column(name = "WEIGHT")
    private Double productWeight;
    
    @Basic(optional = false)
    @Column(name = "PROD_LINE")
    private String productLine;
    
    @Basic(optional = false)
    @Column(name = "PROD_CATEGORY_ID")
    private Integer productCategoryID;
    
    @Basic(optional = false)
    @Column(name = "SUB_CATEGORY_ID")
    private Integer productSubCategoryID;
    
    @Basic(optional = false)
    @Column(name = "MODEL_ID")
    private Integer productModelID;
    
    @Basic(optional = false)
    @Column(name = "DISCONTINUED_DATE")
    private Date productDiscontinuedDate;
    
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String productRowGUID;
    
	@Override
	public String toString() {
		return getClass().getName() + "[productID=" + productID + "]";
	}
}
