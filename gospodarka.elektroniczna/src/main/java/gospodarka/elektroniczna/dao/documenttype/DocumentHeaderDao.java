package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;

import java.io.Serializable;

import org.slf4j.Logger;

/**
 * DAO dla nagłówków dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentHeaderDao extends CommonDao<DocumentHeaderDto> implements IDocumentHeaderDao, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 4221781990859144002L;
    /**
     * Logger.
     */
    @InjectLogger
    private static final Logger LOGGER = null;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(DocumentHeaderDto entity) {
        LOGGER.debug("save|Próba zapisu nagłówka: {}", entity);
        super.save(entity);
    }
}