package gospodarka.elektroniczna.dao.sgnature;

/**
 * Interfejs DAO dla sygnatury dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface ISignatureDao {
    /**
     * Zwraca ostatnią sygnaturę.
     * 
     * @return ostatnia sygnatura.
     */
    String getLastSignature();
    /**
     * Uaktualnia ostatnio nadaną sygnaturę.
     * 
     * @param signature ostanio nadana sygnatura.
     */
    void updateLastSignature(final String signature);
    /**
     * Zwraca liczbę sygnatur przechowywanych w tabeli z ostatnią sygnaturą.
     * 
     * @return liczba sygnatur.
     */
    int getSignaturesNumber();
}