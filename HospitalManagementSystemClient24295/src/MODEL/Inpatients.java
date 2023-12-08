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

public class Inpatients {
    private Integer id;
    private String inpatient_id;
    private String inpatient_name;
    private String inpatient_sickness;
    private String inpatient_fever_degree;
    private String inpatient_amount_paid;
    private String inpatient_room_number;
    private String inpatient_phone_number;
    private Date inpatient_date_in;

    public Inpatients() {
    }

    public Inpatients(String inpatient_id, String inpatient_name, String inpatient_sickness, String inpatient_fever_degree, String inpatient_amount_paid, String inpatient_room_number, String inpatient_phone_number, Date inpatient_date_in) {
        this.inpatient_id = inpatient_id;
        this.inpatient_name = inpatient_name;
        this.inpatient_sickness = inpatient_sickness;
        this.inpatient_fever_degree = inpatient_fever_degree;
        this.inpatient_amount_paid = inpatient_amount_paid;
        this.inpatient_room_number = inpatient_room_number;
        this.inpatient_phone_number = inpatient_phone_number;
        this.inpatient_date_in = inpatient_date_in;
    }

    public String getInpatient_id() {
        return inpatient_id;
    }

    public String getInpatient_name() {
        return inpatient_name;
    }

    public String getInpatient_sickness() {
        return inpatient_sickness;
    }

    public String getInpatient_fever_degree() {
        return inpatient_fever_degree;
    }

    public String getInpatient_amount_paid() {
        return inpatient_amount_paid;
    }

    public String getInpatient_room_number() {
        return inpatient_room_number;
    }

    public String getInpatient_phone_number() {
        return inpatient_phone_number;
    }

    public Date getInpatient_date_in() {
        return inpatient_date_in;
    }

    public void setInpatient_id(String inpatient_id) {
        this.inpatient_id = inpatient_id;
    }

    public void setInpatient_name(String inpatient_name) {
        this.inpatient_name = inpatient_name;
    }

    public void setInpatient_sickness(String inpatient_sickness) {
        this.inpatient_sickness = inpatient_sickness;
    }

    public void setInpatient_fever_degree(String inpatient_fever_degree) {
        this.inpatient_fever_degree = inpatient_fever_degree;
    }

    public void setInpatient_amount_paid(String inpatient_amount_paid) {
        this.inpatient_amount_paid = inpatient_amount_paid;
    }

    public void setInpatient_room_number(String inpatient_room_number) {
        this.inpatient_room_number = inpatient_room_number;
    }

    public void setInpatient_phone_number(String inpatient_phone_number) {
        this.inpatient_phone_number = inpatient_phone_number;
    }

    public void setInpatient_date_in(Date inpatient_date_in) {
        this.inpatient_date_in = inpatient_date_in;
    }
}
