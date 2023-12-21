/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.StockPharmacy;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author destin
 */
public class DaoStockPharmacy {
    
      public String registerStockPharmacy(StockPharmacy object){
        try{
        
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(object);
            tr.commit();

            ss.close();
            return "Registed successfully";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String updateStockPharmacy(StockPharmacy object){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(object);
            ss.beginTransaction().commit();
            ss.close();
            return "Updated successfully";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String deleteStockPharmacy(StockPharmacy object){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(object);
            ss.beginTransaction().commit();
            ss.close();
            return "Deleted successfully";
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<StockPharmacy> allStockPharmacys(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<StockPharmacy> patients = ss.createQuery("select theStockPharmacy from StockPharmacy theStockPharmacy").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public StockPharmacy searchStockPharmacy(StockPharmacy object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            StockPharmacy theStockPharmacy = (StockPharmacy)ss.get(StockPharmacy.class, object.getDrug_id_stock());
            ss.close();
            return theStockPharmacy;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
