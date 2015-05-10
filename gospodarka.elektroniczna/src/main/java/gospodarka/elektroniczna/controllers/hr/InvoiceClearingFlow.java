package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dto.hr.InvoiceClearing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Rozliczenie faktury
 * 
 * @author iblis
 *
 */
public class InvoiceClearingFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    @InjectLogger
    private static final Logger LOGGER = Logger.getLogger(InvoiceClearingFlow.class.getCanonicalName());

    public boolean submitInvoiceClearing(InvoiceClearing clearingInvoice) {
        LOGGER.info("submitInvoiceClearing: "+ clearingInvoice);
        return true;
    }
    
    public List<InvoiceClearing> getInvoiceClearing()
    {
        ArrayList<InvoiceClearing> invoiceClearing = new ArrayList<InvoiceClearing>();
        LOGGER.info("getInvoiceClearing: "+ invoiceClearing.size());
        return invoiceClearing;
    }
}
