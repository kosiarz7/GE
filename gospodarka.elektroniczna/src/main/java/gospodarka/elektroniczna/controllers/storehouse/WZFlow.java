/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.WZDocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;



/**
 * @author Kasia
 *
 */

public class WZFlow   extends AbstractStoreHouseFlow<WZDocument> implements  Serializable  {
	
	
	
	public WZFlow() {
		super("Wydanie zewnêtrzne",  DocumentTypes.EXTERNAL_ISSUE, Departments.STOREHOUSE);
	}

	private static final long serialVersionUID = 1L;

	  public boolean submitWZ(UserData userData, WZDocument pz) {
	    LoggerFactory.getLogger(WZFlow.class).debug("submitWZ", pz);

	    return submit(userData, pz);
		
	    }	  
	  
	    public List<WZDocument> getWZDocuments() {

	        SearchCriteria criteria = new SearchCriteria();
	        criteria.department(Departments.STOREHOUSE);
	        criteria.setType(DocumentTypes.EXTERNAL_ISSUE);

	        List<WZDocument> records = search(criteria);
	        LoggerFactory.getLogger(WZFlow.class).debug("getWZDocuments", records.size());

	        return records;
	    }
}