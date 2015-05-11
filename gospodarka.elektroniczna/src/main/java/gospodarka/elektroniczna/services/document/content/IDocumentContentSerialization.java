package gospodarka.elektroniczna.services.document.content;

import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

/**
 * Serwis konwertujący zawartość dokumentu na strumień bajtów i na odwrót.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentContentSerialization {
    /**
     * Konwertuje strumień bajtów na zawartość dokumentu.
     * 
     * @param documentType typ dokumentu.
     * @param stream strumień bajtów.
     * @return zawartość dokumentu.
     */
    <T> T convertToDocumentContent(final DocumentTypes documentType, final byte[] stream);
    /**
     * Konwertuje przesłaną zawartość dokumentu na strumień bajtów.
     * 
     * @param documentType typ dokumentu.
     * @param documentContent zawartość dokumentu.
     * @return strumień bajtów.
     */
    <T> byte[] convertToStream(final DocumentTypes documentType, final T documentContent);
}