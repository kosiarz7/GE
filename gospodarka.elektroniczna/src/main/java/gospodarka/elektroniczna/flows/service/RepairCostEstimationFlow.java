/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.service.RepairCostEstimationForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import java.io.Serializable;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Piotrek
 */
public class RepairCostEstimationFlow implements Serializable {
    
    private IDocumentService documentService;
    
    public boolean sendDocument(RepairCostEstimationForm repairCostEstimationForm)
    {
        try {
            Document<RepairCostEstimationForm> document = documentService.createDocument(DocumentTypes.REPAIR_COST_ESTIMATION, "Kosztorys naprawy pogwarancyjnej", Departments.SERVIS);
            document.setContent(repairCostEstimationForm);
            documentService.sendDocument(document, Departments.SERVIS, Departments.CUSTOMER_SERVICE);
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
