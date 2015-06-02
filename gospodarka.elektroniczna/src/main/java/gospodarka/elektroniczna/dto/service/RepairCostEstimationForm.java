/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dto.service;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Piotrek
 */
public class RepairCostEstimationForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Car car;
    private String damageDescription;
    private Integer price;
    private Person client;
    private Person worker;

    public RepairCostEstimationForm() { }
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @return the damageDescription
     */
    public String getDamageDescription() {
        return damageDescription;
    }

    /**
     * @param damageDescription the damageDescription to set
     */
    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the client
     */
    public Person getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Person client) {
        this.client = client;
    }

    /**
     * @return the worker
     */
    public Person getWorker() {
        return worker;
    }

    /**
     * @param worker the worker to set
     */
    public void setWorker(Person worker) {
        this.worker = worker;
    }
    
}
