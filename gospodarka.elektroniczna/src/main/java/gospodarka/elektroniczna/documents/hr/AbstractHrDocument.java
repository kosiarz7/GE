package gospodarka.elektroniczna.documents.hr;

import gospodarka.elektroniczna.documents.AbstractDocument;

public abstract class AbstractHrDocument<T> extends AbstractDocument {

    private static final long serialVersionUID = 1L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public String toString()
    {
        if (data == null)
        {
            return this.getClass().getCanonicalName() + ": null";
        }
        return this.getClass().getCanonicalName() + ": " + data.toString();
    }
}
