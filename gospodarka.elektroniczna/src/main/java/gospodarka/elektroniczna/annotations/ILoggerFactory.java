package gospodarka.elektroniczna.annotations;

import org.slf4j.Logger;

/**
 * Wytwórca loggerów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface ILoggerFactory {
    /**
     * Zwraca logger dla przesłanej klasy.
     * 
     * @param clazz klasa.
     * @return logger.
     */
    Logger getLogger(final Class<?> clazz);
}