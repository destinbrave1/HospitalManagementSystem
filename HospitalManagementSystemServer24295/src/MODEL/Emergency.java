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
public class Emergency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String emergency_id;
    private String emergency_name;
    private String emergency_sickness;
    private String emergency_amount_paid;
    private String emergency_room_number;
    private String emergency_phone_number;
    private Date emergency_date_in;

    public Emergency() {
    }

    public Emergency(String emergency_id, String emergency_name, String emergency_sickness, String emergency_amount_paid, String emergency_room_number, String emergency_phone_number, Date emergency_date_in) {
        this.emergency_id = emergency_id;
        this.emergency_name = emergency_name;
        this.emergency_sickness = emergency_sickness;
        this.emergency_amount_paid = emergency_amount_paid;
        this.emergency_room_number = emergency_room_number;
        this.emergency_phone_number = emergency_phone_number;
        this.emergency_date_in = emergency_date_in;
    }
    

    public String getEmergency_id() {
        return emergency_id;
    }

    public String getEmergency_name() {
        return emergency_name;
    }

    public String getEmergency_sickness() {
        return emergency_sickness;
    }

    public String getEmergency_amount_paid() {
        return emergency_amount_paid;
    }

    public String getEmergency_room_number() {
        return emergency_room_number;
    }

    public String getEmergency_phone_number() {
        return emergency_phone_number;
    }

    public Date getEmergency_date_in() {
        return emergency_date_in;
    }

    public void setEmergency_id(String emergency_id) {
        this.emergency_id = emergency_id;
    }

    public void setEmergency_name(String emergency_name) {
        this.emergency_name = emergency_name;
    }

    public void setEmergency_sickness(String emergency_sickness) {
        this.emergency_sickness = emergency_sickness;
    }

    public void setEmergency_amount_paid(String emergency_amount_paid) {
        this.emergency_amount_paid = emergency_amount_paid;
    }

    public void setEmergency_room_number(String emergency_room_number) {
        this.emergency_room_number = emergency_room_number;
    }

    public void setEmergency_phone_number(String emergency_phone_number) {
        this.emergency_phone_number = emergency_phone_number;
    }

    public void setEmergency_date_in(Date emergency_date_in) {
        this.emergency_date_in = emergency_date_in;
    }
}
