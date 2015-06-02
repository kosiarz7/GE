/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.PZDocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author Kasia
 *
 */

public class PZFlow  extends AbstractStoreHouseFlow<PZDocument> implements  Serializable  {
	
	
	
	public PZFlow() {
		super("Przyjecie zewnêtrzne",  DocumentTypes.EXTERNAL_ADOPTION, Departments.STOREHOUSE);
	}

	private static final long serialVersionUID = 1L;

	  public boolean submitPZ(UserData userData, PZDocument pz) {
	    LoggerFactory.getLogger(PZFlow.class).debug("submitPZ", pz);

	    return submit(userData, pz);
		
	    }
	  
	  
	    public List<PZDocument> getPZDocuments() {

	        SearchCriteria criteria = new SearchCriteria();
	        criteria.department(Departments.STOREHOUSE);
	        criteria.setType(DocumentTypes.EXTERNAL_ADOPTION);

	        List<PZDocument> records = search(criteria);
	        LoggerFactory.getLogger(PZFlow.class).debug("getPZDocuments", records.size());

	        return records;
	    }
}
