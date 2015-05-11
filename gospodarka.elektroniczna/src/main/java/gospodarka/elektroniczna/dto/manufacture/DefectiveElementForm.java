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
public class DefectiveElementForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private String complainant;
    private int productionLineNumber;
    private int workStationNumber;
    private int elementNumber;
    private String description;
    
    public DefectiveElementForm(){   
    }

    public Date getDate() {
        return date;
    }

        public void setDate(Date date) {
        this.date = date;
    }

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public int getProductionLineNumber() {
        return productionLineNumber;
    }

    public void setProductionLineNumber(int productionLineNumber) {
        this.productionLineNumber = productionLineNumber;
    }

    public int getWorkStationNumber() {
        return workStationNumber;
    }

    public void setWorkStationNumber(int workStationNumber) {
        this.workStationNumber = workStationNumber;
    }

    public int getElementNumber() {
        return elementNumber;
    }

    public void setElementNumber(int elementNUmber) {
        this.elementNumber = elementNUmber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
