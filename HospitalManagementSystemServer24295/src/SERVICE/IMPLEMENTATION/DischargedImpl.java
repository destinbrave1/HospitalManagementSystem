/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import DAO.Dao_DischargedPatients;
import MODEL.Discharged;
import SERVICE.DischargedInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author destin
 */
public class DischargedImpl extends UnicastRemoteObject implements DischargedInterface{
    public DischargedImpl() throws RemoteException{
        super();
    }
    public Dao_DischargedPatients dao = new Dao_DischargedPatients();
    @Override
    public String Registerdischarged(Discharged adischarged) throws RemoteException {
       return dao.registerDischarged(adischarged);
    }

    @Override
    public String updateDischarged(Discharged adischarged) throws RemoteException {
        return dao.updateDischarged(adischarged);
    }

    @Override
    public String deleteDischarged(Discharged adischarged) throws RemoteException {
        return dao.deleteDischarged(adischarged);
    }

    @Override
    public List<Discharged> allDischarged() throws RemoteException {
        return dao.allDischargeds();
    }

    @Override
    public Discharged getdischargedById(Discharged adischarged) throws RemoteException {
       return dao.searchDischarged(adischarged);
    }
    
}
