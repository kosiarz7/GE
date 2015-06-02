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

    @Override
    public String toString() {
        return "NewCandidate [experience=" + experience + ", department=" + department + ", getUserName()="
                + getUserName() + ", getUserSurname()=" + getUserSurname() + "]";
    }

    
}
