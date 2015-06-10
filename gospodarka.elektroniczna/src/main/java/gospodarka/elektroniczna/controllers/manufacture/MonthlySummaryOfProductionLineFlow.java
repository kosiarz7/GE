/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.controllers.manufacture;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.manufacture.IndustrialAccidentForm;
import gospodarka.elektroniczna.dto.manufacture.MonthlySummaryOfProductionLine;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class MonthlySummaryOfProductionLineFlow  extends AbstractManufactureFlow<MonthlySummaryOfProductionLine> implements Serializable{
     private static final long serialVersionUID = 1L;

    public MonthlySummaryOfProductionLineFlow() {
        super("Miesięczne podsumowanie linii produkcyjnej", DocumentTypes.MONTHLY_SUMMARY_OF_PRODUCTION_LINE, Departments.MANUFACTURE);
    }
    
    public boolean submitMonthlySummaryForm(UserData user, MonthlySummaryOfProductionLine monthlySummary) {
        return submit(user, monthlySummary);
    }

    public List<MonthlySummaryOfProductionLine> getMonthlySummaryForms() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.MANUFACTURE);
        criteria.setType(DocumentTypes.MONTHLY_SUMMARY_OF_PRODUCTION_LINE);

        List<MonthlySummaryOfProductionLine> records = search(criteria);
        return records;
    }
}
