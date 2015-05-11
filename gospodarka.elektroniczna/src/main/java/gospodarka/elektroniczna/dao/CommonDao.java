package gospodarka.elektroniczna.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Klasa bazowa dla DAO.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class CommonDao<T> implements Serializable, ICommonDao<T> {
    /**
     * UID.
     */
    private static final long serialVersionUID = -7088860771369912098L;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
    
    /**
     * Fabryka sesji Hibernate.
     */
    protected SessionFactory sessionFactory;
    

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final T entity) {
        LOGGER.debug("save|Próba zapisu encji: {}");
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            LOGGER.error("save|Wystąpił błąd podczas zapisu encji: {}", entity, e);
            throw e;
        }
        finally {
            session.close();
        }
        
        LOGGER.debug("save|Zapis encji {} zakończył się sukcesem.", entity);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T entity) {
        LOGGER.debug("update|Próba aktualizacji encji: {}");
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            LOGGER.error("update|Wystąpił błąd podczas aktualizacji encji: {}", entity, e);
            throw e;
        }
        finally {
            session.close();
        }
        
        LOGGER.debug("update|Aktualizacja encji {} zakończyła się sukcesem.", entity);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T entity) {
        LOGGER.debug("delete|Próba usunięcia encji: {}");
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            LOGGER.error("delete|Wystąpił błąd podczas usuwania encji: {}", entity, e);
            throw e;
        }
        finally {
            session.close();
        }
        
        LOGGER.debug("delete|Encja została usunięta.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Optional<T> loadById(int id, Class<T> clazz) {
        LOGGER.debug("loadById|Próba załadowania encji {} o id: {}", clazz.getSimpleName(), id);
        Session session = openSession();
        Transaction tx = null;
        List<T> documents = null;
        
        try {
            tx = session.beginTransaction();
            documents = session.createQuery("from " + clazz.getSimpleName() + " where id = :id").setInteger("id", id).list();
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
        
        Optional<T> result = Optional.empty();
        if (documents.isEmpty()) {
            LOGGER.debug("loadById|Brak encji {} o id: {}", clazz.getSimpleName(), id);
        }
        else {
            result = Optional.of(documents.get(0));
            LOGGER.debug("loadById|Załadowano encję {} o id: {}", clazz.getSimpleName(), id);
        }
        return result;
    }
    
    /**
     * Ustawia fabrykę sesji.
     * 
     * @param sessionFactory fabryka sesji.
     */
    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Otwiera nową sesje BD.
     * 
     * @return nowa sesja BD.
     */
    protected Session openSession() {
        return sessionFactory.openSession();
    }
}
