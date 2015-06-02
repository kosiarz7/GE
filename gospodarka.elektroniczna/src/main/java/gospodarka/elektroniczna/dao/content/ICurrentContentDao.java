package gospodarka.elektroniczna.dao.content;

import gospodarka.elektroniczna.dao.ICommonDao;
import gospodarka.elektroniczna.dto.CurrentDocumentDto;
import gospodarka.elektroniczna.dto.LightCurrentDocumentDto;
import gospodarka.elektroniczna.services.document.SearchCriteria;

import java.util.List;
import java.util.Optional;

/**
 * DAO dla bieżących wersji dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface ICurrentContentDao extends ICommonDao<CurrentDocumentDto> {
    /**
     * Wczytuje bieżące dokumenty spełniające przesłane kryteria.
     * 
     * @param searchCriteria kryteria wyszukiwania.
     * @return dokumenty spełniające kryteria.
     */
    Optional<List<LightCurrentDocumentDto>> loadDocuments(final SearchCriteria searchCriteria);
}
