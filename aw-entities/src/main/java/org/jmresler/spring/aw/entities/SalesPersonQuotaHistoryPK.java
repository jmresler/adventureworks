package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Embeddable
public class SalesPersonQuotaHistoryPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2735132753405798314L;
	@Basic(optional = false)
    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Basic(optional = false)
    @Column(name = "QuotaDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date quotaDate;
}
