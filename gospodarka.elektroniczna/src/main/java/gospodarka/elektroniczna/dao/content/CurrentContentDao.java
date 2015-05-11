package gospodarka.elektroniczna.dao.content;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.CurrentDocumentDto;
import gospodarka.elektroniczna.dto.LightCurrentDocumentDto;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.util.StringUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
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
    public Optional<List<LightCurrentDocumentDto>> loadDocuments(final SearchCriteria searchCriteria) {
        LOGGER.debug("loadDocuments|Kryteria wyszukiwania: {}", searchCriteria);
        Session session = openSession();
        Transaction tx = null;
        List<LightCurrentDocumentDto> documents = null;
        
        try {
            tx = session.beginTransaction();
            documents = createQuery(searchCriteria, session).list();
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
            LOGGER.debug("loadDocuments|Brak dokumentów spełniających kryteria: {}", searchCriteria);
        }
        else {
            result = Optional.of(documents);
            LOGGER.debug("loadDocuments|Załadowano {} dokumentów spełniających kryteria.", searchCriteria);
        }
        return result;
    }
    
    /**
     * Buduje zapytanie.
     * 
     * @param searchCriteria kryteria wyszukiwania.
     * @return zapytanie.
     */
    private Query createQuery(final SearchCriteria searchCriteria, final Session session) {
        String query = createStringQuery(searchCriteria);
        return fillParamters(session.createQuery(query), searchCriteria);
    }
    
    /**
     * Tworzy zapytanie.
     * 
     * @param searchCriteria kryteria wyszukiwania.
     * @return zapytanie.
     */
    private String createStringQuery(final SearchCriteria searchCriteria) {
        StringBuilder builder = new StringBuilder();
        String and = " AND ";
        
        builder.append("from LightCurrentDocumentDto where ");
        if (searchCriteria.getFrom() != null) {
            builder.append("dateOfRecipt >= :from").append(and);
        }
        if (searchCriteria.getTo() != null) {
            builder.append("dateOfRecipt <= :to").append(and);
        }
        if (searchCriteria.getDepartment() != null) {
            builder.append("targetDepartment.name = :departmentName").append(and);
        }
        if (searchCriteria.getType() != null) {
            builder.append("header.documentType.name = :docTypeName").append(and);
        }
        if (!StringUtil.isEmpty(searchCriteria.getSignature())) {
            builder.append("header.signature = :signature").append(and);
        }
        if (!StringUtil.isEmpty(searchCriteria.getTitle())) {
            builder.append("header.title = :title");
        }
        
        String stringQuery = builder.toString();
        if (stringQuery.endsWith(and)) {
            stringQuery = stringQuery.substring(0, stringQuery.length() - 5);
        }
        
        LOGGER.debug("createStringQuery|Query: {}", stringQuery);
        return stringQuery;
    }
    
    /**
     * Wypełnia zapytanie parametrami.
     * 
     * @param query zapytanie.
     * @param searchCriteria parametry.
     * @return zapytanie z wypełnionymi parametrami.
     */
    private Query fillParamters(Query query, SearchCriteria searchCriteria) {
        if (searchCriteria.getFrom() != null) {
            query.setDate("from", searchCriteria.getFrom());
        }
        if (searchCriteria.getTo() != null) {
            query.setDate("to", searchCriteria.getTo());
        }
        if (searchCriteria.getDepartment() != null) {
            query.setString("departmentName", searchCriteria.getDepartment().toString());
        }
        if (searchCriteria.getType() != null) {
            query.setString("docTypeName", searchCriteria.getType().toString());
        }
        if (!StringUtil.isEmpty(searchCriteria.getSignature())) {
            query.setString("signature", searchCriteria.getSignature());
        }
        if (!StringUtil.isEmpty(searchCriteria.getTitle())) {
            query.setString("title", searchCriteria.getTitle());
        }
        
        return query;
    }
}