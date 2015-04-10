package gospodarka.elektroniczna.annotations;

import org.slf4j.Logger;

/**
 * Producent loggerów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class LoggerFactory implements ILoggerFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Logger getLogger(final Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }
}