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
public class Discharged {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private String discharged_id;
    private String discharged_name;
    private String discharged_sickness;
    private String discharged_amount_paid;
    private String discharged_room_number;
    private String discharged_phone_number;
    private Date discharged_date_in;

    public Discharged() {
    }

    public Discharged(String discharged_id, String discharged_name, String discharged_sickness, String discharged_amount_paid, String discharged_room_number, String discharged_phone_number, Date discharged_date_in) {
        this.discharged_id = discharged_id;
        this.discharged_name = discharged_name;
        this.discharged_sickness = discharged_sickness;
        this.discharged_amount_paid = discharged_amount_paid;
        this.discharged_room_number = discharged_room_number;
        this.discharged_phone_number = discharged_phone_number;
        this.discharged_date_in = discharged_date_in;
    }
    
    public String getDischarged_id() {
        return discharged_id;
    }

    public String getDischarged_name() {
        return discharged_name;
    }

    public String getDischarged_sickness() {
        return discharged_sickness;
    }

    public String getDischarged_amount_paid() {
        return discharged_amount_paid;
    }

    public String getDischarged_room_number() {
        return discharged_room_number;
    }

    public String getDischarged_phone_number() {
        return discharged_phone_number;
    }

    public Date getDischarged_date_in() {
        return discharged_date_in;
    }

    public void setDischarged_id(String discharged_id) {
        this.discharged_id = discharged_id;
    }

    public void setDischarged_name(String discharged_name) {
        this.discharged_name = discharged_name;
    }

    public void setDischarged_sickness(String discharged_sickness) {
        this.discharged_sickness = discharged_sickness;
    }

    public void setDischarged_amount_paid(String discharged_amount_paid) {
        this.discharged_amount_paid = discharged_amount_paid;
    }

    public void setDischarged_room_number(String discharged_room_number) {
        this.discharged_room_number = discharged_room_number;
    }

    public void setDischarged_phone_number(String discharged_phone_number) {
        this.discharged_phone_number = discharged_phone_number;
    }

    public void setDischarged_date_in(Date discharged_date_in) {
        this.discharged_date_in = discharged_date_in;
    }
    
}
