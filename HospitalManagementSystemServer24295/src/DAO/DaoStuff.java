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
            List<Stuff> stuffs = ss.createQuery("select theStuff from Stuff theStuff").list();
            ss.close();
            return stuffs;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Stuff searchStuff(Stuff object){
         try{
        Session ss = HibernateUtil.getSessionFactory().openSession();
       List<Stuff> stuffs = ss.createQuery("select stuffs from Stuff stuffs where "
               + "stuffs.stuffId ='"+object.getStuffId()+"'").list();
       ss.close();
       if(stuffs!=null)
       {
          return stuffs.get(0); 
       }
       
        }
        catch(Exception e)
       {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Stuff validateUserLogin(String username, String password, String theFunction) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Stuff WHERE stuffUsername = :username AND password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        Stuff user = (Stuff) query.uniqueResult();

        transaction.commit();
        session.close();

        if (user != null && theFunction.equals(user.getStuffFunction())) {
            return user; // Both username/password are correct, and the function matches.
        } else {
            return null; // Either username/password are incorrect, or the function doesn't match.
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
}

}
