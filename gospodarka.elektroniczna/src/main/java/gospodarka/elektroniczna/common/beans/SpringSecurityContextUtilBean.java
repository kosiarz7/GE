package gospodarka.elektroniczna.common.beans;

import gospodarka.elektroniczna.dao.department.Departments;
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
 *         Copyright © 2015 Adam Kopaczewski
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

    @Override
    public boolean hasRole(String roleToCompare) {
        return getLoggedOnUserRoles().stream().filter(a -> a.getAuthority().equalsIgnoreCase(roleToCompare)).count() > 0;
    }

    /**
     * Przyjmuje ze rola to tez departament - pozniej sie poprawi
     * 
     * @return
     */
    public Departments getUserDepartment() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserData) {
            UserData userData = (UserData) principal;
            Collection<? extends GrantedAuthority> authorities = userData.getAuthorities();
            String roleName = authorities.iterator().next().getAuthority().toUpperCase();
            // (1, "HR"), (2, "MANUFACTURE"), (3, "FINANCE"), (4, "SERVIS"), (5,
            // "STOREHOUSE"), (6, "CUSTOMER_SERVICE"), (7, "ROOT");
            switch (roleName) {
            case "ROLE_HR":
                return Departments.HUMAN_RESOURCES;
            case "ROLE_MANUFACTURE":
                return Departments.MANUFACTURE;
            case "ROLE_FINANCE":
                return Departments.FINANCE;
            case "ROLE_SERVIS":
                return Departments.SERVIS;
            case "ROLE_STOREHOUSE":
                return Departments.STOREHOUSE;
            case "ROLE_CUSTOMER_SERVICE":
                return Departments.CUSTOMER_SERVICE;
            case "ROLE_ROOT":
                return Departments.BEGIN;
            default:
                break;
            }
        }
        return null;
    }

    public UserData getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserData) {
            return (UserData) principal;
        }
        return null;

    }
}