/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Emergency;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class DaoEmergencyRoom {
      public String registerEmergency(Emergency object){
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
    public String updateEmergency(Emergency object){
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
    public String deleteEmergency(Emergency object){
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
    public List<Emergency> allEmergencys(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Emergency> patients = ss.createQuery("select theEmergency from Emergency theEmergency").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Emergency searchEmergency(Emergency object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Emergency theEmergency = (Emergency)ss.get(Emergency.class, object.getEmergency_id());
            ss.close();
            return theEmergency;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
