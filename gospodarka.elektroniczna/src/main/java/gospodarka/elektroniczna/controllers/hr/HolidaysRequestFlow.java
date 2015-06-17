package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.documents.hr.AbstractHrDocument;
import gospodarka.elektroniczna.dto.hr.HolidaysRequest;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.primefaces.event.SelectEvent;
import org.slf4j.LoggerFactory;

/**
 * Wniosek o urlop
 * 
 * @author iblis
 *
 */
public class HolidaysRequestFlow extends AbstractHrFlow<HolidaysRequest> implements Serializable {

    private static final long serialVersionUID = 1L;
	private Document<AbstractHrDocument<HolidaysRequest>> selectedHolidaysRequest;
	private List<Document<AbstractHrDocument<HolidaysRequest>>> holidaysRequests;
	
    public HolidaysRequestFlow() {
        super("Wniose o urlop", DocumentTypes.HOLIDAYS_REQUEST, Departments.HUMAN_RESOURCES);
    }

    public boolean submitHolidaysRequest(UserData userData, HolidaysRequest holidayRequest) {
        LoggerFactory.getLogger(CandidateRequestFlow.class).debug("submitCandidateRequest", holidayRequest);

        return submit(userData, holidayRequest);
    }

    public void loadHolidaysRequests() {

        SearchCriteria criteria = new SearchCriteria();
        criteria.department(Departments.HUMAN_RESOURCES);
        criteria.setType(DocumentTypes.HOLIDAYS_REQUEST);

        holidaysRequests = search(criteria);
        sortHolidaysRequest();
        LoggerFactory.getLogger(HolidaysRequestFlow.class).debug("getHolidaysRequests", holidaysRequests.size());

    }
    
    private void sortHolidaysRequest()
    {
    	Collections.sort(holidaysRequests, new Comparator<Document<AbstractHrDocument<HolidaysRequest>>>() {

			@Override
			public int compare(
					Document<AbstractHrDocument<HolidaysRequest>> o1,
					Document<AbstractHrDocument<HolidaysRequest>> o2) {
				Date date1 = o1.getContent().getData().getFromDate();
				Date date2 = o2.getContent().getData().getFromDate();
				return -date1.compareTo(date2);
			}
		});
    }
    
	@SuppressWarnings("unchecked")
	public void onRowSelect(SelectEvent event) {
		Object obj = event.getObject();
		selectedHolidaysRequest = (Document<AbstractHrDocument<HolidaysRequest>>) obj;
	}

	public Document<AbstractHrDocument<HolidaysRequest>> getSelectedHolidaysRequest() {
		return selectedHolidaysRequest;
	}

	public void setSelectedHolidaysRequest(
			Document<AbstractHrDocument<HolidaysRequest>> selectedHolidaysRequest) {
		this.selectedHolidaysRequest = selectedHolidaysRequest;
	}

	public void setHolidaysRequests(
			List<Document<AbstractHrDocument<HolidaysRequest>>> holidaysRequests) {
		this.holidaysRequests = holidaysRequests;
	}
	
	public List<Document<AbstractHrDocument<HolidaysRequest>>> getHolidaysRequests() {
		return holidaysRequests;
	}

	public void archiveHolidaysRequest() {
		archiveDocument(selectedHolidaysRequest);
		loadHolidaysRequests();
	}
}
