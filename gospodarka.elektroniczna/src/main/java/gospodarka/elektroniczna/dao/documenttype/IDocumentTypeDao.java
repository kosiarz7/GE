package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.dto.DocumentTypeDto;

/**
 * DAO dla typów dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentTypeDao {
    /**
     * Zwraca DTO dla żądanego typu dokumentu.
     * 
     * @param documentType żądany typ dokumentu.
     * @return DTO typu dokumentu.
     */
    DocumentTypeDto getDocumentType(final DocumentTypes documentType);
}