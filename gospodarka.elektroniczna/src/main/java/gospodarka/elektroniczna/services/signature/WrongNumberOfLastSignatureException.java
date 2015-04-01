package gospodarka.elektroniczna.services.signature;

/**
 * Wyjątek pojawia się, gdy z jakiegoś niezdefiniowanego powodu w tabeli, która przechowuje ostatnią nadaną sygnaturę
 * pojawi się więcej niż jeden rekord. 
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class WrongNumberOfLastSignatureException extends Exception {
    /**
     * UID.
     */
    private static final long serialVersionUID = 5816757597944302273L;
    
    /**
     * Konstruktor.
     */
    public WrongNumberOfLastSignatureException() {
        super();
    }
    
    /**
     * Konstruktor.
     * 
     * @param msg komunikat.
     */
    public WrongNumberOfLastSignatureException(final String msg) {
        super(msg);
    }
}