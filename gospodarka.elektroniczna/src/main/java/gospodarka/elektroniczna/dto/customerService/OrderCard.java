package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;

public class OrderCard extends AbstractCustomerServiceUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1216767815450969192L;
        
        public enum InteriorType {
		Basic("Basic"),
		Elegance("Elegance"),
		Sporting("Sporting"),
		SuperMegaHiperExtra("SuperMegaHiperExtra");
		private String label;
		InteriorType(String label) {
			this.label = label;
		}
	    public String getLabel() {
	    	return label;
	    }
	}
        
            public enum TransmissionType {
		Manualna("Manualna 6 biegowa"),
		Automatyczna("Automatyczna");
		private String label;
		TransmissionType(String label) {
			this.label = label;
		}
	    public String getLabel() {
	    	return label;
	    }
	}
        
	private Client client;
	
	private Date orderDate;
	private String model;
	private Double engineSize;
	private String color;
	private String interior;
	private String transmission;
	private Integer amount;

	
	public OrderCard() {
	}
        
        @PostConstruct
	public void init() {
		orderDate = new Date();
		client = new Client();
                amount = 1;
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

        public InteriorType[] getInteriorTypeList() {
		return InteriorType.values();
	}
        
        public TransmissionType[] getTransmissionTypeList() {
		return TransmissionType.values();
	}
        
	@Override
	public String toString() {
		return "OrderCard [client=" + client + ", orderDate=" + orderDate
				+ ", model=" + model + ", engineSize=" + engineSize
				+ ", color=" + color + ", interior=" + interior
				+ ", transmission=" + transmission + ", equipmentVersion=";
	}

}
