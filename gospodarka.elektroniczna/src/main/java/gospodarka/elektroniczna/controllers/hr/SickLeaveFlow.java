package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.SickLeave;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Zwolnienie chorobowe
 * 
 * @author iblis
 *
 */
public class SickLeaveFlow extends AbstractHrFlow<SickLeave>  implements Serializable {

    private static final long serialVersionUID = 1L;

    public SickLeaveFlow() {
        super("Zwolnienie lekarskie", DocumentTypes.SICK_LEAVE,
                Departments.HUMAN_RESOURCES);
    }
    
    public boolean submitSickLeave(UserData user, SickLeave sickLeave) {
        LoggerFactory.getLogger(SickLeaveFlow.class).debug("submitSickLeave", sickLeave);

        return submit(user, sickLeave);
    }

    public List<SickLeave> getSickLeaves() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.SICK_LEAVE);

        List<SickLeave> records = search(criteria);
        LoggerFactory.getLogger(HolidaysRequestFlow.class).debug("getSickLeaves", records.size());

        return records;
    }
}
