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
    BEGIN("Poczatek"), 
    /**
     * Kadry.
     */
    HUMAN_RESOURCES("Kadry"),
    /**
     * Produkcja.
     */
    MANUFACTURE("Produkcja"),
    /**
     * Finanse i płace.
     */
    FINANCE("Finanse"),
    /**
     * Serwis.
     */
    SERVIS("Serwis"),
    /**
     * Magazyn.
     */
    STOREHOUSE("Magazyn"),
    /**
     * Obsługa klienta.
     */
    CUSTOMER_SERVICE("Obsługa klienta"),
    /**
     * Fikcyjny dział służacy do oznaczenia końca obiegu danego dokumentu.
     */
    END("Koniec");

    private String departmentStr;
    private Departments(String departmentStr)
    {
    	this.departmentStr = departmentStr;
    }
    
    public String getDepartmentString()
    {
    	return departmentStr;
    }
}