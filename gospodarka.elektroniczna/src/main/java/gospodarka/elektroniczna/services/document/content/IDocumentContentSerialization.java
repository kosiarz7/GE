package gospodarka.elektroniczna.services.document.content;

import java.io.Serializable;

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
     * @param stream strumień bajtów.
     * @return zawartość dokumentu.
     */
    <T extends Serializable> T convertToDocumentContent(final byte[] stream);
    /**
     * Konwertuje przesłaną zawartość dokumentu na strumień bajtów.
     * 
     * @param documentContent zawartość dokumentu.
     * @return strumień bajtów.
     */
    <T extends Serializable> byte[] convertToStream(final T documentContent);
}