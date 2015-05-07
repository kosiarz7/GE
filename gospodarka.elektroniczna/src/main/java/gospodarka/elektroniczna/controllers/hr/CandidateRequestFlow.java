package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.CandidateRequest;

import java.io.Serializable;

/**
 * Informacja o wakacie
 * @author iblis
 *
 */
public class CandidateRequestFlow implements Serializable
{

	private static final long serialVersionUID = 1L;

	public boolean submit(CandidateRequest candidateRequest)
	{
		return true;
	}
}
