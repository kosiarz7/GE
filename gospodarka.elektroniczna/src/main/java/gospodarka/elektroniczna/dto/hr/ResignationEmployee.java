package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;

public class ResignationEmployee extends AbstractHrUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Future
    private Date resignationDate;

    public Date getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(Date resignationDate) {
        this.resignationDate = resignationDate;
    }

    @Override
    public String toString() {
        return "ResignationEmployee [resignationDate=" + resignationDate + ", getUserName()=" + getUserName()
                + ", getUserSurname()=" + getUserSurname() + ", getDepartment()=" + getDepartment() + "]";
    }

    
}
