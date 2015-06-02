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
             return true;
         }
}
