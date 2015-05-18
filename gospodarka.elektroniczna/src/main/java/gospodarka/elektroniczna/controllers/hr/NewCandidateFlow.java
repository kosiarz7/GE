package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.NewCandidate;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Nowy kandydat
 * 
 * @author iblis
 *
 */
public class NewCandidateFlow extends AbstractHrFlow<NewCandidate> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Departments> departments = new ArrayList<Departments>();
    
    public NewCandidateFlow() {
        super("Nowy kandydat", DocumentTypes.NEW_CANDIDATE, Departments.HUMAN_RESOURCES);
        departments.add(Departments.CUSTOMER_SERVICE);
        departments.add(Departments.FINANCE);
        departments.add(Departments.HUMAN_RESOURCES);
        departments.add(Departments.MANUFACTURE);
        departments.add(Departments.SERVIS);
        departments.add(Departments.STOREHOUSE);
    }

    public boolean submitNewCandidate(UserData userData, NewCandidate newCandidate) {
        LoggerFactory.getLogger(NewCandidateFlow.class).debug("submitNewCandidate", newCandidate);

        return submit(userData, Departments.HUMAN_RESOURCES, newCandidate.getDepartment(), newCandidate);
    }

    public List<NewCandidate> getNewCandidate(Departments targetDepartment) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(targetDepartment);
        criteria.setType(DocumentTypes.NEW_CANDIDATE);

        List<NewCandidate> records = search(criteria);
        LoggerFactory.getLogger(NewCandidateFlow.class).debug("getNewCandidate", records.size());

        return records;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }
    
    
}
