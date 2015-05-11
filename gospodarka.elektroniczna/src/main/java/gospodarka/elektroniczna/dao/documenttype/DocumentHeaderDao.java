package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
    @SuppressWarnings("unchecked")
    public DocumentHeaderDto loadById(int id) {
        LOGGER.debug("loadById|Próba wczytania nagłówka o id: {}", id);
        
        List<DocumentHeaderDto> headers = null;
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            headers = session.createQuery("from DocumentHeaderDto where id = :id").setInteger("id", id).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
        
        DocumentHeaderDto documentHeaderDto = null;
        if (headers.isEmpty()) {
            LOGGER.debug("loadById|Brak nagłówka o id: {}", id);
        }
        else {
            documentHeaderDto = headers.get(0);
            LOGGER.debug("loadById|Wczytano nogłówek: {}", headers);
        }
        
        return documentHeaderDto;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(DocumentHeaderDto entity) {
        LOGGER.debug("save|Próba zapisu nagłówka: {}", entity);
        super.save(entity);
    }
}