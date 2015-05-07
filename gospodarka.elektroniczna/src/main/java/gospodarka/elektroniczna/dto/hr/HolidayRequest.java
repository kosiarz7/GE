package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;

public class HolidayRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Future
	private Date fromDate;

	@Future
	private Date toDate;

	// poki co olewam zastepce :)

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
