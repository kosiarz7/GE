/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dto.service;

import java.io.Serializable;

/**
 *
 * @author Piotrek
 */
public class Car implements Serializable{
    
    private static final long serialVersionUID = 1L;

    
    private String brand;
    private String model;
    private String registrationNumber;
    private String VIN;

    public Car() {
    }
    
    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the VIN
     */
    public String getVIN() {
        return VIN;
    }

    /**
     * @param VIN the VIN to set
     */
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    
}
