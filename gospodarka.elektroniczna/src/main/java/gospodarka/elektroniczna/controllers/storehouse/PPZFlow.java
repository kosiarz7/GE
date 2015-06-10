/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.PPZDocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;



/**
 * @author Kasia
 *
 */

public class PPZFlow  extends AbstractStoreHouseFlow<PPZDocument> implements  Serializable  {
	
	
	
	public PPZFlow() {
		super("Potwierdzenie przyjęcia zamówienia",  DocumentTypes.ORDER_CONFIRMATION, Departments.STOREHOUSE);
	}

	private static final long serialVersionUID = 1L;

	  public boolean submitPPZ(UserData userData, PPZDocument ppz) {
	    LoggerFactory.getLogger(PPZFlow.class).debug("submitPPZ", ppz);

	    return submit(userData, ppz);
		
	    }
	  
	  
	    public List<PPZDocument> getPPZDocuments() {

	        SearchCriteria criteria = new SearchCriteria();
	        criteria.department(Departments.STOREHOUSE);
	        criteria.setType(DocumentTypes.ORDER_CONFIRMATION);

	        List<PPZDocument> records = search(criteria);
	        LoggerFactory.getLogger(PZFlow.class).debug("getPPZDocuments", records.size());

	        return records;
	    }
}