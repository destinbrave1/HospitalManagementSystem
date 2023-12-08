/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author destin
 */

public class TransactionPharmacy {

    private Integer id;
    private String patient_id;
    private String patient_name;
    private String purchased_drug;
    private Date purchased_date;
    private String amount_paid;
    private String phone_number;

    public TransactionPharmacy() {
    }

    public TransactionPharmacy(String patient_id, String patient_name, String purchased_drug, Date purchased_date, String phone_number) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.purchased_drug = purchased_drug;
        this.purchased_date = purchased_date;
        this.phone_number = phone_number;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public String getPurchased_drug() {
        return purchased_drug;
    }

    public Date getPurchased_date() {
        return purchased_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public void setPurchased_drug(String purchased_drug) {
        this.purchased_drug = purchased_drug;
    }

    public void setPurchased_date(Date purchased_date) {
        this.purchased_date = purchased_date;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAmount_paid(String amount_paid) {
        this.amount_paid = amount_paid;
    }
    
}
