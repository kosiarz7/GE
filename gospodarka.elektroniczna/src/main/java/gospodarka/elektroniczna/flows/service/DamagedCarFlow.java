/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.service.DamagedCarForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import java.io.Serializable;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Piotrek
 */
public class DamagedCarFlow implements Serializable {
    
    private IDocumentService documentService;
    
    public boolean sendDocument(DamagedCarForm damagedCarForm)
    {
        try {
            Document<DamagedCarForm> document = documentService.createDocument(DocumentTypes.DAMAGED_CAR, "Przyjęcie uszkodzonego samochodu", Departments.SERVIS);
            document.setContent(damagedCarForm);
            documentService.sendDocument(document, Departments.SERVIS, Departments.SERVIS);
            return true;
        } catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(ServiceFlow.class).error("błąd", e);
            return false;
        }
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
}
