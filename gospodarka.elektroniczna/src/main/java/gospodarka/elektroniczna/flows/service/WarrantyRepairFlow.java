/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.service.DamagedCarForm;
import gospodarka.elektroniczna.documents.service.WarrantyRepairForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import java.io.Serializable;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Piotrek
 */
public class WarrantyRepairFlow implements Serializable {
    
    private IDocumentService documentService;
    
    public boolean sendDocument(WarrantyRepairForm warrantyRepairForm)
    {
        try {
            Document<WarrantyRepairForm> document = documentService.createDocument(DocumentTypes.WARRANTY_REPAIR, "Naprawa w ramach gwarancji", Departments.SERVIS);
            document.setContent(warrantyRepairForm);
            documentService.sendDocument(document, Departments.SERVIS, Departments.SERVIS);
            warrantyRepairForm.clear();
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
