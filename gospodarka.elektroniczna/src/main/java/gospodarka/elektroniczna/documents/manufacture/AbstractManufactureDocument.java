/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.documents.manufacture;

import gospodarka.elektroniczna.documents.AbstractDocument;

/**
 *
 * @author Dariusz
 */
public abstract class AbstractManufactureDocument <T> extends AbstractDocument {
    
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
