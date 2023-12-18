/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.UserAccounts;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class DaoUserAccounts {
      public String registerUserAccounts(UserAccounts object){
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
    public String updateUserAccounts(UserAccounts object){
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
    public String deleteUserAccounts(UserAccounts object){
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
    public List<UserAccounts> allUserAccountss(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<UserAccounts> patients = ss.createQuery("select theUserAccounts from UserAccounts theUserAccounts").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public UserAccounts searchUserAccounts(UserAccounts object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            UserAccounts theUserAccounts = (UserAccounts)ss.get(UserAccounts.class, object.getUseriD());
            ss.close();
            return theUserAccounts;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
