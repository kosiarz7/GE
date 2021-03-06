/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dto.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import java.io.Serializable;

/**
 *
 * @author Dariusz
 */
public abstract class AbstractManufactureUser implements Serializable {
       
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
