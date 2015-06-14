/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.documents.manufacture.MonthlySummaryOfProductionLineDocument;
import gospodarka.elektroniczna.dto.storehouse.PWDocument;
import gospodarka.elektroniczna.dto.storehouse.WWDocument;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class ServiceFlow implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private IDocumentService documentService;
    private MonthlySummaryOfProductionLineDocument monthlySummary;
    private PWDocument pwForm;
    private WWDocument wwForm;
    
    public List<DocumentStub> getDocumentStubs()
    {
        List<DocumentStub> documentStubs = documentService.loadCurrentDocuments(new SearchCriteria().department(Departments.MANUFACTURE));

        return documentStubs;
    }
    
    public String archivizeDocument(DocumentStub documentStub)
    {
        documentService.archiveDocument(documentService.loadCurrentDocument(documentStub), Departments.MANUFACTURE);
        return "goReceiveDocuments";
    }
    
    public String loadDocument(DocumentStub documentStub)
    {
        switch(documentStub.getType())
        {
            case MONTHLY_SUMMARY_OF_PRODUCTION_LINE:
                Document<MonthlySummaryOfProductionLineDocument> monthlySummaryDocument = documentService.loadCurrentDocument(documentStub);
                setMonthlySummaryForm(monthlySummaryDocument.getContent());
                return "goLoadMonthlySummaryForm";
            /*case :
                Document<PWDocument> pwDocument = documentService.loadCurrentDocument(documentStub);
                setPWForm(pwDocument.getContent());
                return "goLoadPWForm";
            case :
                Document<WWDocument> wwDocument = documentService.loadCurrentDocument(documentStub);
                setWWForm(wwDocument.getContent());
                return "goLoadWWForm";*/
            default:
                return "cancel";
        }
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setMonthlySummaryForm(final MonthlySummaryOfProductionLineDocument monthlySummary) {
        this.monthlySummary = monthlySummary;
    }
    
    public void setPWForm(final PWDocument pwForm) {
        this.pwForm = pwForm;
    }
    
     public void setWWForm(final WWDocument wwForm) {
        this.wwForm = wwForm;
    }
     
    public MonthlySummaryOfProductionLineDocument getMonthlySummary() {
        return monthlySummary;
    }

    public PWDocument getPwForm() {
        return pwForm;
    }

    public WWDocument getWwForm() {
        return wwForm;
    }
}
