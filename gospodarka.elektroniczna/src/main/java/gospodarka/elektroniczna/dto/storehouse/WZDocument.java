package gospodarka.elektroniczna.dto.storehouse;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;



public class WZDocument  extends AbstractStoreHouseUser  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    /**
     * Data wydania towaru
     */
    private Date releaseDate;
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
     * klient nazwisko
     */
    private String customer;

        
    /**
     * Konstruktor.
     */
  public WZDocument() {
    }
 
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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



	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public float getPricePerItem() {
		return pricePerItem;
	}


	public void setPricePerItem(float pricePerItem) {
		this.pricePerItem = pricePerItem;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}





}
