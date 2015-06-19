package gospodarka.elektroniczna.dto.hr;

import gospodarka.elektroniczna.dao.department.Departments;

import java.io.Serializable;

public class NewCandidate extends AbstractHrUser implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String experience;
    private Departments department;
    private String candidateName;
    private String candidateSurname;
    
    public NewCandidate() {

    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateSurname() {
		return candidateSurname;
	}

	public void setCandidateSurname(String candidateSurname) {
		this.candidateSurname = candidateSurname;
	}

   public String getCandidateNameAndSurname()
   {
	   return candidateName + " " + candidateSurname;
   }

    
}
