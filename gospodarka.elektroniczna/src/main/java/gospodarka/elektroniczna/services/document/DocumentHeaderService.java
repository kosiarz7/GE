package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dao.documenttype.IDocumentHeaderDao;
import gospodarka.elektroniczna.dao.documenttype.IDocumentTypeDao;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;
import gospodarka.elektroniczna.services.signature.ISignatureService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;

/**
 * Serwis dla nagłówków dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DocumentHeaderService implements IDocumentHeaderService, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = -8157254860340687291L;
    /**
     * Logger.
     */
    @InjectLogger
    private static final Logger LOGGER = null;
    /**
     * DAO dla nagłówków dokumentów.
     */
    private IDocumentHeaderDao documentHeaderDao;
    /**
     * Serwis dla sygnatur.
     */
    private ISignatureService signatureService;
    /**
     * DAO dla nagłówków dokumentów.
     */
    private IDocumentTypeDao documentTypeDao;

    /**
     * {@inheritDoc}
     * @throws WrongNumberOfLastSignatureException 
     */
    @Override
    public DocumentHeader createNewHeader(final DocumentTypes type, final String title)
            throws WrongNumberOfLastSignatureException {
        DocumentHeaderDto headerDto = createAndSaveNewHeaderDto(type, title);
        DocumentHeader header = new DocumentHeader();
        header.fill(headerDto);
        header.setFrom(Departments.BEGIN);
        header.setReceiptDate(new Date());
        LOGGER.debug("createNewHeader|Został stworzony nowy nagłówek dokumentu: {}", header);
        return header;
    }
    
    /**
     * Tworzy i zapisuje nowy nagłówek dokumentu.
     * 
     * @param type typ dokumentu.
     * @param title tytuł dokumentu.
     * @return DTO nagłówka dokumentu.
     * @throws WrongNumberOfLastSignatureException rzucany gdy wystąpi błąd podczas tworzenia nowej sygnatury.
     */
    private DocumentHeaderDto createAndSaveNewHeaderDto(final DocumentTypes type, final String title) 
            throws WrongNumberOfLastSignatureException {
        DocumentHeaderDto headerDto = new DocumentHeaderDto();
        headerDto.setDocumentType(documentTypeDao.getDocumentType(type));
        headerDto.setSignature(signatureService.getNewSignature());
        headerDto.setTitle(title);
        documentHeaderDao.save(headerDto);
        return headerDto;
    }

    /**
     * Ustawia DAO dla nagłówków dokumentów.
     * 
     * @param documentHeaderDao DAO dla nagłówków dokumentów.
     */
    public void setDocumentHeaderDao(final IDocumentHeaderDao documentHeaderDao) {
        this.documentHeaderDao = documentHeaderDao;
    }

    /**
     * Ustawia serwis dla sygnatur.
     * 
     * @param signatureService serwis dla sygnatur.
     */
    public void setSignatureService(final ISignatureService signatureService) {
        this.signatureService = signatureService;
    }

    /**
     * Ustawia DAO dla nagłówków dokumentów.
     * 
     * @param documentTypeDao DAO dla nagłówków dokumentów.
     */
    public void setDocumentTypeDao(final IDocumentTypeDao documentTypeDao) {
        this.documentTypeDao = documentTypeDao;
    }
}