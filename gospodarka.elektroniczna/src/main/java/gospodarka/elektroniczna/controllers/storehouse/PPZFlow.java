/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dto.storehouse.PPZDocument;

import java.io.Serializable;



/**
 * @author Kasia
 *
 */

public class PPZFlow implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean submit( PPZDocument ppz) {
		  System.out.println("Dodano PPZ");
		return true;
	}
	
}
