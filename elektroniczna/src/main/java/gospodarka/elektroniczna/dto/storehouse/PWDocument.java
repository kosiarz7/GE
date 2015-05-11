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
     * Data.
     */
    private Date date;
    /**
     * Liczba.
     */
    private int number;
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
     *  dzial
     */
    private String previousDepartment;
    
    
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


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


	public String getPreviousDepartment() {
		return previousDepartment;
	}


	public void setPreviousDepartment(String previousDepartment) {
		this.previousDepartment = previousDepartment;
	}


}
