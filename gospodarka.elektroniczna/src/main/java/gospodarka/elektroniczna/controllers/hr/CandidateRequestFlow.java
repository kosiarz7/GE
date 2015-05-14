package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.hr.CandidateRequest;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Informacja o wakacie
 * 
 * @author iblis
 *
 */
public class CandidateRequestFlow extends AbstractHrFlow<CandidateRequest> implements Serializable {

    public CandidateRequestFlow() {
        super("Zgłoszenie wakatu", DocumentTypes.CANDIDATE_REQUEST, Departments.HUMAN_RESOURCES);
    }

    private static final long serialVersionUID = 1L;

    public boolean submitCandidateRequest(UserData userData, CandidateRequest candidateRequest) {
        LoggerFactory.getLogger(CandidateRequestFlow.class).debug("submitCandidateRequest", candidateRequest);

        return submit(userData, candidateRequest);
    }

    public List<CandidateRequest> getCandidateRequest() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.CANDIDATE_REQUEST);

        List<CandidateRequest> candidateRequests = search(criteria);
        LoggerFactory.getLogger(CandidateRequestFlow.class).debug("getCandidateRequest", candidateRequests.size());

        return candidateRequests;
    }

    public boolean removeRequest(CandidateRequest candidateRequest) {

        return true;
    }
}
