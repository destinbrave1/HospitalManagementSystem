/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Discharged;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class Dao_DischargedPatients {
    
      public String registerDischarged(Discharged object){
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
    public String updateDischarged(Discharged object){
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
    public String deleteDischarged(Discharged object){
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
    public List<Discharged> allDischargeds(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Discharged> patients = ss.createQuery("select theDischarged from Discharged theDischarged").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Discharged searchDischarged(Discharged object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Discharged theDischarged = (Discharged)ss.get(Discharged.class, object.getDischarged_id());
            ss.close();
            return theDischarged;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
