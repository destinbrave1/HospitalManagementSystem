/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Discharged;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface DischargedInterface extends Remote {
 
    public String Registerdischarged(Discharged adischarged) throws RemoteException;
    public String updateDischarged(Discharged adischarged) throws RemoteException;
    public String deleteDischarged(Discharged adischarged) throws RemoteException;
    public List<Discharged> allDischarged()throws RemoteException;
    public Discharged getdischargedById(Discharged adischarged) throws RemoteException;
}
