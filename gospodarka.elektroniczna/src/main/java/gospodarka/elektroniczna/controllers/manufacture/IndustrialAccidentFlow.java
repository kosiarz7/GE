/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.IndustrialAccidentForm;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class IndustrialAccidentFlow extends AbstractManufactureFlow<IndustrialAccidentForm> implements Serializable{
    
 private static final long serialVersionUID = 1L;

    public IndustrialAccidentFlow() {
        super("Wypadek przy pracy", DocumentTypes.INDUSTRIAL_ACCIDENT, Departments.HUMAN_RESOURCES);
    }
    
    public boolean submitIndustrialAccidentForm(UserData user, IndustrialAccidentForm industrialAccident) {
        return submit(user, industrialAccident);
    }

    public List<IndustrialAccidentForm> getIndustrialAccidentForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.INDUSTRIAL_ACCIDENT);

        List<IndustrialAccidentForm> records = search(criteria);
        return records;
    }
}