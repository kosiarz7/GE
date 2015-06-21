/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.DefectiveElementForm;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dariusz
 */
public class DefectiveElementFlow extends AbstractManufactureFlow<DefectiveElementForm> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public DefectiveElementFlow() {
        super("Wadliwy element", DocumentTypes.DEFECTIVE_ELEMENT, Departments.SERVIS);
    }
    
    public boolean submitDefectiveElementForm(UserData user, DefectiveElementForm defectiveElement) {
        LoggerFactory.getLogger(DefectiveElementFlow.class).debug("submitDefectiveElement", defectiveElement);

        return submit(user, defectiveElement);
    }

    public List<DefectiveElementForm> getDefectiveElementForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.SERVIS);
        criteria.setType(DocumentTypes.DEFECTIVE_ELEMENT);

        List<DefectiveElementForm> records = search(criteria);
        LoggerFactory.getLogger(DefectiveElementFlow.class).debug("getDefectiveElementForms", records.size());
        return records;
    }
}
