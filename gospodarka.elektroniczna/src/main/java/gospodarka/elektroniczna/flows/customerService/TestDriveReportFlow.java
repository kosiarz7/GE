package gospodarka.elektroniczna.flows.customerService;

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.dao.documenttype.DocumentTypes;
import gospodarka.elektroniczna.dto.customerService.TestDriveReport;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import gospodarka.elektroniczna.services.user.UserData;

import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

public class TestDriveReportFlow extends AbstractCustomerServiceFlow<TestDriveReport> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2697803412518486545L;

	public TestDriveReportFlow() {
		 super("Raport z jazdy testowej", DocumentTypes.TEST_DRIVE_REPORT, Departments.SERVIS);
	}
	
	public boolean submitTestDriveReport(UserData userData,
           TestDriveReport testDriveReport) {

       LoggerFactory.getLogger(TestDriveReportFlow.class).debug("submitTestDriveReport",
               testDriveReport);

       return submit(userData, testDriveReport);
   }

   public List<TestDriveReport> getTestDriveReports() {

       SearchCriteria criteria = new SearchCriteria();
       criteria.department(Departments.SERVIS);
       criteria.setType(DocumentTypes.TEST_DRIVE_REPORT);

       List<TestDriveReport> testDriveReports = search(criteria);
       LoggerFactory.getLogger(TestDriveReport.class).debug("getTestDriveReports",
               testDriveReports.size());

       return testDriveReports;
   }

}
