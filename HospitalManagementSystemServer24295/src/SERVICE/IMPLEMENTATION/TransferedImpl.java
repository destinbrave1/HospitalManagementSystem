/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.Transfered;
import SERVICE.TransferedInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoTransfered;
/**
 *
 * @author destin
 */
public class TransferedImpl extends UnicastRemoteObject implements TransferedInterface{
    public TransferedImpl()throws RemoteException{
        super();
    }
    public DaoTransfered dao = new DaoTransfered();
    @Override
    public String RegisterTransfered(Transfered transfered) throws RemoteException {
        return dao.registerTransfered(transfered);
    }

    @Override
    public String updateTransfered(Transfered transfered) throws RemoteException {
        return dao.updateTransfered(transfered);
    }

    @Override
    public String deleteTransfered(Transfered transfered) throws RemoteException {
       return dao.deleteTransfered(transfered);
    }

    @Override
    public List<Transfered> allTransfered() throws RemoteException {
       return dao.allTransfereds();
    }

    @Override
    public Transfered gettransferedById(Transfered transfered) throws RemoteException {
        return dao.searchTransfered(transfered);
    }
    
}
