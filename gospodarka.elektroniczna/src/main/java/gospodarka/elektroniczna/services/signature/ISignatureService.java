package gospodarka.elektroniczna.services.signature;

/**
 * Interfejs serwisu do współpracy z sygnaturą dokumentu. 
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface ISignatureService {
    /**
     * Zwraca nową sygnaturę dokumentu.
     * 
     * @return sygnatura dokumentu.
     */
    String getNewSignature();
}
