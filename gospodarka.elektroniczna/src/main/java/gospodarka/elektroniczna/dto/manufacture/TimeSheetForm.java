/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dto.manufacture;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dariusz
 */
public class TimeSheetForm extends AbstractManufactureUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private String shift;
    private String name;
    private String surname;
    private int productionLine;
    private int workStationNumber;

    public TimeSheetForm(){
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(int productionLine) {
        this.productionLine = productionLine;
    }

    public int getWorkStationNumber() {
        return workStationNumber;
    }

    public void setWorkStationNumber(int workStationNumber) {
        this.workStationNumber = workStationNumber;
    }
    
    
}
