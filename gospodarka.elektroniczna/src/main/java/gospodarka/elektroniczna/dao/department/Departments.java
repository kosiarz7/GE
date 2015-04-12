package gospodarka.elektroniczna.dao.department;

/**
 * Dostępne oddziały w firmie.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public enum Departments {
    /*
     * UWAGA! Pola muszą mieć takie same nazwy jak poszczególne wartości rekordów w bazie!
     */
    /**
     * Fikcyjny dział służący do oznaczenia początku obiegu danego dokumentu.
     */
    BEGIN,
    /**
     * Kadry.
     */
    HUMAN_RESOURCES,
    /**
     * Produkcja.
     */
    MANUFACTURE,
    /**
     * Finanse i płace.
     */
    FINANCE,
    /**
     * Serwis.
     */
    SERVIS,
    /**
     * Magazyn.
     */
    STOREHOUSE,
    /**
     * Obsługa klienta.
     */
    CUSTOMER_SERVICE,
    /**
     * Fikcyjny dział służacy do oznaczenia końca obiegu danego dokumentu.
     */
    END;

}