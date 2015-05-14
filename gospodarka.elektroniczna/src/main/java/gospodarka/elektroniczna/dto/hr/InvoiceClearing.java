package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

public class InvoiceClearing extends AbstractHrUser implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String products;
    private double amount;
    private Date date;

    public InvoiceClearing() {
    }

    public InvoiceClearing(String products, double amount, Date date) {
        super();
        this.products = products;
        this.amount = amount;
        this.date = date;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InvoiceClearing [products=" + products + ", amount=" + amount + ", date=" + date + ", getUserName()="
                + getUserName() + ", getUserSurname()=" + getUserSurname() + ", getDepartment()=" + getDepartment()
                + "]";
    }

}
