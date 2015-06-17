package gospodarka.elektroniczna.controllers.finance;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.finance.TrainingClearing;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Rozliczenie szkolenia
 * 
 * @author iblis
 *
 */
public class TrainingClearingFlow extends AbstractFinanceFlow<TrainingClearing> implements Serializable {

    private static final long serialVersionUID = 1L;

    public TrainingClearingFlow() {
        super("Rozliczenie szkolenia", DocumentTypes.TRAINING_CLEARING, Departments.HUMAN_RESOURCES);
    }
    
    public boolean submitClearingTraining(UserData user, TrainingClearing clearingTraining) {
        LoggerFactory.getLogger(TrainingClearingFlow.class).debug("submitClearingTraining", clearingTraining);

        return submit(user, clearingTraining);
    }

    public List<TrainingClearing> getTrainingClearings() {
        SearchCriteria criteria = new SearchCriteria();
       // criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.TRAINING_CLEARING);

        List<TrainingClearing> records = search(criteria);
        LoggerFactory.getLogger(TrainingClearingFlow.class).debug("getSickLeaves", records.size());
        return records;
    }
}
