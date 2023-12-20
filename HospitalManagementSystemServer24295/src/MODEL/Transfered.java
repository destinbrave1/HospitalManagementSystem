/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author destin
 */
@Entity
public class Transfered implements Serializable {
    private static final long serialVersionUID = 5149641714150001821L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String transfered_id;
    private String transfered_name;
    private String transfered__sickness;
    private String transfered__amount_paid;
    private String transfered__room_number;
    private String transfered__phone_number;
    private Date transfered_date_in;

    public Transfered () {
    }

    public Transfered (String transfered_id, String transfered_name, String transfered__sickness, String transfered__amount_paid, String transfered__room_number, String transfered__phone_number, Date transfered_date_in) {
        this.transfered_id = transfered_id;
        this.transfered_name = transfered_name;
        this.transfered__sickness = transfered__sickness;
        this.transfered__amount_paid = transfered__amount_paid;
        this.transfered__room_number = transfered__room_number;
        this.transfered__phone_number = transfered__phone_number;
        this.transfered_date_in = transfered_date_in;
    }
    
    
    public String getTransfered_id() {
        return transfered_id;
    }

    public String getTransfered_name() {
        return transfered_name;
    }

    public String getTransfered__sickness() {
        return transfered__sickness;
    }

    public String getTransfered__amount_paid() {
        return transfered__amount_paid;
    }

    public String getTransfered__room_number() {
        return transfered__room_number;
    }

    public String getTransfered__phone_number() {
        return transfered__phone_number;
    }

    public Date getTransfered_date_in() {
        return transfered_date_in;
    }

    public void setTransfered_id(String transfered_id) {
        this.transfered_id = transfered_id;
    }

    public void setTransfered_name(String transfered_name) {
        this.transfered_name = transfered_name;
    }

    public void setTransfered__sickness(String transfered__sickness) {
        this.transfered__sickness = transfered__sickness;
    }

    public void setTransfered__amount_paid(String transfered__amount_paid) {
        this.transfered__amount_paid = transfered__amount_paid;
    }

    public void setTransfered__room_number(String transfered__room_number) {
        this.transfered__room_number = transfered__room_number;
    }

    public void setTransfered__phone_number(String transfered__phone_number) {
        this.transfered__phone_number = transfered__phone_number;
    }

    public void setTransfered_date_in(Date transfered_date_in) {
        this.transfered_date_in = transfered_date_in;
    }

}
