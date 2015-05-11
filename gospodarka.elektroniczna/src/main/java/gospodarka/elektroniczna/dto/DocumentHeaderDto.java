package gospodarka.elektroniczna.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Encja reprezentująca nagłówek dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
@Entity
@Table(name = "DOCUMENT_HEADERS")
public class DocumentHeaderDto extends AbstractDto implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = -3258293994778201216L;
    /**
     * Id nagłówka dokumentu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;
    /**
     * Tytuł dokumentu.
     */
    @Column(name = "TITLE", nullable = false, length = 512)
    private String title;
    /**
     * Sygnatura.
     */
    @Column(name = "SIGNATURE", nullable = false, length = 15)
    private String signature;
    /**
     * Typ dokumentu.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE_ID", nullable = false)
    private DocumentTypeDto documentType;

    /**
     * Konstruktor.
     */
    public DocumentHeaderDto() {
        id = UNLOADED_ID;
    }

    // GETTERY I SETTERY
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public DocumentTypeDto getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDto documentType) {
        this.documentType = documentType;
    }
}
