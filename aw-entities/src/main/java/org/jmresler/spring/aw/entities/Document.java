package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Document", catalog = "AdventureWorks2017", schema = "Production")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Lob
    @Column(name = "DocumentNode")
    private byte[] documentNode;
    @Column(name = "DocumentLevel")
    private Short documentLevel;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Owner")
    private int owner;
    @Basic(optional = false)
    @Column(name = "FolderFlag")
    private boolean folderFlag;
    @Basic(optional = false)
    @Column(name = "FileName")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "FileExtension")
    private String fileExtension;
    @Basic(optional = false)
    @Column(name = "Revision")
    private String revision;
    @Basic(optional = false)
    @Column(name = "ChangeNumber")
    private int changeNumber;
    @Basic(optional = false)
    @Column(name = "Status")
    private short status;
    @Column(name = "DocumentSummary")
    private String documentSummary;
    @Lob
    @Column(name = "Document")
    private byte[] document;
    @Basic(optional = false)
    @Column(name = "rowguid")
    private String rowguid;
    @Basic(optional = false)
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Collection<ProductDocument> productDocumentCollection;

	@Override
	public String toString() {
		return getClass().getName() + "[" + -1 + "]"; 
	}
}
