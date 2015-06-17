package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;

public class Employee extends Client implements Serializable{
	
     private static final long serialVersionUID = 1L;
    
	private Integer id;
	
	public Employee() {
            super();
            this.id = 0;
            this.setAdress("Pracownik Salonu");
            this.setPhone("999999999");
        }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	};
	
}
