package gospodarka.elektroniczna.dto.storehouse;

import java.io.Serializable;

public class PODocument extends AbstractStoreHouseUser  implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    /**
     * Nr zamowienia
     */
    private int orderNumber;
    private String osobaSkladajacaZam;
    private String nazwaProduktu;
    private int sztuk;
    
	public PODocument() {
		
		// TODO Auto-generated constructor stub
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getOsobaSkladajacaZam() {
		return osobaSkladajacaZam;
	}

	public String getNazwaProduktu() {
		return nazwaProduktu;
	}

	public int getSztuk() {
		return sztuk;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setOsobaSkladajacaZam(String osobaSkladajacaZam) {
		this.osobaSkladajacaZam = osobaSkladajacaZam;
	}

	public void setNazwaProduktu(String nazwaProduktu) {
		this.nazwaProduktu = nazwaProduktu;
	}

	public void setSztuk(int sztuk) {
		this.sztuk = sztuk;
	}
     
  
  
    
    // GETTERY I SETTERY
    
 
}
