package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

/**
 * Interfejs do pracy z dokumentami.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentService {
    /**
     * Tworzy nowy dokuemnt.
     * 
     * @param type typ dokumentu.
     * @param title tytuł dokumentu.
     * @return nowy dokument.
     */
    <T> Document<T> createDocument(final DocumentTypes type, final String title);
    /**
     * Przesyład dokument ze źródłowego działu do docelowego.
     * 
     * @param document dokument.
     * @param source źródłowy dział.
     * @param target docelowy dział.
     */
    <T> void sendDocument(final Document<T> document, final Departments source, final Departments target);
    /**
     * Przenosi dokument do archiwum.
     * 
     * @param document dokument.
     * @param department dział, który dokonuje archiwizacji dokumentu.
     */
    <T> void archiveDocument(final Document<T> document, final Departments department);
}