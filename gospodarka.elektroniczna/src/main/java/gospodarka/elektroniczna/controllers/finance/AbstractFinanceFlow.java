package gospodarka.elektroniczna.controllers.finance;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.finance.AbstractFinanceDocument;
import gospodarka.elektroniczna.documents.finance.InvoiceDocument;
import gospodarka.elektroniczna.dto.finance.AbstractFinanceUser;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;
import gospodarka.elektroniczna.services.user.UserData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

public abstract class AbstractFinanceFlow<T extends AbstractFinanceUser> {

    private IDocumentService documentService;
    private String documentTitle;
    private DocumentTypes documentType;
    private Departments targetDepartment;

    public AbstractFinanceFlow(String documentTitle, DocumentTypes documentType, Departments targetDepartment) {
        this.documentTitle = documentTitle;
        this.documentType = documentType;
        this.targetDepartment = targetDepartment;
    }

    public IDocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    protected boolean submit(UserData userData, T documentData) {
       return submit(userData, targetDepartment, documentData);
    }

    protected boolean submit(UserData userData, Departments targetDepartment, T documentData) {
        try {
            Departments senderDepartment = convertRoleToDepartments(userData);
            Document<AbstractFinanceDocument<T>> document = documentService.createDocument(documentType, documentTitle,
                    senderDepartment);
            document.getContent().setData(documentData);
            documentData.setUserName(userData.getName());
            documentData.setUserSurname(userData.getSurname());
            documentData.setDepartment(senderDepartment);
            documentService.sendDocument(document, senderDepartment, targetDepartment);
            return true;
        } catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(InvoiceDocument.class).error("błąd", e);
            return false;
        }
    }

    protected boolean submit(UserData userData, Departments senderDepartment, Departments targetDepartment, T documentData) {
        try {
            Document<AbstractFinanceDocument<T>> document = documentService.createDocument(documentType, documentTitle,
                    senderDepartment);
            document.getContent().setData(documentData);
            documentData.setUserName(userData.getName());
            documentData.setUserSurname(userData.getSurname());
            documentData.setDepartment(senderDepartment);
            documentService.sendDocument(document, senderDepartment, targetDepartment);
            return true;
        } catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(InvoiceDocument.class).error("błąd", e);
            return false;
        }
    }
    
    protected List<T> search(SearchCriteria criteria) {
        List<DocumentStub> documentStubs = documentService.loadCurrentDocuments(criteria);

        ArrayList<T> documents = new ArrayList<T>(documentStubs.size());
        for (DocumentStub documentStub : documentStubs) {
            Document<AbstractFinanceDocument<T>> document = documentService.loadCurrentDocument(documentStub);
            T documentData = document.getContent().getData();
            documents.add(documentData);
        }
        return documents;
    }

    protected Departments convertRoleToDepartments(UserData userData) {
        Collection<? extends GrantedAuthority> authorities = userData.getAuthorities();
        String roleName = authorities.iterator().next().getAuthority().toUpperCase();

        switch (roleName) {
        case "ROLE_HR":
            return Departments.HUMAN_RESOURCES;
        case "ROLE_MANUFACTURE":
            return Departments.MANUFACTURE;
        case "ROLE_FINANCE":
            return Departments.FINANCE;
        case "ROLE_SERVIS":
            return Departments.SERVIS;
        case "ROLE_STOREHOUSE":
            return Departments.STOREHOUSE;
        case "ROLE_CUSTOMER_SERVICE":
            return Departments.CUSTOMER_SERVICE;
        case "ROLE_ROOT":
            return Departments.BEGIN;
        default:
            return null;
        }
    }
}
