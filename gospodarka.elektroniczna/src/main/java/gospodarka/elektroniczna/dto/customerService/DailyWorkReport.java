package gospodarka.elektroniczna.dto.customerService;

import java.io.Serializable;
import java.util.Date;

public class DailyWorkReport extends AbstractCustomerServiceUser implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2255396073131433657L;

    private Date date;
    private Integer employeesAtShift;
    private Integer ordersServed;
    private Integer testDrivesPerformed;
    private Double moneyStatus;

    public DailyWorkReport() {
    }

    public void init() {
        date = new Date();
        employeesAtShift = 0;
        ordersServed = 0;
        testDrivesPerformed = 0;
        moneyStatus = 0.0;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getEmployeesAtShift() {
        return employeesAtShift;
    }

    public void setEmployeesAtShift(Integer employeesAtShift) {
        this.employeesAtShift = employeesAtShift;
    }

    public Integer getOrdersServed() {
        return ordersServed;
    }

    public void setOrdersServed(Integer ordersServed) {
        this.ordersServed = ordersServed;
    }

    public Integer getTestDrivesPerformed() {
        return testDrivesPerformed;
    }

    public void setTestDrivesPerformed(Integer testDrivesPerformed) {
        this.testDrivesPerformed = testDrivesPerformed;
    }

    public Double getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(Double moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    @Override
    public String toString() {
        return "DailyWorkReport [date=" + date + ", employeesAtShift=" + employeesAtShift
                + ", ordersServed=" + ordersServed + ", testDrivesPerformed=" + testDrivesPerformed
                + ", moneyStatus=" + moneyStatus + "]";
    }

}
