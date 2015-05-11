package gospodarka.elektroniczna.dao.documenttype;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.DocumentTypeDto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

/**
 * Implementacja DAO dla typów dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentTypeDao extends CommonDao<DocumentTypeDto> implements IDocumentTypeDao, Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = 8020814556436563412L;
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
    public DocumentTypeDto getDocumentType(final DocumentTypes documentType) {
        LOGGER.debug("getDocumentType|Próba pobrania DTO dla typu dokumentu: {}", documentType);
        Session session = openSession();
        Transaction tx = null;
        List<DocumentTypeDto> documentTypes = null;
        
        try {
            tx = session.beginTransaction();
            documentTypes = session.createQuery("from DocumentTypeDto where name = :name")
                    .setString("name", documentType.toString()).list();
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
        
        DocumentTypeDto departmentDto = null;
        if (documentTypes.isEmpty()) {
            LOGGER.error("getDocumentTypet|Brak rekordu w bazie dla typu dokumentu o nazwie: {}", documentType);
            throw new IllegalArgumentException("Brak rekordu w bazie dla oddziału o nazwie: " + documentType);
        }
        else {
            departmentDto = documentTypes.get(0);
            LOGGER.debug("getDocumentType|Został pobrany obiekt: {} dla typu dokumentu: {}", departmentDto, documentType);
        }
        return departmentDto;
    }
}