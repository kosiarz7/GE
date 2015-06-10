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
public class MonthlySummaryOfProductionLine extends AbstractManufactureUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private int productionLineNumber;
    private String modelName;
    private int amountOfProductedElements;
    private String reportedProblems;
    private int numberOfDefectiveElements;
    private String productionLineManager;

    public MonthlySummaryOfProductionLine(){
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProductionLineNumber() {
        return productionLineNumber;
    }

    public void setProductionLineNumber(int productionLineNumber) {
        this.productionLineNumber = productionLineNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getAmountOfProductedElements() {
        return amountOfProductedElements;
    }

    public void setAmountOfProductedElements(int amountOfProductedElements) {
        this.amountOfProductedElements = amountOfProductedElements;
    }

    public String getReportedProblems() {
        return reportedProblems;
    }

    public void setReportedProblems(String reportedProblems) {
        this.reportedProblems = reportedProblems;
    }

    public int getNumberOfDefectiveElements() {
        return numberOfDefectiveElements;
    }

    public void setNumberOfDefectiveElements(int numberOfDefectiveElements) {
        this.numberOfDefectiveElements = numberOfDefectiveElements;
    }

    public String getProductionLineManager() {
        return productionLineManager;
    }

    public void setProductionLineManager(String productionLineManager) {
        this.productionLineManager = productionLineManager;
    }
    
}
