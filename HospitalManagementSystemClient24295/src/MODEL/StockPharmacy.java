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
public class StockPharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String drug_id_stock;
    private Date   drug_date_stock;
    private String drug_name_stock;
    private String drug_price_stock;
    private int drug_stock_in;
    private int drug_stock_out;
    private int remaining_stock;

    public StockPharmacy() {
    }

    public StockPharmacy(String drug_id_stock, Date drug_date_stock, String drug_name_stock, String drug_price_stock, int drug_stock_in, int drug_stock_out, int remaining_stock) {
        this.drug_id_stock = drug_id_stock;
        this.drug_date_stock = drug_date_stock;
        this.drug_name_stock = drug_name_stock;
        this.drug_price_stock = drug_price_stock;
        this.drug_stock_in = drug_stock_in;
        this.drug_stock_out = drug_stock_out;
        this.remaining_stock = remaining_stock;
    }
    
    
    
    public void setDrug_id_stock(String drug_id_stock) {
        this.drug_id_stock = drug_id_stock;
    }

    public void setDrug_date_stock(Date drug_date_stock) {
        this.drug_date_stock = drug_date_stock;
    }

    public void setDrug_name_stock(String drug_name_stock) {
        this.drug_name_stock = drug_name_stock;
    }

    public void setDrug_price_stock(String drug_price_stock) {
        this.drug_price_stock = drug_price_stock;
    }

    public void setDrug_stock_in(int drug_stock_in) {
        this.drug_stock_in = drug_stock_in;
    }

    public void setDrug_stock_out(int drug_stock_out) {
        this.drug_stock_out = drug_stock_out;
    }

    public void setRemaining_stock(int remaining_stock) {
        this.remaining_stock = remaining_stock;
    }

    public String getDrug_id_stock() {
        return drug_id_stock;
    }

    public Date getDrug_date_stock() {
        return drug_date_stock;
    }

    public String getDrug_name_stock() {
        return drug_name_stock;
    }

    public String getDrug_price_stock() {
        return drug_price_stock;
    }

    public int getDrug_stock_in() {
        return drug_stock_in;
    }

    public int getDrug_stock_out() {
        return drug_stock_out;
    }

    public int getRemaining_stock() {
        return remaining_stock;
    }
    
}
