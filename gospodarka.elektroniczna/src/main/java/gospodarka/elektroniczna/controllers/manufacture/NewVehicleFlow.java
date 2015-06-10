/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.MonthlySummaryOfProductionLine;
import gospodarka.elektroniczna.dto.manufacture.VehicleForm;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class NewVehicleFlow extends AbstractManufactureFlow<VehicleForm> implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public NewVehicleFlow() {
        super("Karta nowego pojazdu", DocumentTypes.NEW_VEHICLE, Departments.CUSTOMER_SERVICE);
    }
    
    public boolean submitVehicleForm(UserData user, VehicleForm vehicle) {
        return submit(user, vehicle);
    }

    public List<VehicleForm> getVehicleForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.CUSTOMER_SERVICE);
        criteria.setType(DocumentTypes.NEW_VEHICLE);

        List<VehicleForm> records = search(criteria);
        return records;
    }
}
