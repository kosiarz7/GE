package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.hr.AbstractHrDocument;
import gospodarka.elektroniczna.dto.hr.CandidateRequest;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.slf4j.LoggerFactory;

/**
 * Informacja o wakacie
 * 
 * @author iblis
 *
 */
public class CandidateRequestFlow extends AbstractHrFlow<CandidateRequest>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	private Document<AbstractHrDocument<CandidateRequest>> selectedCandidateRequest;
	private List<Document<AbstractHrDocument<CandidateRequest>>> candidateRequests;

	public CandidateRequestFlow() {
		super("Zgłoszenie wakatu", DocumentTypes.CANDIDATE_REQUEST,
				Departments.HUMAN_RESOURCES);
	}

	public boolean submitCandidateRequest(UserData userData,
			CandidateRequest candidateRequest, Departments departments) {

		candidateRequest.setDepartment(departments);
		
		return submit(userData, candidateRequest);
	}

	public void loadCandidateRequest() {

		SearchCriteria criteria = new SearchCriteria();
		criteria.department(Departments.HUMAN_RESOURCES);
		criteria.setType(DocumentTypes.CANDIDATE_REQUEST);

		candidateRequests = search(criteria);
		LoggerFactory.getLogger(CandidateRequestFlow.class).debug(
				"getCandidateRequest", candidateRequests.size());

	}

	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		Object obj = event.getObject();
		selectedCandidateRequest = (Document<AbstractHrDocument<CandidateRequest>>) obj;
	}

	public boolean removeRequest(CandidateRequest candidateRequest) {
		throw new RuntimeException("trzeba by to zaimplementowac");
		//return true;
	}

	public Document<AbstractHrDocument<CandidateRequest>> getSelectedCandidateRequest() {
		return selectedCandidateRequest;
	}

	public void setSelectedCandidateRequest(
			Document<AbstractHrDocument<CandidateRequest>> selectedCandidateRequest) {
		this.selectedCandidateRequest = selectedCandidateRequest;
	}

	public List<Document<AbstractHrDocument<CandidateRequest>>> getCandidateRequests() {
		return candidateRequests;
	}

	public void setCandidateRequests(
			List<Document<AbstractHrDocument<CandidateRequest>>> candidateRequests) {
		this.candidateRequests = candidateRequests;
	}

	public void archiveCandidateRequest() {
		archiveDocument(selectedCandidateRequest);
		loadCandidateRequest();
	}
}
