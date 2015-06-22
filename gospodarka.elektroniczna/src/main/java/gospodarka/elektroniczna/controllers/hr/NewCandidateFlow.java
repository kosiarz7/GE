package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.hr.AbstractHrDocument;
import gospodarka.elektroniczna.dto.hr.NewCandidate;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.slf4j.LoggerFactory;

/**
 * Nowy kandydat
 * 
 * @author iblis
 *
 */
public class NewCandidateFlow extends AbstractHrFlow<NewCandidate> implements Serializable {

    private static final long serialVersionUID = 1L;
	private Document<AbstractHrDocument<NewCandidate>> selectedNewCandidate;
	private List<Document<AbstractHrDocument<NewCandidate>>> newCandidates;
    
    private List<Departments> departments = new ArrayList<Departments>();
    private Departments targetDepartment;
    
    public NewCandidateFlow() {
        super("Nowy kandydat", DocumentTypes.NEW_CANDIDATE, Departments.HUMAN_RESOURCES);
        departments.add(Departments.CUSTOMER_SERVICE);
        departments.add(Departments.FINANCE);
        departments.add(Departments.HUMAN_RESOURCES);
        departments.add(Departments.MANUFACTURE);
        departments.add(Departments.SERVIS);
        departments.add(Departments.STOREHOUSE);
    }

    public boolean submitNewCandidate(UserData userData, NewCandidate newCandidate) {
        LoggerFactory.getLogger(NewCandidateFlow.class).debug("submitNewCandidate", newCandidate);
        return submit(userData, Departments.HUMAN_RESOURCES, newCandidate.getDepartment(), newCandidate);
    }

    public void loadNewCandidates(Departments targetDepartment) {
    	this.targetDepartment = targetDepartment;
        SearchCriteria criteria = new SearchCriteria();
        criteria.department(targetDepartment);
        criteria.setType(DocumentTypes.NEW_CANDIDATE);

        newCandidates = search(criteria);
        LoggerFactory.getLogger(NewCandidateFlow.class).debug("getNewCandidate", newCandidates.size());

    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }
    
	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		Object obj = event.getObject();
		selectedNewCandidate = (Document<AbstractHrDocument<NewCandidate>>) obj;
	}

	public Document<AbstractHrDocument<NewCandidate>> getSelectedNewCandidate() {
		return selectedNewCandidate;
	}

	public void setSelectedNewCandidate(
			Document<AbstractHrDocument<NewCandidate>> selectedNewCandidate) {
		this.selectedNewCandidate = selectedNewCandidate;
	}

	public List<Document<AbstractHrDocument<NewCandidate>>> getNewCandidates() {
		return newCandidates;
	}

	public void setNewCandidates(
			List<Document<AbstractHrDocument<NewCandidate>>> newCandidates) {
		this.newCandidates = newCandidates;
	}
	public void archiveNewCandidate() {
		archiveDocument(selectedNewCandidate);
		loadNewCandidates(targetDepartment);
	}
}
