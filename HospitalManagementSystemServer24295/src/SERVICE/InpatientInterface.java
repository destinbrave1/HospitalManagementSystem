/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Inpatients;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface InpatientInterface extends Remote {
    
    public String RegisterInpatients(Inpatients inpatients) throws RemoteException;
    public String updateInpatients(Inpatients inpatients) throws RemoteException;
    public String deleteInpatients(Inpatients inpatients) throws RemoteException;
    public List<Inpatients> allInpatients()throws RemoteException;
    public Inpatients getinpatientsById(Inpatients inpatients) throws RemoteException;
}
