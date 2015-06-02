package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;

public class ResignationEmployer extends AbstractHrUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Future
    private Date resignationDate;

    private String reason;

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ResignationEmployer [resignationDate=" + resignationDate + ", reason=" + reason + ", getUserName()="
                + getUserName() + ", getUserSurname()=" + getUserSurname() + ", getDepartment()=" + getDepartment()
                + "]";
    }

}
