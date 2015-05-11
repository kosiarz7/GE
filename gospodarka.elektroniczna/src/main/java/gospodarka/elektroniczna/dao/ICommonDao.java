package gospodarka.elektroniczna.dao;

import java.util.Optional;

/**
 * Wspólne metody DAO.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface ICommonDao<T> {
    /**
     * Zapisuję encję.
     * 
     * @param entity encja.
     */
    void save(final T entity);
    /**
     * Uaktualnia encję.
     * 
     * @param entity encja.
     */
    void update(final T entity);
    /**
     * Kasuję encję z bazy.
     * 
     * @param entity encja.
     */
    void delete(final T entity);
    /**
     * Wczytuję encję po ID.
     * 
     * @param id id encji.
     * @param clazz typ zwracanego obiektu.
     * @return obiekt encji.
     */
    Optional<T> loadById(int id, Class<T> clazz);
}
