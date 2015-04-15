package gospodarka.elektroniczna.services.document;

import java.io.Serializable;

import org.slf4j.Logger;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

/**
 * Serwis dla dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentService implements IDocumentService, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = -5108341832771502464L;
    /**
     * Logger.
     */
    @InjectLogger
    private static final Logger LOGGER = null;
    /**
     * Serwis obsługujący nagłówki dokumentów.
     */
    private IDocumentHeaderService documentHeaderService;

    
    /**
     * {@inheritDoc}
     * @throws WrongNumberOfLastSignatureException 
     */
    @Override
    public <T> Document<T> createDocument(final DocumentTypes type, final String title)
            throws WrongNumberOfLastSignatureException {
        LOGGER.debug("createDocument|Invoke. Type: {}, title: {}", type, title);
        return new Document<T>(documentHeaderService.createNewHeader(type, title),
                DocumentContentFactory.createDocumentContent(type));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void sendDocument(final Document<T> document, final Departments source, final Departments target) {
        throw new IllegalArgumentException("Not implemented yet.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void archiveDocument(final Document<T> document, final Departments department) {
        throw new IllegalArgumentException("Not implemented yet.");
    }

    /**
     * Ustawia serwis obsługujący nagłówki dokumentów.
     * 
     * @param documentHeaderService serwis obsługujący nagłówki dokumentów.
     */
    public void setDocumentHeaderService(final IDocumentHeaderService documentHeaderService) {
        this.documentHeaderService = documentHeaderService;
    }
}
