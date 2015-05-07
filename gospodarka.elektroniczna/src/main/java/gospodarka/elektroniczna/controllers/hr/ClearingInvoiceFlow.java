package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dto.hr.ClearingInvoice;

import java.io.Serializable;

/**
 * Rozliczenie faktury
 * @author iblis
 *
 */
public class ClearingInvoiceFlow implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean submit(ClearingInvoice clearingInvoice)
	{
		return true;
	}
}
