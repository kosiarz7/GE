package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dto.hr.NewCandidate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Nowy kandydat
 * 
 * @author iblis
 *
 */
public class NewCandidateFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    @InjectLogger
    private static final Logger LOGGER = Logger.getLogger(NewCandidateFlow.class.getCanonicalName());

    public boolean submitNewCandidate(NewCandidate newCandidate) {
        LOGGER.info("submitNewCandidate: "+ newCandidate);
        return true;
    }
    
    public List<NewCandidate> getNewCandidate()
    {
        ArrayList<NewCandidate> newCandidates = new ArrayList<NewCandidate>();
        LOGGER.info("getNewCandidate: "+ newCandidates.size());
        return newCandidates;
    }
}
