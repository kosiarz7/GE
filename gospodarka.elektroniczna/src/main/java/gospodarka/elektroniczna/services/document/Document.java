package gospodarka.elektroniczna.services.document;

import java.util.Date;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

public class Document<T> {
    /**
     * Id nagłówka dokumentu.
     */
    private int headerId;
    /**
     * Sygnatura dokumentu.
     */
    private String signature;
    /**
     * Tytuł dokumentu.
     */
    private String title;
    /**
     * Typ dokumentu.
     */
    private DocumentTypes type;
    /**
     * Z jakiego działu przyszedł dokument.
     */
    private Departments from;
    /**
     * Data odbioru dokumentu.
     */
    private Date receiptDate;
    /**
     * Zawartość dokumentu.
     */
    private T content;

    /**
     * Zwraca zawartość dokumentu.
     * 
     * @return zawartość dokumentu.
     */
    public T getContent() {
        return content;
    }

    /**
     * Ustawia zawartość dokumentu.
     * 
     * @param content zawartość dokumentu.
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Zwraca id nagłówka dokumentu.
     * 
     * @return id nagłówka dokumentu.
     */
    int getHeaderId() {
        return headerId;
    }

    /**
     * Zwraca sygnaturę dokumentu.
     * 
     * @return sygnatura dokumentu.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Zwraca tytuł dokumentu.
     * 
     * @return tytuł dokumentu.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Zwraca typ dokumentu.
     * 
     * @return typ dokumentu.
     */
    public DocumentTypes getType() {
        return type;
    }

    /**
     * Zwraca dział, który przesłał dany dokument.
     * 
     * @return dział, który przesłał dany dokument.
     */
    public Departments getFrom() {
        return from;
    }

    /**
     * Zwraca datę odbioru dokumentu.
     * 
     * @return data odbioru dokumentu.
     */
    public Date getReceiptDate() {
        return receiptDate;
    }

    /**
     * Ustawia id nagłówka dokumentu.
     * 
     * @param headerId id nagłówka dokumentu.
     */
    void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    /**
     * Ustawia sygnaturę dokumentu.
     * 
     * @param signature sygnatura dokumentu.
     */
    void setSignature(final String signature) {
        this.signature = signature;
    }

    /**
     * Ustawia tytuł dokumentu.
     * 
     * @param title tytuł dokumentu.
     */
    void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Ustawia typ dokumentu.
     * 
     * @param type typ dokumentu.
     */
    void setType(final DocumentTypes type) {
        this.type = type;
    }

    /**
     * Ustawia oddział, który przysłał dany dokument.
     * 
     * @param from oddział, który przysłał dokument.
     */
    void setFrom(final Departments from) {
        this.from = from;
    }
    
    /**
     * Ustawia datę odbioru dokumentu.
     * 
     * @param receiptDate data odbioru dokumentu.
     */
    void setReceiptDate(final Date receiptDate) {
        this.receiptDate = receiptDate;
    }
}