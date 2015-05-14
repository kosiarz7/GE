package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

public class TrainingClearing extends AbstractHrUser implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String trainingName;

    @Past
    private Date startDate;
    @Past
    private Date endDate;
    private double amount;

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TrainingClearing [trainingName=" + trainingName + ", startDate=" + startDate + ", endDate=" + endDate
                + ", amount=" + amount + ", getUserName()=" + getUserName() + ", getUserSurname()=" + getUserSurname()
                + ", getDepartment()=" + getDepartment() + "]";
    }

}
