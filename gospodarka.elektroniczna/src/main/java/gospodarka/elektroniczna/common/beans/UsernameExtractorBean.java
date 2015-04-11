package gospodarka.elektroniczna.common.beans;

import gospodarka.elektroniczna.security.CustomBadCredentialsException;

import java.io.Serializable;

import org.springframework.security.core.AuthenticationException;

/**
 * Bean, który potrafi "wyłuskać" login użytkownika, który wpisał złe hasło.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class UsernameExtractorBean implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 8447117707097268099L;

    /**
     * Pobiera wcześniej wpisaną nazwę użtkownika.
     * 
     * @param exception wyjątek pojawiający się w przypadku błędnego wpisania hasła.
     * @return login użytkownika, który wpisał złe hasło.
     */
    public String extractUsername(final AuthenticationException exception) {
        String username = "";

        if (exception instanceof CustomBadCredentialsException) {
            username = ((CustomBadCredentialsException) exception).getLogin();
        }

        return username;
    }

}
