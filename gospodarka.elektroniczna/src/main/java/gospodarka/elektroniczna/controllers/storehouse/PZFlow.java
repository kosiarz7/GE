/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dto.storehouse.PZDocument;

import java.io.Serializable;



/**
 * @author Kasia
 *
 */

public class PZFlow implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean submit( PZDocument pz) {
		  System.out.println("Dodano PZ");
		return true;
	}
	
}
