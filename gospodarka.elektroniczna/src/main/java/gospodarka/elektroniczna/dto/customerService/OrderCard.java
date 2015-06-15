package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrderCard extends AbstractCustomerServiceUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1216767815450969192L;

	private Client client;
	
	private Date orderDate;
	private String model;
	private Double engineSize;
	private String color;
	private String interior;
	private String transmission;
	private String equipmentVersion;
	private ArrayList<String> accessories;

	private Integer amount;
	private Double price;
	
	public OrderCard() {
	}

	public void init() {
		orderDate = new Date();
		client = new Client();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(Double engineSize) {
		this.engineSize = engineSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEquipmentVersion() {
		return equipmentVersion;
	}

	public void setEquipmentVersion(String equipmentVersion) {
		this.equipmentVersion = equipmentVersion;
	}

	public ArrayList<String> getAccessories() {
		return accessories;
	}

	public void setAccessories(ArrayList<String> accessories) {
		this.accessories = accessories;
	}

	public boolean addAccessories(String e) {
		return accessories.add(e);
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderCard [client=" + client + ", orderDate=" + orderDate
				+ ", model=" + model + ", engineSize=" + engineSize
				+ ", color=" + color + ", interior=" + interior
				+ ", transmission=" + transmission + ", equipmentVersion="
				+ equipmentVersion + ", accessories=" + accessories
				+ ", amount=" + amount + ", price=" + price + "]";
	}

}
