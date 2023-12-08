/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import DAO.DaoEmergencyRoom;
import MODEL.Emergency;
import SERVICE.EmergencyInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author destin
 */
public class EmergencyImpl extends UnicastRemoteObject implements EmergencyInterface {
    
    public EmergencyImpl() throws RemoteException{
        super();
    }
    public DaoEmergencyRoom dao = new DaoEmergencyRoom();
    @Override
    public String RegisterEmergency(Emergency emergency) throws RemoteException {
        return dao.registerEmergency(emergency);
    }

    @Override
    public String updateEmergency(Emergency emergency) throws RemoteException {
       return dao.updateEmergency(emergency);
    }

    @Override
    public String deleteEmergency(Emergency emergency) throws RemoteException {
        return dao.deleteEmergency(emergency);
    }

    @Override
    public List<Emergency> allEmergency() throws RemoteException {
       return dao.allEmergencys();
    }

    @Override
    public Emergency getEmergencyById(Emergency emergency) throws RemoteException {
       return dao.searchEmergency(emergency);
    }
    
    
    
}
