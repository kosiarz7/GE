package gospodarka.elektroniczna.dto.storehouse;

import java.io.Serializable;



public class WWDocument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5931639035642495299L;


   
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
  /*  public WWDocument() {
    }
    */
    
    /**
     * {@inheritDoc}
     */
/*    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
*/
 

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
