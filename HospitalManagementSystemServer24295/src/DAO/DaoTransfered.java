/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Transfered;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class DaoTransfered {
 
      public String registerTransfered(Transfered object){
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
    public String updateTransfered(Transfered object){
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
    public String deleteTransfered(Transfered object){
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
    public List<Transfered> allTransfereds(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Transfered> patients = ss.createQuery("select theTransfered from Transfered theTransfered").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Transfered searchTransfered(Transfered object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transfered theTransfered = (Transfered)ss.get(Transfered.class, object.getTransfered_id());
            ss.close();
            return theTransfered;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
