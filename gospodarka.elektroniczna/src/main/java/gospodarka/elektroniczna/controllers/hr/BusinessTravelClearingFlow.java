package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.BusinessTravelClearing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Rozliczenie podrózy służbowej
 * 
 * @author iblis
 *
 */
public class BusinessTravelClearingFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(BusinessTravelClearingFlow.class.getCanonicalName());

    public boolean submitBusinessTravelClearing(BusinessTravelClearing clearingBusinessTravel) {
        LOGGER.info("submitBusinessTravelClearing: " + clearingBusinessTravel);
        return true;
    }

    public List<BusinessTravelClearing> getBusinessTravelClearings() {
        ArrayList<BusinessTravelClearing> clearingBusinessTravels = new ArrayList<BusinessTravelClearing>();
        LOGGER.info("getBusinessTravelClearings: " + clearingBusinessTravels.size());
        return clearingBusinessTravels;
    }
}
