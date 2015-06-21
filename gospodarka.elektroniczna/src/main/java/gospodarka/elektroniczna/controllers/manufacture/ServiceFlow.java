/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.documents.manufacture.MonthlySummaryOfProductionLineDocument;
import gospodarka.elektroniczna.documents.storehouse.PODocument_A;
import gospodarka.elektroniczna.documents.storehouse.PPZDocument_A;
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
    private PPZDocument_A ppzForm;
    private PODocument_A poForm;

    public PODocument_A getPoForm() {
        return poForm;
    }

    public void setPoForm(final PODocument_A poForm) {
        this.poForm = poForm;
    }
    
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
            case PRODUCTION_ORDER:
                Document<PODocument_A> poDocument = documentService.loadCurrentDocument(documentStub);
                setPoForm(poDocument.getContent());
                return "goLoadPOForm";
            case ORDER_CONFIRMATION:
                Document<PPZDocument_A> ppzDocument = documentService.loadCurrentDocument(documentStub);
                setPpzForm(ppzDocument.getContent());
                return "goLoadPPZForm";
            default:
                return "cancel";
        }
    }

    public PPZDocument_A getPpzForm() {
        return ppzForm;
    }

    public void setPpzForm(final PPZDocument_A ppzForm) {
        this.ppzForm = ppzForm;
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
    
    public void setMonthlySummaryForm(final MonthlySummaryOfProductionLineDocument monthlySummary) {
        this.monthlySummary = monthlySummary;
    }
    
    public MonthlySummaryOfProductionLineDocument getMonthlySummary() {
        return monthlySummary;
    }

}
