package gospodarka.elektroniczna.dao.user;

import gospodarka.elektroniczna.dto.UserDto;

/**
 * Operacje na bazie związane z użytkownikiem.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IUserDao {
    /**
     * Wczytuje dane użytkownika na podstawie jego loginu.
     * 
     * @param login login użytkownika.
     * @return dane użytkownika.
     */
    UserDto loadUserByUserName(final String login);
}
