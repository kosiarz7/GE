/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gospodarka.elektroniczna.flows.manufacture;

/**
 *
 * @author Dariusz
 */

import gospodarka.elektroniczna.dao.department.Departments;
import gospodarka.elektroniczna.documents.service.CollectCarForm;
import gospodarka.elektroniczna.documents.service.DamagedCarForm;
import gospodarka.elektroniczna.documents.service.WarrantyRepairForm;
import gospodarka.elektroniczna.dto.manufacture.DefectiveElementForm;
import gospodarka.elektroniczna.dto.manufacture.IndustrialAccidentForm;
import gospodarka.elektroniczna.dto.manufacture.MonthlySummaryOfProductionLine;
import gospodarka.elektroniczna.dto.manufacture.OrderForm;
import gospodarka.elektroniczna.dto.manufacture.TimeSheetForm;
import gospodarka.elektroniczna.dto.manufacture.VehicleForm;
import gospodarka.elektroniczna.services.document.Document;
import gospodarka.elektroniczna.services.document.DocumentStub;
import gospodarka.elektroniczna.services.document.IDocumentService;
import gospodarka.elektroniczna.services.document.SearchCriteria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dariusz
 */
public class ManufactureBean {
    
     public String sendMassage(){
          System.out.println("widac");   
         return "witaj";
     }
     
     public MonthlySummaryOfProductionLine createMonthlySummaryForm(){
         return new MonthlySummaryOfProductionLine();
     }
     
     public boolean saveMonthlySummary(MonthlySummaryOfProductionLine summary){
          System.out.println("Dodano formularz miesięcznego podsumowania");
          
          return true;
     }
     
     public boolean saveAccidentForm(IndustrialAccidentForm accidentForm){
         System.out.println("Dodano formularz wypadkowy");
         return true;
     }
     
     public boolean saveDefectiveElementForm(DefectiveElementForm defectiveElementForm){
         System.out.println("Dodano formularz uszkodzonego elementu");
         return true;
     }
     
     public boolean saveOrderForm(OrderForm orderForm){
         System.out.println("Dodano formularz zamówienia części");
         return true;
     }
     
     public boolean saveTimeSheetForm(TimeSheetForm timeSheetForm){
         System.out.println("Dodano formularz karty pracy pracownika");
         return true;
     }
     
     public boolean saveVehicleForm(VehicleForm vehicleForm){
         System.out.println("Dodano formularz nowego pojazdu");
         return true;
     }
     
     
     public List<MonthlySummaryOfProductionLine> getListOfMonthlySummary(){
         List<MonthlySummaryOfProductionLine> list = new ArrayList<>();
         
         MonthlySummaryOfProductionLine test = new MonthlySummaryOfProductionLine();
         test.setModelName("Honda");
         test.setDate(new Date());
         list.add(test);
         
         MonthlySummaryOfProductionLine test2 = new MonthlySummaryOfProductionLine();
         test2.setModelName("Mazda");
         test2.setDate(new Date());
         list.add(test2);
         
         return list;
     }
}
