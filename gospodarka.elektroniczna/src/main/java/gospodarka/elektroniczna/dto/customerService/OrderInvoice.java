package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrderInvoice extends AbstractCustomerServiceUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3496258735760799637L;

	private Date sellDate;
	private Date documentDate;
	private Date paymentDate;
	
	private Client client;
	private Client seller;

	private ArrayList<Item> items;
	
	private Double totalValue;
	private Double paidValue;
	private Double notPaidValue;
	
	public OrderInvoice() {};
	
	public void init() {
		documentDate = new Date();
		client = new Client();
		seller = new Client();
		//uzupelnic dane zakladu i daty
		items = new ArrayList<Item>();
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getSeller() {
		return seller;
	}

	public void setSeller(Client seller) {
		this.seller = seller;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getPaidValue() {
		return paidValue;
	}

	public void setPaidValue(Double paidValue) {
		this.paidValue = paidValue;
	}

	public Double getNotPaidValue() {
		return notPaidValue;
	}

	public void setNotPaidValue(Double notPaidValue) {
		this.notPaidValue = notPaidValue;
	}

	public boolean addItem(Item e) {
		return items.add(e);
	}

	@Override
	public String toString() {
		return "OrderInvoice [sellDate=" + sellDate + ", documentDate="
				+ documentDate + ", paymentDate=" + paymentDate + ", client="
				+ client + ", seller=" + seller + ", items=" + items
				+ ", totalValue=" + totalValue + ", paidValue=" + paidValue
				+ ", notPaidValue=" + notPaidValue + "]";
	}
}
