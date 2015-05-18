package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.ResignationEmployer;

import java.io.Serializable;

/**
 * Wypowiedzenie z pracy - pracodawca
 * 
 * @author iblis
 *
 */
public class ResignationEmployerFlow extends AbstractHrFlow<ResignationEmployer> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResignationEmployerFlow() {
        super("Wypowiedzenie z pracy ze strony pracodawcy", DocumentTypes.RESIGNATION_EMPLOYER,
                Departments.HUMAN_RESOURCES);
    }
/*
    public boolean submitHolidaysRequest(Departments targetDepartment, ResignationEmployer resignationEmployer) {
        LoggerFactory.getLogger(CandidateRequestFlow.class).debug("submitCandidateRequest", resignationEmployer);

        return submit(Departments.HUMAN_RESOURCES, targetDepartment, resignationEmployer);
    }

    public List<ResignationEmployer> getResignationEmployers(Departments targetDepartment) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(targetDepartment);
        criteria.setType(DocumentTypes.RESIGNATION_EMPLOYER);

        List<ResignationEmployer> records = search(criteria);
        LoggerFactory.getLogger(HolidaysRequestFlow.class).debug("getResignationEmployers", records.size());

        return records;
    }
    */
}
