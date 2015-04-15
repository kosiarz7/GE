package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.dto.DocumentHeaderDto;

/**
 * DAO dla nagłówków dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentHeaderDao {
    /**
     * Zapisuje nagłówek dokumentu.
     * 
     * @param header nagłówek dokumentu.
     */
    void save(final DocumentHeaderDto header);
}