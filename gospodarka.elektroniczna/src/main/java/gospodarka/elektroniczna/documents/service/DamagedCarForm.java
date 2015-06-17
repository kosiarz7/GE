/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.documents.service;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;

/**
 *
 * @author Piotrek
 */
public class DamagedCarForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private Car car;
    private Person client;
    private Person worker;
    private boolean testRide;
    
    public DamagedCarForm() { }

    
    @PostConstruct
    public void init() {
        this.client = new Person();
        this.worker = new Person();
        this.car = new Car();
        
    }
    
    public void clear() {
        this.date = null;
        this.car = new Car();
        this.client = new Person();
        this.worker = new Person();
        this.testRide = false;
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

    /**
     * @return the testRide
     */
    public boolean isTestRide() {
        return testRide;
    }

    /**
     * @param testRide the testRide to set
     */
    public void setTestRide(boolean testRide) {
        this.testRide = testRide;
    }
}
