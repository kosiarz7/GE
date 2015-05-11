package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.content.IArchivalContentDao;
import gospodarka.elektroniczna.dao.content.ICurrentContentDao;
import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.department.IDepartmentDao;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dao.documenttype.IDocumentHeaderDao;
import gospodarka.elektroniczna.documents.TestDocument;
import gospodarka.elektroniczna.dto.ArchivalDocumentDto;
import gospodarka.elektroniczna.dto.CurrentDocumentDto;
import gospodarka.elektroniczna.dto.DepartmentDto;
import gospodarka.elektroniczna.dto.DocumentHeaderDto;
import gospodarka.elektroniczna.dto.LightCurrentDocumentDto;
import gospodarka.elektroniczna.services.document.content.DocumentContentFactory;
import gospodarka.elektroniczna.services.document.content.IDocumentContentSerialization;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;

/**
 * Serwis dla dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
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
     * Mapa przechowujący pary (TypDokumentu, obiekt typu Class dla zawartości dokumentu).
     */
    private static final Map<DocumentTypes, Class<?>> map;
    /**
     * Statyczna inicjalizacja.
     */
    static {
        map = new HashMap<>();
        map.put(DocumentTypes.TEST, TestDocument.class);
        // TODO przy kolejnych dokumentach trzeba dołożyć.
    }
    
    /**
     * Serwis obsługujący nagłówki dokumentów.
     */
    private IDocumentHeaderService documentHeaderService;
    /**
     * Serwis serializiujący zawartość dokumentów.
     */
    private IDocumentContentSerialization documentContentSerialization;
    /**
     * DAO dla oddziałów.
     */
    private IDepartmentDao departmentDao;
    /**
     * DAO dla nagłówków dokumentów.
     */
    private IDocumentHeaderDao documentHeaderDao;
    /**
     * DAO dla bieżacej wersji dokumentu.
     */
    private ICurrentContentDao currentDocumentDao;
    /**
     * DAO dla archiwalnej wwersji dokumentu.
     */
    private IArchivalContentDao archivalDocumentDao;

    
    /**
     * {@inheritDoc}
     * 
     * @throws WrongNumberOfLastSignatureException
     */
    @Override
    public <T> Document<T> createDocument(final DocumentTypes type, final String title)
            throws WrongNumberOfLastSignatureException {
        LOGGER.debug("createDocument|Invoke. Type: {}, title: {}", type, title);
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) map.get(type);
        try {
            return new Document<T>(documentHeaderService.createNewHeader(type, title),
                    DocumentContentFactory.newDocumentContent(clazz));
        }
        catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("createDocument|Wystąpił błąd podczas inicjalizacji zawartości dokumentu.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void sendDocument(final Document<T> document, final Departments source, final Departments target) {
        LOGGER.debug("sendDocument|Przeslanie dokumentu: {} z: {} do: {}", document, source, target);
        DocumentHeader header = document.getHeader();
        DepartmentDto sourceDto = departmentDao.getDepartment(source);
        DepartmentDto targetDto = departmentDao.getDepartment(target);
        if (Departments.BEGIN.equals(source)) {
            Date currDate = new Date();
            CurrentDocumentDto currentDto = new CurrentDocumentDto();
            currentDto
                    .setContent(documentContentSerialization.convertToStream(header.getType(), document.getContent()));
            currentDto.setDateOfRecipt(currDate);
            currentDto.setHeader(documentHeaderDao.loadById(header.getHeaderId(), DocumentHeaderDto.class).get());
            currentDto.setSourceDepartment(sourceDto);
            currentDto.setTargetDepartment(targetDto);
            ArchivalDocumentDto archivalDto = new ArchivalDocumentDto(currentDto);
            archivalDto.setDateOfDispatch(currDate);
            archivalDocumentDao.save(archivalDto);
            currentDocumentDao.save(currentDto);
        }
        else {
            
        }
        throw new IllegalArgumentException("Not implemented yet.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentStub> loadCurrentDocumentsInDepartment(final Departments department, final DocumentTypes type) {
        Optional<List<LightCurrentDocumentDto>> documents = currentDocumentDao.loadDocumentsInDeparment(department,
                type);
        return documents.isPresent() ? documents.get().stream().map(current -> convert(current))
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentStub> loadCurrentDocumentsInDepartment(final Departments department) {
        Optional<List<LightCurrentDocumentDto>> documents = currentDocumentDao.loadDocumentsInDeparment(department);
        return documents.isPresent() ? documents.get().stream().map(current -> convert(current))
                .collect(Collectors.toList()) : new ArrayList<>();
    }
    
    /**
     * Konwertuje obieket DTO na DocumentStub.
     * 
     * @param documentDto DTO.
     * @return DocumentStub.
     */
    private DocumentStub convert(LightCurrentDocumentDto documentDto) {
        DocumentStub stub = new DocumentStub();
        stub.setContentId(documentDto.getId());
        stub.setDateOfRecipte(documentDto.getDateOfRecipt());
        stub.setFrom(Departments.valueOf(documentDto.getSourceDepartment().getName()));
        stub.setHeaderId(documentDto.getHeader().getId());
        stub.setSignature(documentDto.getHeader().getSignature());
        stub.setTitle(documentDto.getHeader().getTitle());
        stub.setTo(Departments.valueOf(documentDto.getTargetDepartment().getName()));
        stub.setType(DocumentTypes.valueOf(documentDto.getHeader().getDocumentType().getName()));
        return stub;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Document<T> loadCurrentDocument(DocumentStub stub) {
        Optional<CurrentDocumentDto> currentDocument = currentDocumentDao.loadById(stub.getContentId(),
                CurrentDocumentDto.class);
        if (currentDocument.isPresent()) {
            DocumentHeaderDto headerDto = currentDocument.get().getHeader();
            DocumentTypes documentType = DocumentTypes.valueOf(headerDto.getDocumentType().getName());
            T content = documentContentSerialization.convertToDocumentContent(documentType, currentDocument.get()
                    .getContent());
            return new Document<T>(createDocumentHeader(headerDto, currentDocument.get()), content, currentDocument
                    .get().getId());
        }
        else {
            LOGGER.warn("loadCurrentDocument|Brak bieżącego dokumentu dla: {}", stub);
            return new Document<T>();
        }
    }
    
    /**
     * Tworzy nagłówek dokumentu.
     * 
     * @param headerDto DTO nagłówka.
     * @param currentDocumentDto DTO bieżącego dokumentu.
     * @return nagłówek dokumentu.
     */
    private DocumentHeader createDocumentHeader(DocumentHeaderDto headerDto, CurrentDocumentDto currentDocumentDto) {
        DocumentHeader header = new DocumentHeader();
        header.fill(headerDto);
        header.setFrom(Departments.valueOf(currentDocumentDto.getSourceDepartment().getName()));
        header.setReceiptDate(currentDocumentDto.getDateOfRecipt());
        return header;
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

    /**
     * Serwis serializujący zawartość dokumentów.
     * 
     * @param documentContentSerialization serwis serializujący zawartość dokumentów.
     */
    public void setDocumentContentSerialization(IDocumentContentSerialization documentContentSerialization) {
        this.documentContentSerialization = documentContentSerialization;
    }

    public void setDepartmentDao(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void setDocumentHeaderDao(IDocumentHeaderDao documentHeaderDao) {
        this.documentHeaderDao = documentHeaderDao;
    }

    public void setCurrentDocumentDao(ICurrentContentDao currentDocumentDao) {
        this.currentDocumentDao = currentDocumentDao;
    }

    public void setArchivalDocumentDao(IArchivalContentDao archivalDocumentDao) {
        this.archivalDocumentDao = archivalDocumentDao;
    }
}