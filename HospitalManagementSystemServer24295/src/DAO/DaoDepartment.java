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
import org.hibernate.Query;
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
       List<Department> dep = ss.createQuery("select dep from Department dep where "
               + "dep.dep_id ='"+object.getDep_id()+"'").list();
       ss.close();
       if(dep!=null)
       {
          return dep.get(0); 
       }
       
        }
        catch(Exception e)
       {
            e.printStackTrace();
        }
        
        return null;
    }
    
   public Department fetchDepartmentByName(String departmentName) {
    try {
        // Open a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Begin a transaction
        session.beginTransaction();

        // Query to fetch the Department entity by name
        String hql = "FROM Department WHERE departmentName = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", departmentName);

        // Execute the query and get the result
        Department department = (Department) query.uniqueResult();

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        return department;
    } catch (Exception e) {
        e.printStackTrace();
        // Handle exceptions or log errors as needed
    }

    return null;
}

    
}
