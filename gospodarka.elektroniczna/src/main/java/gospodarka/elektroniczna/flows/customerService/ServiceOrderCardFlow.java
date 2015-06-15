package gospodarka.elektroniczna.flows.customerService;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.customerService.ServiceOrderCard;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

public class ServiceOrderCardFlow extends AbstractCustomerServiceFlow<ServiceOrderCard> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8446292172496356914L;

	public ServiceOrderCardFlow() {
		 super("Zamówienie us³ugi serwisowej", DocumentTypes.SERVICE_ORDER_CARD, Departments.SERVIS);
	}
	
	public boolean submitServiceOrderCard(UserData userData,
           ServiceOrderCard serviceOrderCard) {

       LoggerFactory.getLogger(ServiceOrderCardFlow.class).debug("submitServiceOrderCard",
               serviceOrderCard);

       return submit(userData, serviceOrderCard);
   }

   public List<ServiceOrderCard> getServiceOrderCards() {

       SearchCriteria criteria = new SearchCriteria();
       criteria.department(Departments.SERVIS);
       criteria.setType(DocumentTypes.SERVICE_ORDER_CARD);

       List<ServiceOrderCard> serviceOrderCards = search(criteria);
       LoggerFactory.getLogger(ServiceOrderCard.class).debug("getOrderInvoices",
               serviceOrderCards.size());

       return serviceOrderCards;
   }
}
