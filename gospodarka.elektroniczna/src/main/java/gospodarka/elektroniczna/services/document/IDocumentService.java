package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

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
    /**
     * Zwraca wszystkie nieprzetworzone dokumenty dla danego oddziału.
     * 
     * @param department oddział.
     * @return lista nieprzetworzonych dokumentów.
     */
    List<DocumentStub> loadCurrentDocumentsInDepartment(final Departments department);
    /**
     * Zwraca wszystkie nieprzetworzone dokumenty określonego typu dla danego oddziału.
     * 
     * @param department oddział.
     * @param type typ dokumentu.
     * @return lista nieprzetworzonych dokumentów.
     */
    List<DocumentStub> loadCurrentDocumentsInDepartment(final Departments department, final DocumentTypes type);
    /**
     * Ładuje zawartość dokumentu na podstawie jego "obciętej" wersji.
     * 
     * @param stub "obcięta" wersja dokumentu.
     * @return dokument.
     */
    <T> Document<T> loadCurrentDocument(final DocumentStub stub);
}