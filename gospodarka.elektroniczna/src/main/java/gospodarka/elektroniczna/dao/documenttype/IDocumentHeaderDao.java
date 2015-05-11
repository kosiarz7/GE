package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.dao.ICommonDao;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;

/**
 * DAO dla nagłówków dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDocumentHeaderDao extends ICommonDao<DocumentHeaderDto> {
    /**
     * Wczytuje nagłówek dokumentu po id.
     * 
     * @param id id nagłówka dokumentu.
     * @return DTO żądanego nagłówka.
     */
    DocumentHeaderDto loadById(int id);
}