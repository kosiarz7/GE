package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;

import gospodarka.elektroniczna.dao.department.Departments;

public abstract class AbstractHrUser implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String userSurname;
    private Departments department;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
    
    public String getUserNameAndSurname()
    {
        return userName + " "+ userSurname;
    }
}
