package gospodarka.elektroniczna.dto.storehouse;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class PWDocument extends AbstractStoreHouseUser  implements Serializable {
	
	/**
	 * Kasia
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * Data przyjecia towarow
     */
    private Date receivedDate;
    /**
     * ilosc
     */
    private int amount;
    /**
     * kod towaru
     */
    private String itemCode;
    /**
     * nazwa towaru
     */
    private String itemName;
    /**
     * cena za sztuke
     */
    private float pricePerItem;
    
   
    
    /**
     * Konstruktor.
     */
    public PWDocument() {
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


	public Date getReceivedDate() {
		return receivedDate;
	}


	public int getAmount() {
		return amount;
	}


	public String getItemCode() {
		return itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public float getPricePerItem() {
		return pricePerItem;
	}


	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void setPricePerItem(float pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

   
}
