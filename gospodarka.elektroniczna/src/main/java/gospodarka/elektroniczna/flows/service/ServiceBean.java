/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.service;

import gospodarka.elektroniczna.documents.service.CollectCarForm;
import gospodarka.elektroniczna.documents.service.DamagedCarForm;
import gospodarka.elektroniczna.documents.service.RepairCostEstimationForm;
import gospodarka.elektroniczna.documents.service.ReplacementPartOrderForm;
import gospodarka.elektroniczna.documents.service.WarrantyRepairForm;

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
             System.out.println(damagedCarForm.getCar().getVIN());
             System.out.println(damagedCarForm.getClient().getName());
             System.out.println(damagedCarForm.getWorker().getName());
             
             return true;
         }
         
         public boolean saveCollectCarForm(CollectCarForm collectCarForm)
         {
             System.out.println("COLLECT CAR FORM");
             System.out.println(collectCarForm.getDate().toString());
             System.out.println(collectCarForm.getCar().getBrand());
             System.out.println(collectCarForm.getCar().getModel());
             System.out.println(collectCarForm.getCar().getRegistrationNumber());
             System.out.println(collectCarForm.getCar().getVIN());
             System.out.println(collectCarForm.getClient().getName());
             System.out.println(collectCarForm.getWorker().getName());
             System.out.println(collectCarForm.getCarCondition());
             return true;
         }
         
         public boolean saveRepairCostEstimationForm(RepairCostEstimationForm repairCostEstimationForm)
         {
             System.out.println("REPAIR COST ESTIMATION FORM");
             System.out.println(repairCostEstimationForm.getDate().toString());
             System.out.println(repairCostEstimationForm.getCar().getBrand());
             System.out.println(repairCostEstimationForm.getCar().getModel());
             System.out.println(repairCostEstimationForm.getCar().getRegistrationNumber());
             System.out.println(repairCostEstimationForm.getCar().getVIN());
             System.out.println(repairCostEstimationForm.getClient().getName());
             System.out.println(repairCostEstimationForm.getWorker().getName());
             System.out.println(repairCostEstimationForm.getPrice());
             return true;
         }
         
         public boolean saveReplacementPartOrderForm(ReplacementPartOrderForm replacementPartOrderForm)
         {
             System.out.println("REPLACEMENT PART ORDER FORM");
             System.out.println(replacementPartOrderForm.getDate().toString());
             System.out.println(replacementPartOrderForm.getDeliveryDate().toString());
             System.out.println(replacementPartOrderForm.getWorker().getName());
             System.out.println(replacementPartOrderForm.getAmount());
             return true;
         }
         
         public boolean saveWarrantyRepairForm(WarrantyRepairForm warrantyRepairForm)
         {
             System.out.println("REPAIR COST ESTIMATION FORM");
             System.out.println(warrantyRepairForm.getDate().toString());
             System.out.println(warrantyRepairForm.getCar().getBrand());
             System.out.println(warrantyRepairForm.getCar().getModel());
             System.out.println(warrantyRepairForm.getCar().getRegistrationNumber());
             System.out.println(warrantyRepairForm.getCar().getVIN());
             System.out.println(warrantyRepairForm.getClient().getName());
             System.out.println(warrantyRepairForm.getWorker().getName());
             System.out.println(warrantyRepairForm.getDamagedPart());
             System.out.println(warrantyRepairForm.getRealisationDate());
             return true;
         }
}
