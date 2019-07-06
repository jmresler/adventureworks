package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "Document", schema = "Production", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DocumentLevel", "DocumentNode"}),
    @UniqueConstraint(columnNames = {"rowguid"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByDocumentLevel", query = "SELECT d FROM Document d WHERE d.documentLevel = :documentLevel"),
    @NamedQuery(name = "Document.findByTitle", query = "SELECT d FROM Document d WHERE d.title = :title"),
    @NamedQuery(name = "Document.findByOwner", query = "SELECT d FROM Document d WHERE d.owner = :owner"),
    @NamedQuery(name = "Document.findByFolderFlag", query = "SELECT d FROM Document d WHERE d.folderFlag = :folderFlag"),
    @NamedQuery(name = "Document.findByFileName", query = "SELECT d FROM Document d WHERE d.fileName = :fileName"),
    @NamedQuery(name = "Document.findByFileExtension", query = "SELECT d FROM Document d WHERE d.fileExtension = :fileExtension"),
    @NamedQuery(name = "Document.findByRevision", query = "SELECT d FROM Document d WHERE d.revision = :revision"),
    @NamedQuery(name = "Document.findByChangeNumber", query = "SELECT d FROM Document d WHERE d.changeNumber = :changeNumber"),
    @NamedQuery(name = "Document.findByStatus", query = "SELECT d FROM Document d WHERE d.status = :status"),
    @NamedQuery(name = "Document.findByDocumentSummary", query = "SELECT d FROM Document d WHERE d.documentSummary = :documentSummary"),
    @NamedQuery(name = "Document.findByRowguid", query = "SELECT d FROM Document d WHERE d.rowguid = :rowguid"),
    @NamedQuery(name = "Document.findByModifiedDate", query = "SELECT d FROM Document d WHERE d.modifiedDate = :modifiedDate")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Lob
    @Column(name = "DocumentNode", nullable = false)
    private byte[] documentNode;
    @Column(name = "DocumentLevel")
    private Short documentLevel;
    @Basic(optional = false)
    @Column(name = "Title", nullable = false, length = 50)
    private String title;
    @Basic(optional = false)
    @Column(name = "Owner", nullable = false)
    private int owner;
    @Basic(optional = false)
    @Column(name = "FolderFlag", nullable = false)
    private boolean folderFlag;
    @Basic(optional = false)
    @Column(name = "FileName", nullable = false, length = 400)
    private String fileName;
    @Basic(optional = false)
    @Column(name = "FileExtension", nullable = false, length = 8)
    private String fileExtension;
    @Basic(optional = false)
    @Column(name = "Revision", nullable = false, length = 5)
    private String revision;
    @Basic(optional = false)
    @Column(name = "ChangeNumber", nullable = false)
    private int changeNumber;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private short status;
    @Column(name = "DocumentSummary", length = 2147483647)
    private String documentSummary;
    @Lob
    @Column(name = "Document")
    private byte[] document;
    @Basic(optional = false)
    @Column(name = "rowguid", nullable = false, length = 36)
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<ProductDocument> productDocumentCollection;

    public Document(byte[] documentNode) {
        this.documentNode = documentNode;
    }
}
