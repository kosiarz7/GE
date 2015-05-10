package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dto.hr.CandidateRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Informacja o wakacie
 * 
 * @author iblis
 *
 */
public class CandidateRequestFlow implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private static final Logger LOGGER = Logger.getLogger(CandidateRequestFlow.class.getCanonicalName());

    public boolean submitCandidateRequest(CandidateRequest candidateRequest, Departments senderDepartment) {
        LOGGER.info("submitCandidateRequest: "+ candidateRequest);
        return true;
        /*
         * try { IDocumentService service = new DocumentService();
         * 
         * Document<CandidateRequest> document =
         * service.createDocument(DocumentTypes.INFORMACJA_O_WAKACIE,
         * "Wakat na stanowisko: " + candidateRequest.getJobName());
         * service.sendDocument(document, senderDepartment,
         * Departments.HUMAN_RESOURCES); return true; } catch
         * (WrongNumberOfLastSignatureException e) { // TODO Auto-generated
         * catch block e.printStackTrace(); return false; }
         */
    }

    public List<CandidateRequest> getCandidateRequest() {
        ArrayList<CandidateRequest> candidates = new ArrayList<CandidateRequest>();
        candidates.add(new CandidateRequest("Stazysta", "exp1a", "exp2a"));
        candidates.add(new CandidateRequest("Stanowisko1", "exp1b", "exp2b"));
        LOGGER.info("getNewCandidates: "+ candidates.size());
        return candidates;
    }

    public boolean removeRequest(CandidateRequest candidateRequest) {
        LOGGER.info("removeRequest: "+ candidateRequest);
        return true;
    }
}
