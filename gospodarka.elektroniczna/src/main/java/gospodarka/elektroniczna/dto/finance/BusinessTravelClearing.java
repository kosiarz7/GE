package gospodarka.elektroniczna.dto.finance;

import java.io.Serializable;
import java.util.Date;

public class BusinessTravelClearing extends AbstractFinanceUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Date startDate;
    private Date endDate;
    private String country = "Polska";
    private String city;
    private double amount;
    private boolean approved = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "BusinessTravelClearing [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
                + ", country=" + country + ", city=" + city + ", amount=" + amount + ", approved=" + approved
                + ", getUserName()=" + getUserName() + ", getUserSurname()=" + getUserSurname() + ", getDepartment()="
                + getDepartment() + "]";
    }



}
