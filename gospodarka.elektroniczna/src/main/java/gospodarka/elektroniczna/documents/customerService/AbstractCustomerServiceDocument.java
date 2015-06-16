package gospodarka.elektroniczna.documents.customerService;

import gospodarka.elektroniczna.documents.AbstractDocument;

public class AbstractCustomerServiceDocument<T> extends AbstractDocument {
	private static final long serialVersionUID = 1L;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		if (data == null) {
			return this.getClass().getCanonicalName() + ": null";
		}
		return this.getClass().getCanonicalName() + ": " + data.toString();
	}
}
