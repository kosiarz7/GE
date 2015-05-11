package gospodarka.elektroniczna.dao;

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
    public void save(final T entity);
}
