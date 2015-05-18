package gospodarka.elektroniczna.dao.documenttype;

/**
 * Dostępne dokumenty w firmie.
 * 
 * @author Adam Kopaczewski
 *
 *         Copyright © 2015 Adam Kopaczewski
 */
public enum DocumentTypes {
    /*
     * UWAGA! Pola muszą mieć takie same nazwy jak poszczególne wartości
     * rekordów w bazie!
     */
    /**
     * Dokument służący do testów.
     */
    TEST, BUSINESS_TRAVEL_CLEARING, CANDIDATE_REQUEST, HOLIDAYS_REQUEST, INVOICE_CLEARING, 
    NEW_CANDIDATE, RESIGNATION_EMPLOYEE, RESIGNATION_EMPLOYER, SICK_LEAVE, TRAINING_CLEARING;
}
