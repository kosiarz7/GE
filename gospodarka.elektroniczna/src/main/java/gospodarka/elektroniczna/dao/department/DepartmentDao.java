package gospodarka.elektroniczna.dao.department;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dao.CommonDao;
import gospodarka.elektroniczna.dto.DepartmentDto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;

/**
 * Implementacja DAO dla oddziałów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public class DepartmentDao extends CommonDao<DepartmentDto> implements IDepartmentDao, Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 7885389141220673431L;
    /**
     * Logger.
     */
    @InjectLogger
    private static final Logger LOGGER = null;

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public DepartmentDto getDepartment(final Departments department) {
        LOGGER.debug("getDepartment|Próba pobrania DTO dla oddziału: {}", department);
        Session session = openSession();
        Transaction tx = null;
        List<DepartmentDto> departments = null;
        
        try {
            tx = session.beginTransaction();
            departments = session.createQuery("from DepartmentDto where name = :name")
                    .setString("name", department.toString()).list();
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
        
        DepartmentDto departmentDto = null;
        if (departments.isEmpty()) {
            LOGGER.error("getDepartment|Brak rekordu w bazie dla oddziału o nazwie: {}", department);
            throw new IllegalArgumentException("Brak rekordu w bazie dla oddziału o nazwie: " + department);
        }
        else {
            departmentDto = departments.get(0);
            LOGGER.debug("getDepartment|Został pobrany obiekt: {} dla oodziału: {}", departmentDto, department);
        }
        
        return departmentDto;
    }
}