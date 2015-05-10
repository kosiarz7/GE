package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;

public class CandidateRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String jobName;
	private String requiredExperience;
	private String goodToKnownExperience;

	public CandidateRequest() {
	}

	public CandidateRequest(String jobName, String requiredExperience,
			String goodToKnownExperience) {
		super();
		this.jobName = jobName;
		this.requiredExperience = requiredExperience;
		this.goodToKnownExperience = goodToKnownExperience;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public String getGoodToKnownExperience() {
		return goodToKnownExperience;
	}

	public void setGoodToKnownExperience(String goodToKnownExperience) {
		this.goodToKnownExperience = goodToKnownExperience;
	}

}
