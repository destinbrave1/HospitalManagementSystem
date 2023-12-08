/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author destin
 */
@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patient_id;
    private String patient_name;
    private String patient_sickness;
    private String patient_fever_degree;
    private String patient_amount_paid;
    private String patient_room_number;
    private String patient_phone_number;
    private Date patient_date_in;

    public Appointments() {
    }

    public Appointments(String patient_id, String patient_name, String patient_sickness, String patient_fever_degree, String patient_amount_paid, String patient_room_number, String patient_phone_number, Date patient_date_in) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_sickness = patient_sickness;
        this.patient_fever_degree = patient_fever_degree;
        this.patient_amount_paid = patient_amount_paid;
        this.patient_room_number = patient_room_number;
        this.patient_phone_number = patient_phone_number;
        this.patient_date_in = patient_date_in;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public void setPatient_sickness(String patient_sickness) {
        this.patient_sickness = patient_sickness;
    }

    public void setPatient_fever_degree(String patient_fever_degree) {
        this.patient_fever_degree = patient_fever_degree;
    }

    public void setPatient_amount_paid(String patient_amount_paid) {
        this.patient_amount_paid = patient_amount_paid;
    }

    public void setPatient_room_number(String patient_room_number) {
        this.patient_room_number = patient_room_number;
    }

    public void setPatient_phone_number(String patient_phone_number) {
        this.patient_phone_number = patient_phone_number;
    }

    public void setPatient_date_in(Date patient_date_in) {
        this.patient_date_in = patient_date_in;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public String getPatient_sickness() {
        return patient_sickness;
    }

    public String getPatient_fever_degree() {
        return patient_fever_degree;
    }

    public String getPatient_amount_paid() {
        return patient_amount_paid;
    }

    public String getPatient_room_number() {
        return patient_room_number;
    }

    public String getPatient_phone_number() {
        return patient_phone_number;
    }

    public Date getPatient_date_in() {
        return patient_date_in;
    }
}
