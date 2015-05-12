/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dto.storehouse.PWDocument;

import java.io.Serializable;



/**
 * @author Kasia
 *
 */

public class PWFlow implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean submit( PWDocument pw) {
		  System.out.println("Dodano PW");
		return true;
	}
	
}
