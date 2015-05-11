package gospodarka.elektroniczna.services.document.content;

import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

import java.io.Serializable;
import java.util.Map;

/**
 * Serwis konwertujący zawartość dokumentu na strumień bajtów i na odwrót.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentContentSerialization implements Serializable, IDocumentContentSerialization {
    /**
     * UID.
     */
    private static final long serialVersionUID = -8978730963194666185L;
    /**
     * Mapa konwerterów.
     */
    private Map<DocumentTypes, IDocumentContentService<?>> converters;
    
    /**
     * Konwertuje strumień bajtów na zawartość dokumentu.
     * 
     * @param documentType typ dokumentu.
     * @param stream strumień bajtów.
     * @return zawartość dokumentu.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T convertToDocumentContent(final DocumentTypes documentType, final byte[] stream) {
        return (T) getConverter(documentType).toDocument(stream);
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    private <T> IDocumentContentService<T> getConverter(final DocumentTypes documentType) {
        IDocumentContentService<?> converter = converters.get(documentType);
        if (null == converter) {
            throw new IllegalArgumentException("Brak konwertera dla: " + documentType);
        }
        return (IDocumentContentService<T>) converter;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> byte[] convertToStream(final DocumentTypes documentType, final T documentContent) {
        return getConverter(documentType).toByteStream(documentContent);
    }

    /**
     * Ustawia mapę konwerterów.
     * 
     * @param converters mapa konwerterów.
     */
    public void setConverters(final Map<DocumentTypes, IDocumentContentService<?>> converters) {
        this.converters = converters;
    }
}