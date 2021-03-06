package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

import java.io.Serializable;
import java.util.List;

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
     * @param department oddział, z którego jest tworzonyc dokument.
     * @return nowy dokument.
     * @throws WrongNumberOfLastSignatureException rzucany gdy wystąpił błąd podczas generowani nowej sygnatury.
     */
    <T extends Serializable> Document<T> createDocument(final DocumentTypes type, final String title, final Departments department)
            throws WrongNumberOfLastSignatureException;
    /**
     * Przesyład dokument ze źródłowego działu do docelowego.
     * 
     * @param document dokument.
     * @param source źródłowy dział.
     * @param target docelowy dział.
     */
    <T extends Serializable> void sendDocument(final Document<T> document, final Departments source, final Departments target);
    /**
     * Przenosi dokument do archiwum.
     * 
     * @param document dokument.
     * @param department dział, który dokonuje archiwizacji dokumentu.
     */
    <T extends Serializable> void archiveDocument(final Document<T> document, final Departments department);
    /**
     * Ładuje zawartość dokumentu na podstawie jego "obciętej" wersji.
     * 
     * @param stub "obcięta" wersja dokumentu.
     * @return dokument.
     */
    <T extends Serializable> Document<T> loadCurrentDocument(final DocumentStub stub);
    /**
     * Wyszukuje dokumenty spełniające kryteria.
     * 
     * @param searchCriteria kryteria wyszukiwania.
     * @return dokumenty spełniające kryteria wyszukiwania.
     */
    List<DocumentStub> loadCurrentDocuments(final SearchCriteria searchCriteria);
}