/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.zam�wienie
 */
package gospodarka.elektroniczna.dto.manufacture;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Dariusz
 */
public class OrderForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Date deliveryDate;
    private String personPlacingAnOrder;
    private String elementName;
    private int amount;

    public OrderForm(){
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPersonPlacingAnOrder() {
        return personPlacingAnOrder;
    }

    public void setPersonPlacingAnOrder(String personPlacingAnOrder) {
        this.personPlacingAnOrder = personPlacingAnOrder;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
