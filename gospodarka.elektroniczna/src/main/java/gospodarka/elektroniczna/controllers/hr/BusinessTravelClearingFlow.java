package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.BusinessTravelClearing;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Rozliczenie podrózy służbowej
 * 
 * @author iblis
 *
 */
public class BusinessTravelClearingFlow extends AbstractHrFlow<BusinessTravelClearing> implements Serializable {

    private static final long serialVersionUID = 1L;

    public BusinessTravelClearingFlow() {
        super("Rozliczenie podróży służbowej", DocumentTypes.BUSINESS_TRAVEL_CLEARING, Departments.FINANCE);
    }

    public boolean submitBusinessTravelClearing(UserData userData,
            BusinessTravelClearing clearingBusinessTravel) {

        LoggerFactory.getLogger(BusinessTravelClearingFlow.class).debug("submitBusinessTravelClearing",
                clearingBusinessTravel);

        return submit(userData, clearingBusinessTravel);
    }

    public List<BusinessTravelClearing> getBusinessTravelClearings() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.FINANCE);
        criteria.setType(DocumentTypes.BUSINESS_TRAVEL_CLEARING);

        List<BusinessTravelClearing> clearingBusinessTravels = search(criteria);
        LoggerFactory.getLogger(BusinessTravelClearingFlow.class).debug("getBusinessTravelClearings",
                clearingBusinessTravels.size());

        return clearingBusinessTravels;
    }

}
