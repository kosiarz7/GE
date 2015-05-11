package gospodarka.elektroniczna.flows.root;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.TestDocument;
import gospodarka.elektroniczna.services.document.Document;
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
     * Testowy zapis dokumentu.
     * 
     * @param document zapisuje dokument.
     */
    public void create() {
        try {
            documentService.createDocument(DocumentTypes.TEST, "Title", Departments.FINANCE);
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
    
    public void loadDocuemntsByType2(TestDataBean bean) {
        bean.setDocuments(documentService.loadCurrentDocumentsInDepartment(Departments.SERVIS, DocumentTypes.TEST));
    }
    
    public void loadDocument(DocumentStub stub, TestDataBean bean) {
        bean.setTestDocument((TestDocument) documentService.loadCurrentDocument(stub).getContent());
    }
    
    public void send(DocumentStub stub) {
        Document<TestDocument> doc = documentService.loadCurrentDocument(stub);
        documentService.sendDocument(doc, Departments.FINANCE, Departments.SERVIS);
    }
    
    public void end(DocumentStub stub) {
        Document<TestDocument> doc = documentService.loadCurrentDocument(stub);
        documentService.archiveDocument(doc, Departments.SERVIS);
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
}