package gospodarka.elektroniczna.dao.department;

import gospodarka.elektroniczna.dto.DepartmentDto;

/**
 * DAO dla oddziałów.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
public interface IDepartmentDao {
    /**
     * Zwraca DTO dla oddziału.
     * 
     * @param department żądany dział.
     * @return DTO żądanego działu.
     */
    DepartmentDto getDepartment(final Departments department);
}
