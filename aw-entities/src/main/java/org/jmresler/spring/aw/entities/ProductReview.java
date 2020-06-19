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
@Table(name = "ProductReview", catalog = "AdventureWorks2017", schema = "Production")
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

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
