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
     * @throws WrongNumberOfLastSignatureException gdy w tabeli z ostanią sygnaturą jest więcej niż jeden rekord.
     */
    String getNewSignature() throws WrongNumberOfLastSignatureException;
}