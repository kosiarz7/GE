package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.hr.AbstractHrDocument;
import gospodarka.elektroniczna.dto.hr.SickLeave;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.slf4j.LoggerFactory;

/**
 * Zwolnienie chorobowe
 * 
 * @author iblis
 *
 */
public class SickLeaveFlow extends AbstractHrFlow<SickLeave> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private Document<AbstractHrDocument<SickLeave>> selectedSickLeave;
	private List<Document<AbstractHrDocument<SickLeave>>> sickLeaves;

	public SickLeaveFlow() {
		super("Zwolnienie lekarskie", DocumentTypes.SICK_LEAVE,
				Departments.HUMAN_RESOURCES);
	}

	public boolean submitSickLeave(UserData user, SickLeave sickLeave) {
		LoggerFactory.getLogger(SickLeaveFlow.class).debug("submitSickLeave",
				sickLeave);

		return submit(user, sickLeave);
	}

	public void loadSickLeaves() {

		SearchCriteria criteria = new SearchCriteria();
		criteria.department(Departments.HUMAN_RESOURCES);
		criteria.setType(DocumentTypes.SICK_LEAVE);

		sickLeaves = search(criteria);
		LoggerFactory.getLogger(HolidaysRequestFlow.class).debug(
				"getSickLeaves", sickLeaves.size());

	}

	public List<Document<AbstractHrDocument<SickLeave>>> getSickLeaves() {
		return sickLeaves;
	}

	public void setSickLeaves(
			List<Document<AbstractHrDocument<SickLeave>>> sickLeaves) {
		this.sickLeaves = sickLeaves;
	}

	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		Object obj = event.getObject();
		selectedSickLeave = (Document<AbstractHrDocument<SickLeave>>) obj;
	}

	public Document<AbstractHrDocument<SickLeave>> getSelectedSickLeave() {

		return selectedSickLeave;
	}

	public void setSelectedSickLeave(
			Document<AbstractHrDocument<SickLeave>> selectedSickLeave) {

		this.selectedSickLeave = selectedSickLeave;
	}

	public void archiveSickLeave() {
		archiveDocument(selectedSickLeave);
		loadSickLeaves();
	}

}
