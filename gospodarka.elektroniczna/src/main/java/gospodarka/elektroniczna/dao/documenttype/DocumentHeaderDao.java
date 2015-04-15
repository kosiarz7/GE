package gospodarka.elektroniczna.dao.documenttype;

import java.io.Serializable;

import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;

/**
 * DAO dla nagłówków dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentHeaderDao extends CommonDao implements IDocumentHeaderDao, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 4221781990859144002L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final DocumentHeaderDto header) {
        super.save(header);
    }
}