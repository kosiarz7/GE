/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.OrderForm;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class OrderFlow extends AbstractManufactureFlow<OrderForm> implements Serializable{
    private static final long serialVersionUID = 1L;

    public OrderFlow() {
        super("Zamówienie część", DocumentTypes.ORDER, Departments.STOREHOUSE);
    }
    
    public boolean submitOrderForm(UserData user, OrderForm order) {
        return submit(user, order);
    }

    public List<OrderForm> getOrderForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.STOREHOUSE);
        criteria.setType(DocumentTypes.ORDER);

        List<OrderForm> records = search(criteria);
        return records;
    }
}
