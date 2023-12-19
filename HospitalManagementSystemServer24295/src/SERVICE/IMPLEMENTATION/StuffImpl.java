/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.Stuff;
import SERVICE.StuffInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoStuff;
/**
 *
 * @author destin
 */
public class StuffImpl extends UnicastRemoteObject implements StuffInterface{
    public StuffImpl() throws RemoteException{
        super();
    }
    public DaoStuff dao = new DaoStuff();

    @Override
    public String RegisterStuff(Stuff userAccounts) throws RemoteException {
        return dao.registerStuff(userAccounts);
    }

    @Override
    public String updateStuff(Stuff userAccounts) throws RemoteException {
        return dao.updateStuff(userAccounts);
    }

    @Override
    public String deleteStuff(Stuff userAccounts) throws RemoteException {
       return dao.deleteStuff(userAccounts);
    }

    @Override
    public List<Stuff> allStuff() throws RemoteException {
       return dao.allStuffs();
    }

    @Override
    public Stuff getStuffsById(Stuff userAccounts) throws RemoteException {
         return dao.searchStuff(userAccounts);
    }

    @Override
    public boolean validateUserLogin(String username, String password) throws RemoteException {
       return dao.validateUserLogin(username, password);
    }
  
    
}
