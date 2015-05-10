package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

public class SickLeave implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    //private UserData user;
    private Date fromDate;
    private Date toDate;

    public SickLeave(/*UserData user, */Date fromDate, Date toDate) {
        super();
       // this.user = user;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

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
/*
    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
*/
}
