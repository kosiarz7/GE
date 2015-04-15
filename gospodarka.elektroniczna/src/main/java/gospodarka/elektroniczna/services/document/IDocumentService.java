package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

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
     * @throws WrongNumberOfLastSignatureException rzucany gdy wystąpił błąd podczas generowani nowej sygnatury.
     */
    <T> Document<T> createDocument(final DocumentTypes type, final String title)
            throws WrongNumberOfLastSignatureException;
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