package gospodarka.elektroniczna.controllers.finance;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.finance.Invoice;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Wys³anie faktury
 *
 */
public class InvoiceFlow extends AbstractFinanceFlow<Invoice> implements Serializable {

    private static final long serialVersionUID = 1L;

    public InvoiceFlow() {
        super("Wys³anie faktury", DocumentTypes.INVOICE, Departments.FINANCE);
    }

    public boolean submitInvoice(UserData userData, Invoice invoice) {
        LoggerFactory.getLogger(InvoiceFlow.class).debug("submitInvoice", invoice);

        return submit(userData, invoice);
    }

    public List<Invoice> getInvoice() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.FINANCE);
        criteria.setType(DocumentTypes.INVOICE);

        List<Invoice> records = search(criteria);
        LoggerFactory.getLogger(InvoiceFlow.class).debug("getInvoice", records.size());

        return records;
    }
}
