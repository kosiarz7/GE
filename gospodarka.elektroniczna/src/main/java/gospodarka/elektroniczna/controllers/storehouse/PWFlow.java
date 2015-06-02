/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.PWDocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;



/**
 * @author Kasia
 *
 */

public class PWFlow  extends AbstractStoreHouseFlow<PWDocument> implements  Serializable  {
	
	
	
	public PWFlow() {
		super("Przyjêcie wewnêtrzne",  DocumentTypes.INTERNAL_ADOPTION, Departments.STOREHOUSE);
	}

	private static final long serialVersionUID = 1L;

	  public boolean submitPW(UserData userData, PWDocument ppz) {
	    LoggerFactory.getLogger(PWFlow.class).debug("submitPW", ppz);

	    return submit(userData, ppz);
		
	    }
	  
	  
	    public List<PWDocument> getPWDocuments() {

	        SearchCriteria criteria = new SearchCriteria();
	        criteria.department(Departments.STOREHOUSE);
	        criteria.setType(DocumentTypes.INTERNAL_ADOPTION);

	        List<PWDocument> records = search(criteria);
	        LoggerFactory.getLogger(PWFlow.class).debug("getPWDocuments", records.size());

	        return records;
	    }
}
