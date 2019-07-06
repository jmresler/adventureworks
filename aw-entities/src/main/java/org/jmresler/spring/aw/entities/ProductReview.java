package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ProductReview", schema = "Production")
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
    @Basic(optional = false)
    @Column(name = "ProductReviewID", nullable = false)
    private Integer productReviewID;
    @Basic(optional = false)
    @Column(name = "ReviewDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    @Basic(optional = false)
    @Column(name = "EmailAddress", nullable = false, length = 50)
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "Rating", nullable = false)
    private int rating;
    @Column(name = "Comments", length = 3850)
    private String comments;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Product productID;

    public ProductReview(Integer productReviewID) {
        this.productReviewID = productReviewID;
    }
    
}
