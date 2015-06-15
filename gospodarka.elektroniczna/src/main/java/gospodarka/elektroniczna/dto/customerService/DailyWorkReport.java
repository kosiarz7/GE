package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DailyWorkReport extends AbstractCustomerServiceUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2255396073131433657L;
	
	private Date date;
	private ArrayList<Employee> employees;
	private ArrayList<OrderCard> orders;
	private ArrayList<TestDriveReport> testDrives;
	private Double income;
	
	public DailyWorkReport() {}

	public void init() {
		date = new Date();
		employees = new ArrayList<Employee>();
		orders = new ArrayList<OrderCard>();
		testDrives = new ArrayList<TestDriveReport>();
		
		//pobrac dane
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<OrderCard> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<OrderCard> orders) {
		this.orders = orders;
	}

	public ArrayList<TestDriveReport> getTestDrives() {
		return testDrives;
	}

	public void setTestDrives(ArrayList<TestDriveReport> testDrives) {
		this.testDrives = testDrives;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "DailyWorkReport [date=" + date + ", employees=" + employees
				+ ", orders=" + orders + ", testDrives=" + testDrives
				+ ", income=" + income + "]";
	}
	
	
}
