package gospodarka.elektroniczna.controllers.finance;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.finance.InvoiceClearing;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Rozliczenie faktury
 * 
 * @author iblis
 *
 */
public class InvoiceClearingFlow extends AbstractFinanceFlow<InvoiceClearing> implements Serializable {

    private static final long serialVersionUID = 1L;

    public InvoiceClearingFlow() {
        super("Rozliczenie faktury", DocumentTypes.INVOICE_CLEARING, Departments.FINANCE);
    }

    public boolean submitInvoiceClearing(UserData userData, InvoiceClearing clearingInvoice) {
        LoggerFactory.getLogger(InvoiceClearingFlow.class).debug("submitInvoiceClearing", clearingInvoice);

        return submit(userData, clearingInvoice);
    }

    public List<InvoiceClearing> getInvoiceClearing() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.FINANCE);
        criteria.setType(DocumentTypes.INVOICE_CLEARING);

        List<InvoiceClearing> records = search(criteria);
        LoggerFactory.getLogger(InvoiceClearingFlow.class).debug("getInvoiceClearing", records.size());

        return records;
    }
}
