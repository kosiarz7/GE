package gospodarka.elektroniczna.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * Metody wspomagającę pracę z Spring Security.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface SpringSecurityContextUtil {
    /**
     * Zwraca listę (w postaci napisów) uprawnień zalogowanego użytkownika.
     * 
     * @return lista uprawnień zalogowanego użytkownika.
     */
    public List<String> getLoggedOnUserRolesAsStringList();
    
    /**
     * Zwraca kolekcję uprawnień zalogowanego użytkownika.
     * 
     * @return kolekcja uprawnień zalogowanego użytkownika.
     */
    public Collection<? extends GrantedAuthority> getLoggedOnUserRoles();
}
