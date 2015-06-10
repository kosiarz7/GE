package gospodarka.elektroniczna.services.document.content;

    
/**
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
     * Tworzy zawartość dokumentu.
     * 
     * @param type
     * @return
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static <T> T newDocumentContent(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
