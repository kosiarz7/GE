package gospodarka.elektroniczna.common.beans;

import gospodarka.elektroniczna.security.SpringSecurityContextUtil;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Bean wspomagający pracę ze spring security.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class SpringSecurityContextUtilBean implements Serializable, SpringSecurityContextUtil {

    /**
     * UID.
     */
    private static final long serialVersionUID = -1707242397470945906L;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getLoggedOnUserRolesAsStringList() {
        return getLoggedOnUserRoles().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getLoggedOnUserRoles() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLoggedOnUserNameAndSurname() {
        String nameAndSurename = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserData) {
            nameAndSurename = ((UserData) principal).getNameAndSurname();
            
        }
        
        return nameAndSurename;
    }
    
    @Override
    public boolean isUserLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return !(null == auth || auth instanceof AnonymousAuthenticationToken);
    }
}