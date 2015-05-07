package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.ClearingBusinessTravel;

import java.io.Serializable;

/**
 * Rozliczenie podrózy służbowej
 * @author iblis
 *
 */
public class ClearingBusinessTravelFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean submit(ClearingBusinessTravel clearingBusinessTravel)
	{
		return true;
	}
}
