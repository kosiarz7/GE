package gospodarka.elektroniczna.dao.flows.root;

import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.signature.WrongNumberOfLastSignatureException;

import java.io.Serializable;

import org.slf4j.LoggerFactory;

/**
 * Bean wykorzystywany do testów w webflow dla roota.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class TestBean implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 2043035616192471454L;
    /**
     * Serwis dla dokumentów.
     */
    private IDocumentService documentService;
    
    /**
     * Tworzy nowy testowy dokument.
     */
    public void createNewTestDocument() {
        try {
            documentService.createDocument(DocumentTypes.TEST, "Nowy tytuł. ąśćóęłżźŻŹĆĄŚŁĘÓ");
        }
        catch (WrongNumberOfLastSignatureException e) {
            LoggerFactory.getLogger(TestBean.class).error("błąd", e);
        }
    }
    
    public void setDocumentService(final IDocumentService documentService) {
        this.documentService = documentService;
    }
}