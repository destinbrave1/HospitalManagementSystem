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
import MODEL.Department;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoDepartment {
    
    public String registerDepartment(Department object){
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
    public String updateDepartment(Department object){
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
    public String deleteDepartment(Department object){
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
    public List<Department> allDepartment(){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Department> departmentObj = ss.createQuery("select theDepartment from Department theDepartment").list();
            ss.close();
            return departmentObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Department searchDepartment(Department object){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Department theDepartment = (Department)ss.get(Department.class, object.getDep_id());
            ss.close();
            return theDepartment;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
