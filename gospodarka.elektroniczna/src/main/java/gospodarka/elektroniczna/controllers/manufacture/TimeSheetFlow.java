/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.OrderForm;
import gospodarka.elektroniczna.dto.manufacture.TimeSheetForm;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class TimeSheetFlow extends AbstractManufactureFlow<TimeSheetForm> implements Serializable{
    private static final long serialVersionUID = 1L;

    public TimeSheetFlow() {
        super("Karta pracy pracownika", DocumentTypes.TIME_SHEET, Departments.HUMAN_RESOURCES);
    }
    
    public boolean submitTimeSheetForm(UserData user, TimeSheetForm timeSheet) {
        return submit(user, timeSheet);
    }

    public List<TimeSheetForm> getTimeSheetForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.STOREHOUSE);
        criteria.setType(DocumentTypes.ORDER);

        List<TimeSheetForm> records = search(criteria);
        return records;
    }
}
