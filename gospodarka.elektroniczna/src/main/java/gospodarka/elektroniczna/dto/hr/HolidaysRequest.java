package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;

public class HolidaysRequest extends AbstractHrUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Future
    private Date fromDate;

    @Future
    private Date toDate;

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
        return "HolidaysRequest [fromDate=" + fromDate + ", toDate=" + toDate + ", getUserName()=" + getUserName()
                + ", getUserSurname()=" + getUserSurname() + ", getDepartment()=" + getDepartment() + "]";
    }

    
}
