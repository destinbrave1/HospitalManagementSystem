/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.UserAccounts;
import SERVICE.UserAccountInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoUserAccounts;
/**
 *
 * @author destin
 */
public class UserAccountsImpl extends UnicastRemoteObject implements UserAccountInterface{
    public UserAccountsImpl() throws RemoteException{
        super();
    }
    public DaoUserAccounts dao = new DaoUserAccounts();
    @Override
    public String RegisterUserAccounts(UserAccounts userAccounts) throws RemoteException {
       return dao.registerUserAccounts(userAccounts);
    }

    @Override
    public String updateUserAccounts(UserAccounts userAccounts) throws RemoteException {
       return dao.updateUserAccounts(userAccounts);
    }

    @Override
    public String deleteUserAccounts(UserAccounts userAccounts) throws RemoteException {
       return dao.deleteUserAccounts(userAccounts);
    }

    @Override
    public List<UserAccounts> allUserAccounts() throws RemoteException {
        return dao.allUserAccountss();
    }

    @Override
    public UserAccounts getuserAccountsById(UserAccounts userAccounts) throws RemoteException {
        return dao.searchUserAccounts(userAccounts);
    }
    
}
