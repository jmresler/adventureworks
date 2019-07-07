/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author John
 */
@Entity
@Table(name = "vStoreWithContacts", catalog = "AdventureWorks2017", schema = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VStoreWithContacts.findAll", query = "SELECT v FROM VStoreWithContacts v"),
    @NamedQuery(name = "VStoreWithContacts.findByBusinessEntityID", query = "SELECT v FROM VStoreWithContacts v WHERE v.businessEntityID = :businessEntityID"),
    @NamedQuery(name = "VStoreWithContacts.findByTitle", query = "SELECT v FROM VStoreWithContacts v WHERE v.title = :title"),
    @NamedQuery(name = "VStoreWithContacts.findBySuffix", query = "SELECT v FROM VStoreWithContacts v WHERE v.suffix = :suffix"),
    @NamedQuery(name = "VStoreWithContacts.findByEmailAddress", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailAddress = :emailAddress"),
    @NamedQuery(name = "VStoreWithContacts.findByEmailPromotion", query = "SELECT v FROM VStoreWithContacts v WHERE v.emailPromotion = :emailPromotion")})
public class VStoreWithContacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Column(name = "Suffix")
    private String suffix;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "EmailPromotion")
    private int emailPromotion;

    public VStoreWithContacts() {
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getEmailPromotion() {
        return emailPromotion;
    }

    public void setEmailPromotion(int emailPromotion) {
        this.emailPromotion = emailPromotion;
    }
    
}
