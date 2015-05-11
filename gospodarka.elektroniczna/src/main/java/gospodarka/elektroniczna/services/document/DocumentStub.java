package gospodarka.elektroniczna.services.document;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

/**
 * "Lżejsza" wersja dokumentu. Zawiera wszystkie metadane o dokumencie, tj. wszystko poza zawartością.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public class DocumentStub implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = -675498109049583279L;
    /**
     * Id zawartości dokumentu.
     */
    private int contentId;
    /**
     * Id nagłówka.
     */
    private int headerId;
    /**
     * Sygnatura.
     */
    private String signature;
    /**
     * Tytuł.
     */
    private String title;
    /**
     * Typ dokumentu.
     */
    private DocumentTypes type;
    /**
     * Oddział, który wysłała dokument.
     */
    private Departments from;
    /**
     * Oddział, który odebrał dokument.
     */
    private Departments to;
    /**
     * Data odbioru dokumentu przez oddział docelowy.
     */
    private Date dateOfRecipte;

    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // GETTERY I SETTERY
    int getHeaderId() {
        return headerId;
    }

    void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    /**
     * Zwarca sygnaturę dokumentu.
     * 
     * @return sygnatura dokumentu.
     */
    public String getSignature() {
        return signature;
    }

    void setSignature(String signature) {
        this.signature = signature;
    }
    
    /**
     * Zwraca id zawartości dokumentu.
     * 
     * @return id zawartości dokumentu.
     */
    public int getContentId() {
        return contentId;
    }

    void setContentId(int contentId) {
        this.contentId = contentId;
    }

    /**
     * Zwraca tytuł dokumentu.
     * 
     * @return tytuł dokumentu.
     */
    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    /**
     * Zwraca typ dokumentu.
     * 
     * @return typ dokumentu.
     */
    public DocumentTypes getType() {
        return type;
    }

    void setType(DocumentTypes type) {
        this.type = type;
    }

    /**
     * Zwraca oddział, który przesłał dokument.
     * 
     * @return oddział, który przesłał dokument.
     */
    public Departments getFrom() {
        return from;
    }

    void setFrom(Departments from) {
        this.from = from;
    }

    /**
     * Zwraca oddział, który odebrał dokument.
     * 
     * @return oddział, który odbrał dokument.
     */
    public Departments getTo() {
        return to;
    }

    void setTo(Departments to) {
        this.to = to;
    }

    /**
     * Zwraca datę odbioru dokumentu przez oddział docelowy.
     * 
     * @return data odbioru dokumentu przez oddział docelowy.
     */
    public Date getDateOfRecipte() {
        return dateOfRecipte;
    }

    void setDateOfRecipte(Date dateOfRecipte) {
        this.dateOfRecipte = dateOfRecipte;
    }
}
