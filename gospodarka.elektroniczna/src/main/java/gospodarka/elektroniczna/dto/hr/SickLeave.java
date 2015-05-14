package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

public class SickLeave extends AbstractHrUser implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Date fromDate;
    private Date toDate;

    public SickLeave() {
    }

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

    @Override
    public String toString() {
        return "SickLeave [fromDate=" + fromDate + ", toDate=" + toDate + ", getUserName()=" + getUserName()
                + ", getUserSurname()=" + getUserSurname() + ", getDepartment()=" + getDepartment() + "]";
    }

}
