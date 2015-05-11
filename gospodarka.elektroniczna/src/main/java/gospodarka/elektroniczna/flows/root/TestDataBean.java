package gospodarka.elektroniczna.flows.root;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.TestDocument;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.SearchCriteria;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TestDataBean implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 1479179301277604531L;

    private List<DocumentStub> documents;

    private TestDocument testDocument = new TestDocument();

    private SearchCriteria searchCriteria = new SearchCriteria();
    
    private List<Departments> departments = Arrays.asList(Departments.values());
    
    private List<DocumentTypes> documentTypes = Arrays.asList(DocumentTypes.values());

    public List<DocumentStub> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentStub> documents) {
        this.documents = documents;
    }

    public TestDocument getTestDocument() {
        return testDocument;
    }

    public void setTestDocument(TestDocument testDocument) {
        this.testDocument = testDocument;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    public List<DocumentTypes> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentTypes> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
