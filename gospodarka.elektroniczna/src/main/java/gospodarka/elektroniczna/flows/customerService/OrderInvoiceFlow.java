package gospodarka.elektroniczna.flows.customerService;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.customerService.OrderInvoice;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

public class OrderInvoiceFlow extends AbstractCustomerServiceFlow<OrderInvoice> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7988890379308158339L;

	public OrderInvoiceFlow() {
		 super("Faktura do zamówienia", DocumentTypes.ORDER_INVOICE, Departments.FINANCE);
	}
	
	public boolean submitOrderInvoice(UserData userData,
            OrderInvoice orderInvoice) {

        LoggerFactory.getLogger(OrderInvoiceFlow.class).debug("submitOrderInvoice",
                orderInvoice);

        return submit(userData, orderInvoice);
    }

    public List<OrderInvoice> getOrderInvoices() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.FINANCE);
        criteria.setType(DocumentTypes.ORDER_INVOICE);

        List<OrderInvoice> orderInvoices = search(criteria);
        LoggerFactory.getLogger(OrderInvoice.class).debug("getOrderInvoices",
                orderInvoices.size());

        return orderInvoices;
    }

}
