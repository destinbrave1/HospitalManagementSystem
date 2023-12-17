/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import MODEL.Department;
/**
 *
 * @author destin
 */
public interface DepartmentInterface extends Remote{
     public String Registerdepartment(Department department) throws RemoteException;
    public String updateDepartment(Department department) throws RemoteException;
    public String deleteDepartment(Department department) throws RemoteException;
    public List<Department> allDepartment()throws RemoteException;
    public Department getdepartmentById(Department department) throws RemoteException;
}
