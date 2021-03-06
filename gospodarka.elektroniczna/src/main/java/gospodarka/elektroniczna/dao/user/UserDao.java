package gospodarka.elektroniczna.dao.user;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.UserDto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

/**
 * DAO dla użytkownika.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class UserDao extends CommonDao<Object> implements IUserDao, Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = -6299204458673721070L;
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
    public UserDto loadUserByUserName(final String login) {
        LOGGER.debug("loadUserByUserName|Próba pobrania użytkownika o loginie: {}", login);
        UserDto userDto = null;
        
        Session session = openSession();
        Transaction tx = null;
        List<UserDto> users = null;
        
        try {
            tx = session.beginTransaction();
            users = session.createQuery("from UserDto where login = :login").setString("login", login).list();
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
        
        if (users.isEmpty()) {
            userDto = new UserDto();
            LOGGER.debug("loadUserByUserName|Brak użytkownika o nazwie: {}", login);
        }
        else {
            userDto = users.get(0);
            LOGGER.debug("loadUserByUserName|Załadowane dane użytkownika: {}", login);
        }
        
        return userDto;
    }

}
