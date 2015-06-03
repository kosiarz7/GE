/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dto.service;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;

/**
 *
 * @author Piotrek
 */
public class CollectCarForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Car car;
    private String carCondition;
    private Person worker;
    private Person client;

    public CollectCarForm() { }
    
    @PostConstruct
    public void init() {
        this.car = new Car();
        this.client = new Person();
        this.worker = new Person();
    }
    
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
     * @return the carCondition
     */
    public String getCarCondition() {
        return carCondition;
    }

    /**
     * @param carCondition the carCondition to set
     */
    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
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
    
}
