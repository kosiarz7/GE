package gospodarka.elektroniczna.services.document;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Dokument.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class Document<T> implements Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = -5561620646849987040L;
    /**
     * Nagłówek dokumentu.
     */
    private DocumentHeader header;
    /**
     * Zawartość dokumentu.
     */
    private T content;
    
    
    /**
     * Konstruktor.
     */
    public Document() {
    }
    
    /**
     * Konstruktor.
     * 
     * @param header nagłówek dokumentu.
     * @param content zawartość dokumentu.
     */
    public Document(final DocumentHeader header, final T content) {
        this.header = header;
        this.content = content;
    }

    /**
     * Zwraca zawartość dokumentu.
     * 
     * @return zawartość dokumentu.
     */
    public T getContent() {
        return content;
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Ustawia zawartość dokumentu.
     * 
     * @param content zawartość dokumentu.
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Zwraca nagłówek dokumentu.
     * 
     * @return nagłówek dokumentu.
     */
    public DocumentHeader getHeader() {
        return header;
    }

    /**
     * Ustawia nagłówek dokumentu.
     * 
     * @param header nagłówek dokumentu.
     */
    void setHeader(final DocumentHeader header) {
        this.header = header;
    }
}