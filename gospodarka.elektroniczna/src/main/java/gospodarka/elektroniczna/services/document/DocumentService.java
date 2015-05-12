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
import gospodarka.elektroniczna.util.StringUtil;

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
     */
    @Override
    public <T> Document<T> createDocument(final DocumentTypes type, final String title, final Departments department)
            throws WrongNumberOfLastSignatureException {
        LOGGER.debug("createDocument|Invoke. Type: {}, title: {}", type, title);
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) map.get(type);
        try {
            Document<T> document = new Document<T>(documentHeaderService.createNewHeader(type, title),
                    DocumentContentFactory.newDocumentContent(clazz));
            saveNewDocument(document, department);
            return document;
        }
        catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("createDocument|Wystąpił błąd podczas inicjalizacji zawartości dokumentu.", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Zapisuje nowy dokument.
     * 
     * @param document nowy dokument.
     * @param department oddział, który towrzy nowy dokument.
     */
    private <T> void saveNewDocument(final Document<T> document, final Departments department) {
        LOGGER.debug("saveNewDocument|Zapis nowego dokumentu. Dokument: {}, oddział tworzący dokument: {}", document,
                department);
        DocumentHeader header = document.getHeader();
        Date currDate = new Date();
        CurrentDocumentDto currentDto = new CurrentDocumentDto();
        currentDto.setContent(documentContentSerialization.convertToStream(header.getType(), document.getContent()));
        currentDto.setDateOfRecipt(currDate);
        currentDto.setHeader(documentHeaderDao.loadById(header.getHeaderId(), DocumentHeaderDto.class).get());
        currentDto.setSourceDepartment(departmentDao.getDepartment(Departments.BEGIN));
        currentDto.setTargetDepartment(departmentDao.getDepartment(department));
        ArchivalDocumentDto archivalDto = new ArchivalDocumentDto(currentDto);
        archivalDto.setDateOfDispatch(currDate);
        archivalDocumentDao.save(archivalDto);
        currentDocumentDao.save(currentDto);
        document.setCurrentContentId(currentDto.getId());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void sendDocument(final Document<T> document, final Departments source, final Departments target) {
        LOGGER.debug("sendDocument|Przeslanie dokumentu: {} z: {} do: {}", document, source, target);
        if (Departments.BEGIN.equals(source) || Departments.BEGIN.equals(target)) {
            LOGGER.warn(
                    "sendDocument|Niepoprawne użycie metody. Zaden z działów nie powinien być fikcyjnym działem BEGIN. Parametry: dokuemt: {}, z: {}, do: {}",
                    document, source, target);
            throw new IllegalArgumentException("Żaden z działów nie może być fikcyjnym działem BEGIN. Source department: "
                    + source + " target department: " + target);
        }
        else if (Departments.END.equals(target)) {
            LOGGER.warn("sendDocument|Niepoprawne użycie metody. Docelowy dział nie może być typu END. "
                    + "Parametry: dokuemt: {}, z: {} do: {}", document, source, target);
            archiveDocument(document, source);
        }
        else if (Departments.END.equals(source)) {
            LOGGER.warn("sendDocument|Niepoprawne użycie metody. Źródłowy dział nie może być typu END. "
                    + "Parametry: dokuemt: {}, z: {} do: {}", document, source, target);
            throw new IllegalArgumentException("Dział źródłowy nie może być fikcyjnym działem END. Source department: "
                    + source + " target department: " + target);
        }
        else {
            Date currDate = new Date();
            CurrentDocumentDto currentDto = currentDocumentDao.loadById(document.getCurrentContentId(),
                    CurrentDocumentDto.class).get();
            Date archivalDateOfRecipt = currentDto.getDateOfRecipt();
            currentDto.setContent(documentContentSerialization.convertToStream(document.getHeader().getType(),
                    document.getContent()));
            currentDto.setSourceDepartment(departmentDao.getDepartment(source));
            currentDto.setTargetDepartment(departmentDao.getDepartment(target));
            currentDto.setDateOfRecipt(currDate);
            ArchivalDocumentDto archivalDto = new ArchivalDocumentDto(currentDto);
            archivalDto.setDateOfDispatch(currDate);
            archivalDto.setDateOfRecipt(archivalDateOfRecipt);
            archivalDocumentDao.save(archivalDto);
            currentDocumentDao.update(currentDto);
        }
        LOGGER.debug("sendDocument|Przeslanie dokumentu: {} z: {} do: {} zakończyło się sukcesem.", document, source,
                target);
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
        CurrentDocumentDto currentDto = currentDocumentDao.loadById(document.getCurrentContentId(),
                CurrentDocumentDto.class).get();
        DepartmentDto sourceDto = departmentDao.getDepartment(department);
        DepartmentDto targetDto = departmentDao.getDepartment(Departments.END);
        ArchivalDocumentDto archivalDto = new ArchivalDocumentDto();
        archivalDto.setContent(documentContentSerialization.convertToStream(document.getHeader().getType(),
                document.getContent()));
        archivalDto.setDateOfDispatch(new Date());
        archivalDto.setDateOfRecipt(currentDto.getDateOfRecipt());
        archivalDto.setHeader(currentDto.getHeader());
        archivalDto.setSourceDepartment(sourceDto);
        archivalDto.setTargetDepartment(targetDto);
        archivalDocumentDao.save(archivalDto);
        currentDocumentDao.delete(currentDto);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentStub> loadCurrentDocuments(final SearchCriteria searchCriteria) {
        if (!validSearchCriteria(searchCriteria)) {
            LOGGER.error("loadCurrentDocuments|Żadene kryterium nie zostało wybrane.");
            throw new IllegalArgumentException("Przynajmniej jedno kryterium musi być wybrane.");
        }
        
        Optional<List<LightCurrentDocumentDto>> documents = currentDocumentDao.loadDocuments(searchCriteria);
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
     * Sprawdza czy kryteria wyszukiwania są poprawne.
     * 
     * @param searchCriteria kryteria wyszukiwania.
     * @return true - kryteria są poprawne; false - kryteria są niepoprawne.
     */
    private boolean validSearchCriteria(final SearchCriteria searchCriteria) {
        boolean valid = false;
        
        valid |= searchCriteria.getDepartment() != null;
        valid |= searchCriteria.getFrom() != null;
        valid |= searchCriteria.getTo() != null;
        valid |= searchCriteria.getType() != null;
        if (!StringUtil.isEmpty(searchCriteria.getSignature())) {
            searchCriteria.setSignature(searchCriteria.getSignature().trim());
            valid |= true;
        }
        if (!StringUtil.isEmpty(searchCriteria.getTitle())) {
            searchCriteria.setTitle(searchCriteria.getTitle().trim());
            valid |= true;
        }
        
        return valid;
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
     * Ustawia serwis serializujący zawartość dokumentów.
     * 
     * @param documentContentSerialization serwis serializujący zawartość dokumentów.
     */
    public void setDocumentContentSerialization(IDocumentContentSerialization documentContentSerialization) {
        this.documentContentSerialization = documentContentSerialization;
    }

    /**
     * Ustawia DAO dla oddziałów.
     * 
     * @param departmentDao DAO dla oddziałów.
     */
    public void setDepartmentDao(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /**
     * Ustawia DAO dla nagłówków dokumentów.
     * 
     * @param documentHeaderDao dao dla nagłówków dokumentów.
     */
    public void setDocumentHeaderDao(IDocumentHeaderDao documentHeaderDao) {
        this.documentHeaderDao = documentHeaderDao;
    }

    /**
     * Ustawia DAO dla bieżącej zawartości dokumentów.
     * 
     * @param currentDocumentDao DAO dla bieżącej zawartości dokumentów.
     */
    public void setCurrentDocumentDao(ICurrentContentDao currentDocumentDao) {
        this.currentDocumentDao = currentDocumentDao;
    }

    /**
     * Ustawia DAO dla archivalnej zawartości dokumentów.
     * 
     * @param archivalDocumentDao DAO dla archiwalnej zawartości dokumentów.
     */
    public void setArchivalDocumentDao(IArchivalContentDao archivalDocumentDao) {
        this.archivalDocumentDao = archivalDocumentDao;
    }
}