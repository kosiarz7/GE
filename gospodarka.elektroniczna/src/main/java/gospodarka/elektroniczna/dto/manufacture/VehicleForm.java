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
public class VehicleForm extends AbstractManufactureUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private String vehicleModel;
    private int productionLineNumber;
    private String inspectorName;
    private String notes;

    public VehicleForm(){     
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getProductionLineNumber() {
        return productionLineNumber;
    }

    public void setProductionLineNumber(int productionLineNumber) {
        this.productionLineNumber = productionLineNumber;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
