package gospodarka.elektroniczna.services.user;

import gospodarka.elektroniczna.dao.user.IUserDao;
import gospodarka.elektroniczna.dto.UserDto;

import java.io.Serializable;

/**
 * Usługi związane z użytkownikiem.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class UserService implements IUserService, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = -968298866296529495L;
    /**
     * DAO dla użytkownika.
     */
    private IUserDao userDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserData loadUserByLogin(final String username) throws NoSuchUserException {
        UserDto userDto = userDao.loadUserByUserName(username);
        if (!userDto.isLoaded()) {
            throw new NoSuchUserException("Brak użytkownika o nazwie: " + username);
        }
        return new UserData(userDto);
    }

    /**
     * Ustawia DAO użytkownika.
     * 
     * @param userDao dao użytkownika.
     */
    public void setUserDao(final IUserDao userDao) {
        this.userDao = userDao;
    }
}