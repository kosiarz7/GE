/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.service.RepairCostEstimationForm;
import gospodarka.elektroniczna.documents.service.ReplacementPartOrderForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import java.io.Serializable;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Piotrek
 */
public class ReplacementPartOrderFlow implements Serializable {
    
    private IDocumentService documentService;
    
    public boolean sendDocument(ReplacementPartOrderForm replacementPartOrderForm)
    {
        try {
            Document<ReplacementPartOrderForm> document = documentService.createDocument(DocumentTypes.REPLACEMENT_PART_ORDER, "Zamówienie części zamiennej", Departments.SERVIS);
            document.setContent(replacementPartOrderForm);
            documentService.sendDocument(document, Departments.SERVIS, Departments.STOREHOUSE);
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
