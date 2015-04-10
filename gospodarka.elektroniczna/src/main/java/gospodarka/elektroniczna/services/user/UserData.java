package gospodarka.elektroniczna.services.user;

import gospodarka.elektroniczna.dto.RoleDto;
import gospodarka.elektroniczna.dto.UserDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Informacje na tema zalogowanego użytkownika.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class UserData implements UserDetails {
    /**
     * UID.
     */
    private static final long serialVersionUID = -4507510932062523271L;
    /**
     * Dane użytkownika.
     */
    private UserDto userDto;
    /**
     * Lista uprawnień użytkownika.
     */
    private List<GrantedAuthority> authorities;
    
    
    /**
     * Konstruktor.
     * 
     * @param userDto dane użytkownika.
     */
    public UserData(final UserDto userDto) {
        this.userDto = userDto;
        authorities = new ArrayList<>();
        for (RoleDto r : userDto.getRoles()) {
            authorities.add(new Authority(r.getName()));
        }
    }
    
    /**
     * Zwraca imię użytkownika.
     * 
     * @return imię użytkownika.
     */
    public String getName() {
        return userDto.getName();
    }

    /**
     * Zwraca nazwisko użytkownika.
     * 
     * @return nazwisko użytkownika.
     */
    public String getSurname() {
        return userDto.getSurname();
    }
    
    /**
     * Zwraca imię i nazwisko użytkownika.
     * 
     * @return imię i nazwisko użytkownika.
     */
    public String getNameAndSurname() {
        return userDto.getName() + " " + userDto.getSurname();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return userDto.getLogin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
