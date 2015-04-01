package gospodarka.elektroniczna.dao.sgnature;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;

import java.math.BigInteger;

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
public class SignatureDao extends CommonDao implements ISignatureDao {
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
     * Zwraca id ostatniej sygnatury.
     */
    private static final String GET_LAST_SIGNATURE_ID_QUERY = "SELECT ID FROM LAST_SIGNATURE";
    /**
     * Uaktualnia wartość ostatniej sygnatury.
     */
    private static final String UPDATE_LAST_SIGNATURE = 
            "UPDATE LAST_SIGNATURE SET SIGNATURE = :singature WHERE ID = :id";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLastSignature() {
        String signature = null;
        
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            signature = (String) session.createSQLQuery(GET_LAST_SIGNATURE_QUERY).list().get(0);
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
                
        LOGGER.info("getLastSignature|Pobranie ostatniej sygnatury: {}", signature);
        return signature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLastSignature(final String signature) {
        LOGGER.info("updateLastSignature|Uaktualnienie sygnatury na: {}", signature);
        Session session = openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            int id = (int) session.createSQLQuery(GET_LAST_SIGNATURE_ID_QUERY).list().get(0);
            session.createSQLQuery(UPDATE_LAST_SIGNATURE).setString("singature", signature).setInteger("id", id)
                    .executeUpdate();
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