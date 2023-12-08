/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Emergency;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface EmergencyInterface extends Remote {
    
    public String RegisterEmergency(Emergency emergency) throws RemoteException;
    public String updateEmergency(Emergency emergency) throws RemoteException;
    public String deleteEmergency(Emergency emergency) throws RemoteException;
    public List<Emergency> allEmergency()throws RemoteException;
    public Emergency getEmergencyById(Emergency emergency) throws RemoteException;
}
