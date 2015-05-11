package gospodarka.elektroniczna.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
     * Fabryka sesji Hibernate.
     */
    protected SessionFactory sessionFactory;
    

    /**
     * Zapisuję encję.
     * 
     * @param entity encja.
     */
    public void save(final T entity) {
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
            throw e;
        }
        finally {
            session.close();
        }
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
