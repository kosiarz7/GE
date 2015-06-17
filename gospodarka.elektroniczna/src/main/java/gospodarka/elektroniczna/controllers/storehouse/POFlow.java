/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.PODocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;



/**
 * @author Kasia
 *
 */

public class POFlow  extends AbstractStoreHouseFlow<PODocument> implements  Serializable  {
	
	
	
	public POFlow() {
		super("Zlecenie produkcji",  DocumentTypes.PRODUCTION_ORDER, Departments.MANUFACTURE);
	}

	private static final long serialVersionUID = 1L;

	  public boolean submitPO(UserData userData, PODocument ppz) {
	    LoggerFactory.getLogger(POFlow.class).debug("submitPO", ppz);

	    return submit(userData, ppz);
		
	    }
	
	   public List<PODocument> getPODocuments() {

	        SearchCriteria criteria = new SearchCriteria();
	        criteria.department(Departments.MANUFACTURE);
	        criteria.setType(DocumentTypes.PRODUCTION_ORDER);

	        List<PODocument> records = search(criteria);
	        LoggerFactory.getLogger(PZFlow.class).debug("getPODocuments", records.size());

	        return records;
	    }
	    
	   
}