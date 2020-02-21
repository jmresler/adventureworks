package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ProductReview", catalog = "AdventureWorks2017", schema = "Production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductReview.findAll", query = "SELECT p FROM ProductReview p"),
    @NamedQuery(name = "ProductReview.findByProductReviewID", query = "SELECT p FROM ProductReview p WHERE p.productReviewID = :productReviewID"),
    @NamedQuery(name = "ProductReview.findByReviewDate", query = "SELECT p FROM ProductReview p WHERE p.reviewDate = :reviewDate"),
    @NamedQuery(name = "ProductReview.findByEmailAddress", query = "SELECT p FROM ProductReview p WHERE p.emailAddress = :emailAddress"),
    @NamedQuery(name = "ProductReview.findByRating", query = "SELECT p FROM ProductReview p WHERE p.rating = :rating"),
    @NamedQuery(name = "ProductReview.findByComments", query = "SELECT p FROM ProductReview p WHERE p.comments = :comments"),
    @NamedQuery(name = "ProductReview.findByModifiedDate", query = "SELECT p FROM ProductReview p WHERE p.modifiedDate = :modifiedDate")})
public class ProductReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductReviewID")
    private Integer productReviewID;
    @Basic(optional = false)
    @Column(name = "ReviewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    @Basic(optional = false)
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "Rating")
    private int rating;
    @Column(name = "Comments")
    private String comments;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product productID;

    public ProductReview() {
    }

    public ProductReview(Integer productReviewID) {
        this.productReviewID = productReviewID;
    }

    public ProductReview(Integer productReviewID, Date reviewDate, String emailAddress, int rating, Date modifiedDate) {
        this.productReviewID = productReviewID;
        this.reviewDate = reviewDate;
        this.emailAddress = emailAddress;
        this.rating = rating;
        this.modifiedDate = modifiedDate;
    }

    public Integer getProductReviewID() {
        return productReviewID;
    }

    public void setProductReviewID(Integer productReviewID) {
        this.productReviewID = productReviewID;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productReviewID != null ? productReviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductReview)) {
            return false;
        }
        ProductReview other = (ProductReview) object;
        if ((this.productReviewID == null && other.productReviewID != null) || (this.productReviewID != null && !this.productReviewID.equals(other.productReviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.ProductReview[ productReviewID=" + productReviewID + " ]";
    }
    
}
