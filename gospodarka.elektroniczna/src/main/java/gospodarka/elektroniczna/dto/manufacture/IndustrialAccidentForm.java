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
public class IndustrialAccidentForm extends AbstractManufactureUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private String attendees;
    private String sufferers;
    private String descriptionOfOccurrence;
    private String damage;
    
    public IndustrialAccidentForm(){
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getSufferers() {
        return sufferers;
    }

    public void setSufferers(String sufferers) {
        this.sufferers = sufferers;
    }

    public String getDescriptionOfOccurrence() {
        return descriptionOfOccurrence;
    }

    public void setDescriptionOfOccurrence(String descriptionOfOccurrence) {
        this.descriptionOfOccurrence = descriptionOfOccurrence;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
    
}
