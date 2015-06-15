package gospodarka.elektroniczna.flows.customerService;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.customerService.DailyWorkReport;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

public class DailyWorkReportFlow extends AbstractCustomerServiceFlow<DailyWorkReport> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6320736741394092834L;

	public DailyWorkReportFlow() {
		 super("Raport dziennej pracy salonu", DocumentTypes.DAILY_WORK_REPORT, Departments.FINANCE);
	}
	
	public boolean submitDailyWorkReport(UserData userData,
			DailyWorkReport dailyWorkReport) {

       LoggerFactory.getLogger(DailyWorkReport.class).debug("submitDailyWorkReport",
    		   dailyWorkReport);

       return submit(userData, dailyWorkReport);
   }

   public List<DailyWorkReport> getDailyWorkReports() {

       SearchCriteria criteria = new SearchCriteria();
       criteria.department(Departments.FINANCE);
       criteria.setType(DocumentTypes.DAILY_WORK_REPORT);

       List<DailyWorkReport> dailyWorkReports = search(criteria);
       LoggerFactory.getLogger(DailyWorkReport.class).debug("getDailyWorkReports",
    		   dailyWorkReports.size());

       return dailyWorkReports;
   }
}
