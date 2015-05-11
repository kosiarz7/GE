package gospodarka.elektroniczna.services.document.content;

/**
 * Serwis obsługujący operację związane z zawartościa dokumentu. 
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentContentService<T> {
    /**
     * Konwertuje zawartość dokument na strumień bajtów.
     * 
     * @param documentContent zawartość dokumentu.
     * @return strumień bajtów.
     */
    byte[] toByteStream(final T documentContent);
    /**
     * Konwertuje strumień bajtów na zawartość dokument.
     * 
     * @param stream strumień bajtów.
     * @return zawartość dokumentu.
     */
    T toDocument(final byte[] stream);
}