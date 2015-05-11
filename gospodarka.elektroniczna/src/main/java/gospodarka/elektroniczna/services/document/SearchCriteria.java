package gospodarka.elektroniczna.services.document;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Kryteria wyszukiwania dokumentów.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public class SearchCriteria implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 7442221050127069764L;
    /**
     * Tytuł dokumentu.
     */
    private String title;
    /**
     * Sygnatura dokumentu.
     */
    private String signature;
    /**
     * Oddział.
     */
    private Departments department;
    /**
     * Typ dokumentu.
     */
    private DocumentTypes type;
    /**
     * Dokumenty, które wpłynęły od dnia.
     */
    private Date from;
    /**
     * Dokumenty, które wpłynęły do dnia.
     */
    private Date to;


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    /**
     * Ustawia tytuł szukanych dokumentów.
     * 
     * @param title tytuł.
     * @return this.
     */
    public SearchCriteria title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Ustawia sygnaturę szukanych dokumentów.
     * 
     * @param signature sygnatura.
     * @return this.
     */
    public SearchCriteria signature(String signature) {
        this.signature = signature;
        return this;
    }

    /**
     * Ustawia dział szukanych dokumentów.
     * 
     * @param department dział
     * @return this.
     */
    public SearchCriteria department(Departments department) {
        this.department = department;
        return this;
    }

    /**
     * Ustawia typ szukanych dokumentów.
     * 
     * @param type typ.
     * @return this.
     */
    public SearchCriteria type(DocumentTypes type) {
        this.type = type;
        return this;
    }

    /**
     * Ustawia datę datę wpłynięcia. Będą szukane <b>młodsze</b> dokumenty niż wskazana data.
     * 
     * @param from data wpłynięcia.
     * @return this.
     */
    public SearchCriteria from(Date from) {
        this.from = from;
        return this;
    }

    /**
     * Ustawia datę datę wpłynięcia. Będą szukane <b>starsze</b> dokumenty niż wskazana data.
     * 
     * @param to data wpłynięcia.
     * @return this.
     */
    public SearchCriteria to(Date to) {
        this.to = to;
        return this;
    }

    // SETTRY I GETTERY
    /**
     * Zwraca tytuł szukanych dokumentów.
     * 
     * @return tytuł.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Ustawia tytuł szukanych dokumentów.
     * 
     * @param title tytuł.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Zwraca syganturę szukanych dokumentów.
     * 
     * @return sygnatura.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Ustawia syganturę szukanych dokumentów.
     * 
     * @param signature sygnatura.
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Ustawia dział szukanych dokumentów.
     * 
     * @return dział.
     */
    public Departments getDepartment() {
        return department;
    }

    /**
     * Ustawia dział szukanych dokumentów.
     * 
     * @param department dział.
     */
    public void setDepartment(Departments department) {
        this.department = department;
    }

    /**
     * Ustawia typ szukanych dokumentów.
     * 
     * @return typ dokumentów.
     */
    public DocumentTypes getType() {
        return type;
    }

    /**
    * Ustawia typ szukanych dokumentów.
    * 
    * @param type typ dokumentów.
    */
    public void setType(DocumentTypes type) {
        this.type = type;
    }

    /**
     * Ustawia datę datę wpłynięcia. Będą szukane <b>młodsze</b> dokumenty niż wskazana data.
     * 
     * @return data wpłynięcia.
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Ustawia datę datę wpłynięcia. Będą szukane <b>młodsze</b> dokumenty niż wskazana data.
     * 
     * @param from data wpłynięcia.
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * Zwraca datę datę wpłynięcia. Będą szukane <b>starsze</b> dokumenty niż wskazana data.
     * 
     * @return data wpłynięcia.
     */
    public Date getTo() {
        return to;
    }
    
    /**
     * Ustawia datę datę wpłynięcia. Będą szukane <b>starsze</b> dokumenty niż wskazana data.
     * 
     * @param to data wpłynięcia.
     */
    public void setTo(Date to) {
        this.to = to;
    }
}
