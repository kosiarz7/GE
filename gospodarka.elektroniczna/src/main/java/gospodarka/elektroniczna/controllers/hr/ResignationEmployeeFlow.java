package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.ResignationEmployee;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Wypowiedzenie z pracy - pracownik
 * 
 * @author iblis
 *
 */
public class ResignationEmployeeFlow extends AbstractHrFlow<ResignationEmployee> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResignationEmployeeFlow() {
        super("Wypowiedzenie z pracy ze strony pracownika", DocumentTypes.RESIGNATION_EMPLOYEE, Departments.HUMAN_RESOURCES);
    }
    

    public boolean submitResignationEmployee(UserData userData, ResignationEmployee resignationEmployee) {
        LoggerFactory.getLogger(ResignationEmployeeFlow.class).debug("submitResignationEmployee", resignationEmployee);

        return submit(userData, resignationEmployee);
    }

    public List<ResignationEmployee> getResignationEmployees() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.RESIGNATION_EMPLOYEE);

        List<ResignationEmployee> records = search(criteria);
        LoggerFactory.getLogger(ResignationEmployeeFlow.class).debug("getResignationEmployees", records.size());

        return records;
    }
}
