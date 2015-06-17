package gospodarka.elektroniczna.dto.customerService;

import gospodarka.elektroniczna.documents.service.Car;

import java.io.Serializable;
import java.util.Date;

public class TestDriveReport extends AbstractCustomerServiceUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6175407508578383601L;
	
	private Date dateTime;
	private Employee employee;
	private Car car;
	private Integer mileageBefore;
	private Integer mileageAfter;
	
	public TestDriveReport() {};
	
	public void init() {
                dateTime = new Date();
		employee = new Employee();
		car = new Car();
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getMileageBefore() {
		return mileageBefore;
	}

	public void setMileageBefore(Integer mileageBefore) {
		this.mileageBefore = mileageBefore;
	}

	public Integer getMileageAfter() {
		return mileageAfter;
	}

	public void setMileageAfter(Integer mileageAfter) {
		this.mileageAfter = mileageAfter;
	}

	@Override
	public String toString() {
		return "TestDriveReport [dateTime=" + dateTime + ", employee="
				+ employee + ", car=" + car + ", mileageBefore="
				+ mileageBefore + ", mileageAfter=" + mileageAfter + "]";
	}
	
}
