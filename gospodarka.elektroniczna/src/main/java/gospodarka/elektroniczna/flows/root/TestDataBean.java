package gospodarka.elektroniczna.flows.root;

import gospodarka.elektroniczna.documents.TestDocument;
import gospodarka.elektroniczna.services.document.DocumentStub;

import java.io.Serializable;
import java.util.List;

public class TestDataBean implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 1479179301277604531L;
    
    private List<DocumentStub> documents;
    
    private TestDocument testDocument = new TestDocument();

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
}
