/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import DAO.DaoDepartment;
import MODEL.Department;
import SERVICE.DepartmentInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
/**
 *
 * @author destin
 */
public class DepartmentImpl extends UnicastRemoteObject implements DepartmentInterface{
    public DepartmentImpl()throws RemoteException{
        super();
    }
    DaoDepartment dao = new DaoDepartment();
    @Override
    public String Registerdepartment(Department department) throws RemoteException {
        return dao.registerDepartment(department);
    }

    @Override
    public String updateDepartment(Department department) throws RemoteException {
        return dao.updateDepartment(department);
    }

    @Override
    public String deleteDepartment(Department department) throws RemoteException {
       return dao.deleteDepartment(department);
    }

    @Override
    public List<Department> allDepartment() throws RemoteException {
        return dao.allDepartment();
    }

    @Override
    public Department getdepartmentById(Department department) throws RemoteException {
        return dao.searchDepartment(department);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) throws RemoteException {
       return dao.fetchDepartmentByName(departmentName);
    }
    
}
