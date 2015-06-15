package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;

import gospodarka.elektroniczna.dao.department.Departments;

public abstract class AbstractCustomerServiceUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6354160283700217446L;
		
	private String userName;
	private String userSurname;
	private Departments department;
	
	public AbstractCustomerServiceUser() {}

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
	};
	
}
