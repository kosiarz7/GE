package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.ClearingTraining;

import java.io.Serializable;

/**
 * Rozliczenie szkolenia
 * 
 * @author iblis
 *
 */
public class ClearingTrainingFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean submit(ClearingTraining clearingTraining)
	{
		return true;
	}
}
