package gospodarka.elektroniczna.dto.storehouse;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class PWDocument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3196790204411637635L;
	
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
    private int itemName;
    /**
     * cena za sztuke
     */
    private String pricePerItem;
    
   
    
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

    // GETTERY I SETTERY
  
	public Date getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public int getItemName() {
		return itemName;
	}


	public void setItemName(int itemName) {
		this.itemName = itemName;
	}


	public String getPricePerItem() {
		return pricePerItem;
	}


	public void setPricePerItem(String pricePerItem) {
		this.pricePerItem = pricePerItem;
	}


}
