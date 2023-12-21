/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Appointments;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */

public class DaoAppointments {
    
    public String registerAppointments(Appointments object){
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
    public String updateAppointments(Appointments object){
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
    public String deleteAppointments(Appointments object){
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
    public List<Appointments> allAppointmentss(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Appointments> patients = ss.createQuery("select theAppointments from Appointments theAppointments").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Appointments searchAppointments(Appointments object){
        try{
            
       Session ss = HibernateUtil.getSessionFactory().openSession();
       List<Appointments> patients = ss.createQuery("select patients from Appointments patients where "
               + "patients.patient_national_id ='"+object.getPatient_national_id()+"'").list();
       ss.close();
       if(patients!=null)
       {
          return patients.get(0); 
       }
       
        }
        catch(Exception e)
       {
            e.printStackTrace();
        }
        
        return null;
    }
}
