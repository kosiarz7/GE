package gospodarka.elektroniczna.dto.finance;

import java.io.Serializable;
import java.util.Date;

public class Invoice extends AbstractFinanceUser implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Invoice() {
	    super();
    }

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
	}

	public Date getArchiveDate() {
	    return archiveDate;
    }

	public void setArchiveDate(Date archiveDate) {
	    this.archiveDate = archiveDate;
    }

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public int getSellerVATIN() {
	    return sellerVATIN;
    }

	public void setSellerVATIN(int sellerVATIN) {
	    this.sellerVATIN = sellerVATIN;
    }

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public int getBuyerVATIN() {
	    return buyerVATIN;
    }

	public void setBuyerVATIN(int buyerVATIN) {
	    this.buyerVATIN = buyerVATIN;
    }

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getCostNetto() {
		return costNetto;
	}

	public void setCostNetto(double costNetto) {
		this.costNetto = costNetto;
	}

	public double getCostBrutto() {
		return costBrutto;
	}

	public void setCostBrutto(double costBrutto) {
		this.costBrutto = costBrutto;
	}

	@Override
    public String toString() {
	    return "Invoice [invoiceNumber=" + invoiceNumber + ", createDate="
	            + createDate + ", supplyDate=" + supplyDate + ", archiveDate="
	            + archiveDate + ", sellerName=" + sellerName
	            + ", sellerAddress=" + sellerAddress + ", sellerVATIN="
	            + sellerVATIN + ", buyerName=" + buyerName + ", buyerAddress="
	            + buyerAddress + ", buyerVATIN=" + buyerVATIN + ", product="
	            + product + ", amount=" + amount + ", vat=" + vat
	            + ", costNetto=" + costNetto + ", costBrutto=" + costBrutto
	            + "]";
    }

	private int invoiceNumber;
	private Date createDate;
	private Date supplyDate;
	private Date archiveDate;
	private String sellerName;
	private String sellerAddress;
	private int sellerVATIN;
	private String buyerName;
	private String buyerAddress;
	private int buyerVATIN;
    private String product;
    private double amount;
    private double vat;
    private double costNetto;
    private double costBrutto;

}
