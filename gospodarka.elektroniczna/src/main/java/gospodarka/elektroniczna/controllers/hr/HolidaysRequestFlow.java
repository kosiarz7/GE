package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.HolidaysRequest;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Wniosek o urlop
 * 
 * @author iblis
 *
 */
public class HolidaysRequestFlow extends AbstractHrFlow<HolidaysRequest> implements Serializable {

    private static final long serialVersionUID = 1L;

    public HolidaysRequestFlow() {
        super("Wniose o urlop", DocumentTypes.HOLIDAYS_REQUEST, Departments.HUMAN_RESOURCES);
    }

    public boolean submitHolidaysRequest(UserData userData, HolidaysRequest holidayRequest) {
        LoggerFactory.getLogger(CandidateRequestFlow.class).debug("submitCandidateRequest", holidayRequest);

        return submit(userData, holidayRequest);
    }

    public List<HolidaysRequest> getHolidaysRequests() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.HOLIDAYS_REQUEST);

        List<HolidaysRequest> records = search(criteria);
        LoggerFactory.getLogger(HolidaysRequestFlow.class).debug("getHolidaysRequests", records.size());

        return records;
    }
}
