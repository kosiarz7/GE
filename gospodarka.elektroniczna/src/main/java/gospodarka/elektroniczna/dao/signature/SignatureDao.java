package gospodarka.elektroniczna.dao.signature;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

/**
 * DAO dla sygnatury dokumentu.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class SignatureDao extends CommonDao implements ISignatureDao, Serializable {
    /**
     * UID.
     */
    private static final long serialVersionUID = 2935920387890581523L;
    /**
     * Logger.
     */
    @InjectLogger
    private static final Logger LOGGER = null;
    /**
     * Zapytanie wydobywające liczbę przechowywanych rekkordów w tabeli z ostatnio nadaną sygnaturą.
     */
    private static final String SIGNATURE_NUMBER_QUERY = "SELECT COUNT(*) FROM LAST_SIGNATURE";
    /**
     * Zwraca ostatnią sygnaturę.
     */
    private static final String GET_LAST_SIGNATURE_QUERY = "SELECT SIGNATURE FROM LAST_SIGNATURE";
    /**
     * Pobiera id ostatniej sygnatury.
     */
    private static final String GET_LAST_SIGNATURE_ID = "SELECT ID FROM LAST_SIGNATURE";
    /**
     * Uaktualnia wartość ostatniej sygnatury.
     */
    private static final String UPDATE_LAST_SIGNATURE = 
            "UPDATE LAST_SIGNATURE SET SIGNATURE = :signature WHERE ID = :id";
    /**
     * Zapytanie wstawiające nową sygnaturę.
     */
    private static final String INSERT_SIGNATURE = "INSERT INTO LAST_SIGNATURE(SIGNATURE) VALUE(:signature)";

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public String getLastSignature() {
        String signature = "";
        
        Session session = openSession();
        Transaction tx = null;
        List<String> signatures = null;
        
        try {
            tx = session.beginTransaction();
            signatures = session.createSQLQuery(GET_LAST_SIGNATURE_QUERY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
        
        if (!signatures.isEmpty()) {
            signature = signatures.get(0);
        }
                
        LOGGER.info("getLastSignature|Pobranie ostatniej sygnatury: {}", signature);
        return signature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLastSignature(final String signature) {
        LOGGER.info("updateLastSignature|Uaktualnienie sygnatury na: {}", signature);
        int signaturesNumber = getSignaturesNumber();
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            if (0 == signaturesNumber) {
                session.createSQLQuery(INSERT_SIGNATURE).setString("signature", signature).executeUpdate();
            }
            else {
                int signatureId = (int) session.createSQLQuery(GET_LAST_SIGNATURE_ID).list().get(0);
                session.createSQLQuery(UPDATE_LAST_SIGNATURE).setString("signature", signature)
                    .setInteger("id", signatureId).executeUpdate();
            }
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSignaturesNumber() {
        int result = 0;
        
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            result = ((BigInteger) session.createSQLQuery(SIGNATURE_NUMBER_QUERY).list().get(0)).intValue();
            tx.commit();
        }
        catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
                
        return result;
    }
}