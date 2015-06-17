package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;

public class Client implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
	protected String name; //imie i nazwisko lub nazwa firmy
	private String adress;
	private String phone;
	private String PIN; //pesel lub NIP

	public Client()  {
            PIN = "00000000000";
        }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}
	
	
}
