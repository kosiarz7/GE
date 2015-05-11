package gospodarka.elektroniczna.dao.content;

import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.ArchivalDocumentDto;

import java.io.Serializable;

/**
 * DAO dla archiwalnych wersji dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class ArchivalContentDao extends CommonDao<ArchivalDocumentDto> implements IArchivalContentDao, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 1L;

}
