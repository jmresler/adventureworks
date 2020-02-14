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

/**
 *
 * @author John
 */
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

    public Document() {
    }

    public Document(byte[] documentNode) {
        this.documentNode = documentNode;
    }

    public Document(byte[] documentNode, String title, int owner, boolean folderFlag, String fileName, String fileExtension, String revision, int changeNumber, short status, String rowguid, Date modifiedDate) {
        this.documentNode = documentNode;
        this.title = title;
        this.owner = owner;
        this.folderFlag = folderFlag;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.revision = revision;
        this.changeNumber = changeNumber;
        this.status = status;
        this.rowguid = rowguid;
        this.modifiedDate = modifiedDate;
    }

    public byte[] getDocumentNode() {
        return documentNode;
    }

    public void setDocumentNode(byte[] documentNode) {
        this.documentNode = documentNode;
    }

    public Short getDocumentLevel() {
        return documentLevel;
    }

    public void setDocumentLevel(Short documentLevel) {
        this.documentLevel = documentLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean getFolderFlag() {
        return folderFlag;
    }

    public void setFolderFlag(boolean folderFlag) {
        this.folderFlag = folderFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public int getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(int changeNumber) {
        this.changeNumber = changeNumber;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getDocumentSummary() {
        return documentSummary;
    }

    public void setDocumentSummary(String documentSummary) {
        this.documentSummary = documentSummary;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
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

    public Collection<ProductDocument> getProductDocumentCollection() {
        return productDocumentCollection;
    }

    public void setProductDocumentCollection(Collection<ProductDocument> productDocumentCollection) {
        this.productDocumentCollection = productDocumentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentNode != null ? documentNode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentNode == null && other.documentNode != null) || (this.documentNode != null && !this.documentNode.equals(other.documentNode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jmresler.spring.aw.entities.Document[ documentNode=" + documentNode + " ]";
    }
    
}
