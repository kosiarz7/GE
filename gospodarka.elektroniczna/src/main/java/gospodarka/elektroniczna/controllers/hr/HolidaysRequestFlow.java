package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dto.hr.HolidayRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Wniosek o urlop
 * 
 * @author iblis
 *
 */
public class HolidaysRequestFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    @InjectLogger
    private static final Logger LOGGER = Logger.getLogger(HolidaysRequestFlow.class.getCanonicalName());

    public boolean submitHolidayRequest(final HolidayRequest holidayRequest) {
        LOGGER.info("submitHolidayRequest: "+ holidayRequest);
        return true;
    }
    
    public List<HolidayRequest> getHolidayRequests()
    {
        ArrayList<HolidayRequest> holidayRequests = new ArrayList<HolidayRequest>();
        LOGGER.info("getHolidayRequests: "+ holidayRequests.size());
        return holidayRequests;
    }
}
