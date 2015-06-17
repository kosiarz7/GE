package gospodarka.elektroniczna.flows.customerService;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.customerService.OrderCard;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

public class OrderCardFlow extends AbstractCustomerServiceFlow<OrderCard> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321714249279199807L;

	public OrderCardFlow() {
		 super("Zamowienie pojazdu (konfigurator)", DocumentTypes.ORDER_CARD, Departments.STOREHOUSE);
	}
	
	public boolean submitOrderCard(UserData userData,
           OrderCard orderCard) {

       LoggerFactory.getLogger(OrderCardFlow.class).info("submitOrderCard",
               orderCard);

       return submit(userData, orderCard);
   }

   public List<OrderCard> getOrderCards() {

       SearchCriteria criteria = new SearchCriteria();
       criteria.department(Departments.STOREHOUSE);
       criteria.setType(DocumentTypes.ORDER_CARD);

       List<OrderCard> orderCards = search(criteria);
       LoggerFactory.getLogger(OrderCard.class).debug("getOrderCards",
               orderCards.size());

       return orderCards;
   }
}
