package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;

/**
 *
 * @author Patryk
 */
public class Item implements Serializable {

     private static final long serialVersionUID = 1L;
    
	private Integer id;
	private String name;
	private String unit;
	private Integer amount;
	private Double value;
	
	public Item() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
