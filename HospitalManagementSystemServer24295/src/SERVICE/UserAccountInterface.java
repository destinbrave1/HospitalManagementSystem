/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.UserAccounts;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface UserAccountInterface {
    
     public String RegisterUserAccounts(UserAccounts userAccounts) throws RemoteException;
    public String updateUserAccounts(UserAccounts userAccounts) throws RemoteException;
    public String deleteUserAccounts(UserAccounts userAccounts) throws RemoteException;
    public List<UserAccounts> allUserAccounts()throws RemoteException;
    public UserAccounts getuserAccountsById(UserAccounts userAccounts) throws RemoteException;
}
