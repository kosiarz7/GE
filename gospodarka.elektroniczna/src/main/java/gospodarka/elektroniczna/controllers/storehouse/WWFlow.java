/**
 * 
 */
package gospodarka.elektroniczna.controllers.storehouse;


import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.storehouse.PZDocument;
import gospodarka.elektroniczna.dto.storehouse.WWDocument;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;


/**
 * @author Kasia
 *
 */

public class WWFlow extends AbstractStoreHouseFlow<WWDocument> implements  Serializable {

			public WWFlow() {
				super("Wydanie wewnêtrzne",  DocumentTypes.INTERNAL_ISSUE, Departments.STOREHOUSE);
			}

			private static final long serialVersionUID = 1L;

			  public boolean submitWW(UserData userData, WWDocument pz) {
			    LoggerFactory.getLogger(WWFlow.class).debug("submitWW", pz);

			    return submit(userData, pz);
				
			    }
			  
			  
			    public List<WWDocument> getWWDocuments() {

			        SearchCriteria criteria = new SearchCriteria();
			        criteria.department(Departments.STOREHOUSE);
			        criteria.setType(DocumentTypes.INTERNAL_ISSUE);

			        List<WWDocument> records = search(criteria);
			        LoggerFactory.getLogger(WWFlow.class).debug("getWWDocuments", records.size());

			        return records;
			    
		}

	
}
