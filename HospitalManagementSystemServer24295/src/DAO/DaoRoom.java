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
import MODEL.Rooms;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoRoom {
    
     public String registerRooms(Rooms object){
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
    public String updateRooms(Rooms object){
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
    public String deleteRooms(Rooms object){
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
    public List<Rooms> allRooms(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Rooms> roomObjt = ss.createQuery("select theRooms from Rooms theRooms").list();
            ss.close();
            return roomObjt;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Rooms searchRooms(Rooms object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Rooms theRooms = (Rooms)ss.get(Rooms.class, object.getRoom_no());
            ss.close();
            return theRooms;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
