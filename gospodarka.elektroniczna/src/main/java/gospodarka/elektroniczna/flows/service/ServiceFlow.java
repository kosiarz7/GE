/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.customerService.ServiceOrderCardDocument;
import gospodarka.elektroniczna.documents.customerService.TestDriveReportDocument;
import gospodarka.elektroniczna.documents.manufacture.DefectiveElementDocument;
import gospodarka.elektroniczna.documents.service.CollectCarForm;
import gospodarka.elektroniczna.documents.service.DamagedCarForm;
import gospodarka.elektroniczna.documents.service.ReplacementPartOrderForm;
import gospodarka.elektroniczna.documents.service.WarrantyRepairForm;
import gospodarka.elektroniczna.dto.customerService.ServiceOrderCard;
import gospodarka.elektroniczna.dto.customerService.TestDriveReport;
import gospodarka.elektroniczna.dto.manufacture.DefectiveElementForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Piotrek
 */
public class ServiceFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    private IDocumentService documentService;
    
    private DamagedCarForm damagedCarForm;
    private WarrantyRepairForm warrantyRepairForm;
    private CollectCarForm collectCarForm;
    private DefectiveElementForm defectiveElementForm;
    private ServiceOrderCard serviceOrderCardForm;
    private TestDriveReport testDriveReportForm;
    
    public List<DocumentStub> getDocumentStubs()
    {
        List<DocumentStub> documentStubs = documentService.loadCurrentDocuments(new SearchCriteria().department(Departments.SERVIS));

        return documentStubs;
    }
    
    public String archivizeDocument(DocumentStub documentStub)
    {
        documentService.archiveDocument(documentService.loadCurrentDocument(documentStub), Departments.SERVIS);
        return "goReceiveDocuments";
    }
    
    public String loadDocument(DocumentStub documentStub)
    {
        switch(documentStub.getType())
        {
            case DAMAGED_CAR:
                Document<DamagedCarForm> damagedDocument = documentService.loadCurrentDocument(documentStub);
                setDamagedCarForm(damagedDocument.getContent());
                return "goLoadDamagedCarForm";
            case WARRANTY_REPAIR:
                Document<WarrantyRepairForm> warrantyDocument = documentService.loadCurrentDocument(documentStub);
                setWarrantyRepairForm(warrantyDocument.getContent());
                return "goLoadWarrantyRepairForm";
            case COLLECT_CAR:
                Document<CollectCarForm> collectCarDocument = documentService.loadCurrentDocument(documentStub);
                setCollectCarForm(collectCarDocument.getContent());
                return "goLoadCollectCarForm";
            case DEFECTIVE_ELEMENT:
                Document<DefectiveElementDocument> defectiveElementDocument = documentService.loadCurrentDocument(documentStub);
                setDefectiveElementForm(defectiveElementDocument.getContent().getData());
                return "goLoadDefectiveElementForm";
            case SERVICE_ORDER_CARD:
                Document<ServiceOrderCardDocument> serviceOrderCardDocument = documentService.loadCurrentDocument(documentStub);
                setServiceOrderCardForm(serviceOrderCardDocument.getContent().getData());
                return "goLoadServiceOrderCardForm";
            case TEST_DRIVE_REPORT:
                Document<TestDriveReportDocument> testDriveReportDocument = documentService.loadCurrentDocument(documentStub);
                setTestDriveReportForm(testDriveReportDocument.getContent().getData());
                return "goLoadTestDriveReportForm";
            default:
                return "goLoadError";
        }
    }
    
    public ReplacementPartOrderForm loadOrderForm()
    {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setDepartment(Departments.STOREHOUSE);
        searchCriteria.setType(DocumentTypes.REPLACEMENT_PART_ORDER);
        List<DocumentStub> documentStubs = documentService.loadCurrentDocuments(searchCriteria);
        Document<ReplacementPartOrderForm> replacementPartOrderDocument;
        if(documentStubs.size() >= 1)
        {
            replacementPartOrderDocument = documentService.loadCurrentDocument(documentStubs.get(0));
            
            return replacementPartOrderDocument.getContent();
        }
        else
        {
            return null;
        }
            
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * @return the damagedCarForm
     */
    public DamagedCarForm getDamagedCarForm() {
        return damagedCarForm;
    }

    /**
     * @param damagedCarForm the damagedCarForm to set
     */
    public void setDamagedCarForm(DamagedCarForm damagedCarForm) {
        this.damagedCarForm = damagedCarForm;
    }

    /**
     * @return the warrantyRepairForm
     */
    public WarrantyRepairForm getWarrantyRepairForm() {
        return warrantyRepairForm;
    }

    /**
     * @param warrantyRepairForm the warrantyRepairForm to set
     */
    public void setWarrantyRepairForm(WarrantyRepairForm warrantyRepairForm) {
        this.warrantyRepairForm = warrantyRepairForm;
    }

    /**
     * @return the collectCarForm
     */
    public CollectCarForm getCollectCarForm() {
        return collectCarForm;
    }

    /**
     * @param collectCarForm the collectCarForm to set
     */
    public void setCollectCarForm(CollectCarForm collectCarForm) {
        this.collectCarForm = collectCarForm;
    }

    /**
     * @return the defectiveElementDocument
     */
    public DefectiveElementForm getDefectiveElementForm() {
        return defectiveElementForm;
    }

    /**
     * @param defectiveElementForm the defectiveElementDocument to set
     */
    public void setDefectiveElementForm(DefectiveElementForm defectiveElementForm) {
        this.defectiveElementForm = defectiveElementForm;
    }

    /**
     * @return the serviceOrderCardForm
     */
    public ServiceOrderCard getServiceOrderCardForm() {
        return serviceOrderCardForm;
    }

    /**
     * @param serviceOrderCardForm the serviceOrderCardForm to set
     */
    public void setServiceOrderCardForm(ServiceOrderCard serviceOrderCardForm) {
        this.serviceOrderCardForm = serviceOrderCardForm;
    }

    /**
     * @return the testDriveReportForm
     */
    public TestDriveReport getTestDriveReportForm() {
        return testDriveReportForm;
    }

    /**
     * @param testDriveReportForm the testDriveReportForm to set
     */
    public void setTestDriveReportForm(TestDriveReport testDriveReportForm) {
        this.testDriveReportForm = testDriveReportForm;
    }
}