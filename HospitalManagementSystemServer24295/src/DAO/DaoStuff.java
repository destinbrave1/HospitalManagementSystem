/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Stuff;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author destin
 */
public class DaoStuff {
      public String registerStuff(Stuff object){
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
    public String updateStuff(Stuff object){
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
    public String deleteStuff(Stuff object){
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
    public List<Stuff> allStuffs(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Stuff> patients = ss.createQuery("select theStuff from Stuff theStuff").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Stuff searchStuff(Stuff object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Stuff theStuff = (Stuff)ss.get(Stuff.class, object.getStuffId());
            ss.close();
            return theStuff;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean validateUserLogin(String username, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Stuff WHERE username = :username AND password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Stuff user = (Stuff) query.uniqueResult();

            transaction.commit();
            session.close();

            return user != null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
