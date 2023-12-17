/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author destin
 */
import MODEL.Diagnosis;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoDiagnosis {
    
     public String registerDiagnosis(Diagnosis object){
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
    public String updateDiagnosis(Diagnosis object){
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
    public String deleteDiagnosis(Diagnosis object){
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
    public List<Diagnosis> allDiagnosis(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Diagnosis> diagnosisObject = ss.createQuery("select theDiagnosis from Diagnosis theDiagnosis").list();
            ss.close();
            return diagnosisObject;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Diagnosis searchDiagnosis(Diagnosis object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Diagnosis theDiagnosis = (Diagnosis)ss.get(Diagnosis.class, object.getId());
            ss.close();
            return theDiagnosis;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
