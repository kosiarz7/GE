package gospodarka.elektroniczna.flows.root;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.TestDocument;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

import java.io.Serializable;

import org.slf4j.LoggerFactory;

/**
 * Bean wykorzystywany do testów w webflow dla roota.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class TestBean implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 2043035616192471454L;
    /**
     * Serwis dla dokumentów.
     */
    private IDocumentService documentService;
    
    /**
     * Tworzy nowy testowy dokument.
     * 
     * @return 
     */
    public void createNewTestDocument() {
        try {
            documentService.createDocument(DocumentTypes.TEST, "Nowy tytuł. ąśćóęłżźŻŹĆĄŚŁĘÓ");
        }
        catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(TestBean.class).error("błąd", e);
        }
    }
    
    /**
     * Testowy zapis dokumentu.
     * 
     * @param document zapisuje dokument.
     */
    public void createAndSave() {
        try {
            documentService.sendDocument(
                    documentService.createDocument(DocumentTypes.TEST, "Nowy tytuł. ąśćóęłżźŻŹĆĄŚŁĘÓ"), Departments.BEGIN,
                    Departments.FINANCE);
        }
        catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(TestBean.class).error("błąd", e);
        }
    }
    
    public void loadDocuemnts(TestDataBean bean) {
        bean.setDocuments(documentService.loadCurrentDocumentsInDepartment(Departments.FINANCE));
    }
    
    public void loadDocuemntsByType(TestDataBean bean) {
        bean.setDocuments(documentService.loadCurrentDocumentsInDepartment(Departments.FINANCE, DocumentTypes.TEST));
    }
    
    public void loadDocument(DocumentStub stub, TestDataBean bean) {
        bean.setTestDocument(documentService.loadCurrentDocument(stub, TestDocument.class).getContent());
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
}