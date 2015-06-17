package gospodarka.elektroniczna.dto.customerService;

import gospodarka.elektroniczna.documents.service.Car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ServiceOrderCard extends AbstractCustomerServiceUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4572431254635208519L;

	private Date serviceOrderDate;
	private Client client;
	private Client service;
	private Car car;
	private String todo;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

	
	public ServiceOrderCard() {};
	
	public void init() {
		serviceOrderDate = new Date();
		client = new Client();
		service = new Client();
		car = new Car();
	}
	
	public Date getServiceOrderDate() {
		return serviceOrderDate;
	}
	public void setServiceOrderDate(Date serviceOrderDate) {
		this.serviceOrderDate = serviceOrderDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Client getService() {
		return service;
	}
	public void setService(Client service) {
		this.service = service;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
        
	@Override
	public String toString() {
		return "ServiceOrderCard [serviceOrderDate=" + serviceOrderDate
				+ ", client=" + client + ", service=" + service + ", car="
				+ car + ", todo=" + todo + "]";
	}
}
