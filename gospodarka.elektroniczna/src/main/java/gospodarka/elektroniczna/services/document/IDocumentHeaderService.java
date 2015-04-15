package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

/**
 * Funkcjonalność serwisu związana z obsługą nagłówków dokumentów. 
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
interface IDocumentHeaderService {
    /**
     * Towrzy nowy nagłówek dokumentu.
     * 
     * @param type typ dokumentu.
     * @param title tytuł dokumentu.
     * @return nagłówek dokumentu.
     * @throws WrongNumberOfLastSignatureException rzucany gdy wystąpił błąd podczas generowani nowej sygnatury.
     */
    DocumentHeader createNewHeader(final DocumentTypes type, final String title)
            throws WrongNumberOfLastSignatureException;
}
