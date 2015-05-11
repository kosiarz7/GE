package gospodarka.elektroniczna.dao.content;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.CurrentDocumentDto;
import gospodarka.elektroniczna.dto.LightCurrentDocumentDto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

/**
 * DAO dla bieżących wersji dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class CurrentContentDao extends CommonDao<CurrentDocumentDto> implements Serializable, ICurrentContentDao {

    /**
     * UID.
     */
    private static final long serialVersionUID = 300166734933656889L;
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
    public Optional<List<LightCurrentDocumentDto>> loadDocumentsInDeparment(Departments department) {
        LOGGER.debug("loadDocumentsInDeparment|Pobranie dokumentów z oddziału: {}", department.toString());
        Session session = openSession();
        Transaction tx = null;
        List<LightCurrentDocumentDto> documents = null;
        
        try {
            tx = session.beginTransaction();
            documents = session
                    .createQuery("from LightCurrentDocumentDto where targetDepartment.name = :targetDepartmentName")
                    .setString("targetDepartmentName", department.toString()).list();
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
        
        Optional<List<LightCurrentDocumentDto>> result = Optional.empty();
        if (documents.isEmpty()) {
            LOGGER.debug("loadDocumentsInDeparment|Brak bieżących dokumentów w oddziale: {}", department.toString());
        }
        else {
            result = Optional.of(documents);
            LOGGER.debug("loadDocumentsInDeparment|Załadowano {} bieżących dokumentów dla oddziału: {}",
                    documents.size(), department.toString());
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Optional<List<LightCurrentDocumentDto>> loadDocumentsInDeparment(Departments department, DocumentTypes type) {
        LOGGER.debug("loadDocumentsInDeparment|Pobranie dokumentów typu: {} z oddziału: {}", type.toString(),
                department.toString());
        Session session = openSession();
        Transaction tx = null;
        List<LightCurrentDocumentDto> documents = null;
        
        try {
            tx = session.beginTransaction();
            documents = session
                    .createQuery("from LightCurrentDocumentDto where targetDepartment.name = :targetDepartmentName and"
                            + " header.documentType.name = :documentTypeName")
                            .setString("targetDepartmentName", department.toString())
                            .setString("documentTypeName", type.toString())
                            .list();
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
        
        Optional<List<LightCurrentDocumentDto>> result = Optional.empty();
        if (documents.isEmpty()) {
            LOGGER.debug("loadDocumentsInDeparment|Brak bieżących dokumentów typu: {} w oddziale: {}", 
                    department.toString());
        }
        else {
            result = Optional.of(documents);
            LOGGER.debug("loadDocumentsInDeparment|Załadowano {} bieżących dokumentów typu: {} dla oddziału: {}",
                    documents.size(), type.toString(), department.toString());
        }
        return result;
    }
}