package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.HolidayRequest;

import java.io.Serializable;

/**
 * Wniosek o urlop
 * 
 * @author iblis
 *
 */
public class HolidaysRequestFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean submit(final HolidayRequest holidayRequest) {
		return true;
	}
}
