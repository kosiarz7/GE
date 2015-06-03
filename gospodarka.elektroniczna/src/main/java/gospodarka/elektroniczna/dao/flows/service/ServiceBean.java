/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.dao.flows.service;

import gospodarka.elektroniczna.dto.service.DamagedCarForm;

/**
 *
 * @author Piotrek
 */
public class ServiceBean {
    
         public String sendMessage(){
          System.out.println("widac");   
         return "witaj";
     }
         
         public boolean saveDamagedCarForm(DamagedCarForm damagedCarForm)
         {
             System.out.println("DAMAGED CAR FORM");
             System.out.println(damagedCarForm.getDate().toString());
             System.out.println(damagedCarForm.getCar().getBrand());
             System.out.println(damagedCarForm.getCar().getModel());
             System.out.println(damagedCarForm.getCar().getRegistrationNumber());
             //System.out.println(damagedCarForm.getCar().getVIN());
             System.out.println(damagedCarForm.getClient().getName());
             System.out.println(damagedCarForm.getWorker().getName());
             
             return true;
         }
}
