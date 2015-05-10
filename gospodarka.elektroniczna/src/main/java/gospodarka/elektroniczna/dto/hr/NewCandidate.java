package gospodarka.elektroniczna.dto.hr;

import gospodarka.elektroniczna.dao.department.Departments;

import java.io.Serializable;

public class NewCandidate implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String experience;
    private Departments department;

    public NewCandidate() {

    }

    public NewCandidate(String name, String surname, String experience, Departments department) {
        super();
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

}
