package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.NewCandidate;

import java.io.Serializable;

/**
 * Nowy kandydat
 * @author iblis
 *
 */
public class NewCandidateFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean submit(NewCandidate newCandidate)
	{
		return true;
	}
}
