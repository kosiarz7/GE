/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.service.CollectCarForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Piotrek
 */
public class CollectCarFlow implements Serializable {
    
    private IDocumentService documentService;
    
    public boolean sendDocument(CollectCarForm collectCarForm)
    {
        try {
            Document<CollectCarForm> document = documentService.createDocument(DocumentTypes.COLLECT_CAR, "Odbiór samochodu", Departments.SERVIS);
            document.getContent().setData(collectCarForm);
            documentService.sendDocument(document, Departments.SERVIS, Departments.SERVIS);
            return true;
        } catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(ServiceFlow.class).error("błąd", e);
            return false;
        }
    }
    
    public List<CollectCarForm> search()
    {
        List<DocumentStub> documentStubs = documentService.loadCurrentDocuments(new SearchCriteria().type(DocumentTypes.COLLECT_CAR));
        List<CollectCarForm> documents = new ArrayList<>(documentStubs.size());
        for(DocumentStub documentStub : documentStubs)
        {
            Document<CollectCarForm> document = documentService.loadCurrentDocument(documentStub);
            documents.add(document.getContent());
        }
        
        return documents;
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
}
