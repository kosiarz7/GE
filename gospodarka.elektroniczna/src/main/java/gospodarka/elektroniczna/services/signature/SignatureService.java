package gospodarka.elektroniczna.services.signature;

import gospodarka.elektroniczna.dao.sgnature.ISignatureDao;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Serwis do obsługi sygnatury dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class SignatureService implements ISignatureService {
    /**
     * DAO do współpracy z sygnaturą dokumentu.
     */
    private ISignatureDao signatureDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNewSignature() {
        String signature = createNewSingature();
        signatureDao.updateLastSignature(signature);
        return signature;
    }
    
    /**
     * Tworzy nową sygnature.
     * 
     * @return nowa sygnatura.
     */
    protected String createNewSingature() {
        String signature = signatureDao.getLastSignature();
        GregorianCalendar calendar = new GregorianCalendar();
        
        if (null != signature && isCurrentDateInSignature(signature, calendar)) {
            int lastSlashIndex = signature.lastIndexOf("/") + 1;
            signature = signature.substring(0, lastSlashIndex) + 
                    + (Integer.valueOf(signature.substring(lastSlashIndex, signature.length())) + 1);
        }
        else {
            signature = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/1";
        }
        
        return signature;
    }
    
    /**
     * Sprawdza czy w syganturze jest zawarta aktualna data (rok i miesiąc).
     * 
     * @param signature sygnatura.
     * @param calendar aktualna data.
     * @return true - sygnatura zawiera aktualną datę; false - sygnatura nie zawiera aktualnej daty.
     */
    private boolean isCurrentDateInSignature(final String signature, final GregorianCalendar calendar) {
        boolean actualDate = true;
        String[] partsOfSingature = signature.split("/");
        
        actualDate &= calendar.get(Calendar.YEAR) == Integer.valueOf(partsOfSingature[0]);
        actualDate &= calendar.get(Calendar.MONTH) + 1 == Integer.valueOf(partsOfSingature[1]);
        
        return actualDate;
    }
    
    /**
     * Ustawia DAO dla sygnatury dokumentu.
     * 
     * @param signatureDao DAO sygnatury dokumentu.
     */
    public void setSignatureDao(final ISignatureDao signatureDao) {
        this.signatureDao = signatureDao;
    }
}