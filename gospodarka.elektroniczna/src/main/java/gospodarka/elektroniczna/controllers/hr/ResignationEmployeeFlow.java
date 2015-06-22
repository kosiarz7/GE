package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.hr.AbstractHrDocument;
import gospodarka.elektroniczna.dto.hr.ResignationEmployee;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.slf4j.LoggerFactory;

/**
 * Wypowiedzenie z pracy - pracownik
 * 
 * @author iblis
 *
 */
public class ResignationEmployeeFlow extends AbstractHrFlow<ResignationEmployee> implements Serializable {

    private static final long serialVersionUID = 1L;
	private Document<AbstractHrDocument<ResignationEmployee>> selectedResignationEmployee;
	private List<Document<AbstractHrDocument<ResignationEmployee>>> resignationEmployees;

    public ResignationEmployeeFlow() {
        super("Wypowiedzenie z pracy ze strony pracownika", DocumentTypes.RESIGNATION_EMPLOYEE, Departments.HUMAN_RESOURCES);
    }
    

    public boolean submitResignationEmployee(UserData userData, ResignationEmployee resignationEmployee) {
        LoggerFactory.getLogger(ResignationEmployeeFlow.class).debug("submitResignationEmployee", resignationEmployee);
        System.err.println(resignationEmployee.toString());
        return submit(userData, resignationEmployee);
    }

    public void loadResignationEmployees() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.RESIGNATION_EMPLOYEE);

        resignationEmployees = search(criteria);
        LoggerFactory.getLogger(ResignationEmployeeFlow.class).debug("getResignationEmployees", resignationEmployees.size());
        for (Document<AbstractHrDocument<ResignationEmployee>> buf : resignationEmployees)
        {
        	System.err.println(buf.getContent().getData());
        }

    }
    
	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		Object obj = event.getObject();
		selectedResignationEmployee = (Document<AbstractHrDocument<ResignationEmployee>>) obj;
	}


	public Document<AbstractHrDocument<ResignationEmployee>> getSelectedResignationEmployee() {
		return selectedResignationEmployee;
	}


	public void setSelectedResignationEmployee(
			Document<AbstractHrDocument<ResignationEmployee>> selectedResignationEmployee) {
		this.selectedResignationEmployee = selectedResignationEmployee;
		System.err.println("SET SELECTED: "+selectedResignationEmployee);
	}


	public List<Document<AbstractHrDocument<ResignationEmployee>>> getResignationEmployees() {
		return resignationEmployees;
	}


	public void setResignationEmployees(
			List<Document<AbstractHrDocument<ResignationEmployee>>> resignationEmployees) {
		this.resignationEmployees = resignationEmployees;
	}
	
	public void archiveResignationEmployee() {
		archiveDocument(selectedResignationEmployee);
		loadResignationEmployees();
	}
}
