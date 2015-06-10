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
    NEW_CANDIDATE, RESIGNATION_EMPLOYEE, RESIGNATION_EMPLOYER, SICK_LEAVE, TRAINING_CLEARING,
   DEFECTIVE_ELEMENT, INDUSTRIAL_ACCIDENT, MONTHLY_SUMMARY_OF_PRODUCTION_LINE, ORDER, TIME_SHEET, NEW_VEHICLE,
    INTERNAL_ISSUE,  INTERNAL_ADOPTION, EXTERNAL_ISSUE, EXTERNAL_ADOPTION,  ORDER_CONFIRMATION,
    COLLECT_CAR, DAMAGED_CAR, REPAIR_COST_ESTIMATION, REPLACEMENT_PART_ORDER, WARRANTY_REPAIR ;
}
