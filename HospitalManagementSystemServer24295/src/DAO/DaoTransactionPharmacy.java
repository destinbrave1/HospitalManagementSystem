/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.TransactionPharmacy;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class DaoTransactionPharmacy {
    
      public String registerTransactionPharmacy(TransactionPharmacy object){
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
    public String updateTransactionPharmacy(TransactionPharmacy object){
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
    public String deleteTransactionPharmacy(TransactionPharmacy object){
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
    public List<TransactionPharmacy> allTransactionPharmacys(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<TransactionPharmacy> patients = ss.createQuery("select theTransactionPharmacy from TransactionPharmacy theTransactionPharmacy").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public TransactionPharmacy searchTransactionPharmacy(TransactionPharmacy object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            TransactionPharmacy theTransactionPharmacy = (TransactionPharmacy)ss.get(TransactionPharmacy.class, object.getPatient_id());
            ss.close();
            return theTransactionPharmacy;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
