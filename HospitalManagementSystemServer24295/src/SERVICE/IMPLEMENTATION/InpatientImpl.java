/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.Inpatients;
import SERVICE.InpatientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoInpatients;
/**
 *
 * @author destin
 */
public class InpatientImpl extends UnicastRemoteObject implements InpatientInterface{

    public InpatientImpl() throws RemoteException{
        super();
    }
    public DaoInpatients dao = new DaoInpatients();
    @Override
    public String RegisterInpatients(Inpatients inpatients) throws RemoteException {
        return dao.registerInpatients(inpatients);
    }

    @Override
    public String updateInpatients(Inpatients inpatients) throws RemoteException {
        return dao.updateInpatients(inpatients);
    }

    @Override
    public String deleteInpatients(Inpatients inpatients) throws RemoteException {
        return dao.deleteInpatients(inpatients);
    }

    @Override
    public List<Inpatients> allInpatients() throws RemoteException {
        return dao.allInpatientss();
    }

    @Override
    public Inpatients getinpatientsById(Inpatients inpatients) throws RemoteException {
        return dao.SearchInpatients(inpatients);
    }
    
    
}
