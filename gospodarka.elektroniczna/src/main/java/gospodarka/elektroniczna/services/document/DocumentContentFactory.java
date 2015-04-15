package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

/**
 * Fabryka zawartości dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentContentFactory {
    /**
     * Konstruktor.
     */
    private DocumentContentFactory() {
    }
    
    /**
     * Wytwarza zawartość dokumentu.
     * 
     * @param type typ dokumentu.
     * @return zawartość dokumentu.
     */
    public static <T> T createDocumentContent(final DocumentTypes type) {
        T content = null;
        
        switch (type) {
            case TEST:
                break;
            default:
                throw new IllegalArgumentException("");
            }
        
        return content;
    }
}