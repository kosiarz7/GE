/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dto.storehouse.WWDocument;

import java.io.Serializable;

import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;



/**
 * @author Kasia
 *
 */

public class WWFlow  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public boolean submit( WWDocument ww) {
		  System.out.println("Dodano WYDANIE WEWNÊTRZNE");
		return true;
	}

	
}
