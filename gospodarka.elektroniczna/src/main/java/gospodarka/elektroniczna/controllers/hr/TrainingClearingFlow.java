package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dto.hr.TrainingClearing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Rozliczenie szkolenia
 * 
 * @author iblis
 *
 */
public class TrainingClearingFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    @InjectLogger
    private static final Logger LOGGER = Logger.getLogger(TrainingClearingFlow.class.getCanonicalName());

    public boolean submitClearingTraining(TrainingClearing clearingTraining) {
        LOGGER.info("submitClearingTraining: "+ clearingTraining);
        return true;
    }

    public List<TrainingClearing> getTrainingClearings() {
        
        ArrayList<TrainingClearing> trainings = new ArrayList<TrainingClearing>();
        LOGGER.info("getClearingTrainings: " + trainings.size());
        return trainings;
    }
}
