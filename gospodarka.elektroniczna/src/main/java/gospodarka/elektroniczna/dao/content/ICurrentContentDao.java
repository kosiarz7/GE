package gospodarka.elektroniczna.dao.content;

import gospodarka.elektroniczna.dao.ICommonDao;
import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.CurrentDocumentDto;
import gospodarka.elektroniczna.dto.LightCurrentDocumentDto;

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
     * Wczytuje bieżące dokumentu znajdujące się w danym oddziale.
     * 
     * @param department oddział.
     * @return lista dokumentów.
     */
    Optional<List<LightCurrentDocumentDto>> loadDocumentsInDeparment(final Departments department);
    /**
     * Wczytuje bieżące dokumentu żądanego znajdujące się w danym oddziale.
     * 
     * @param department oddział.
     * @param type typ dokumentu.
     * @return lista dokumentów.
     */
    Optional<List<LightCurrentDocumentDto>> loadDocumentsInDeparment(final Departments department,
            final DocumentTypes type);
    /**
     * Wczytuje bieżący dokument po jego id.
     * 
     * @param id id dokumentu.
     * @return bieżący dokuement.
     */
    Optional<CurrentDocumentDto> loadDocumentById(int id);
}
