/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Stuff;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface StuffInterface extends Remote {
    
    public String RegisterStuff(Stuff userAccounts) throws RemoteException;
    public String updateStuff(Stuff userAccounts) throws RemoteException;
    public String deleteStuff(Stuff userAccounts) throws RemoteException;
    public List<Stuff> allStuff()throws RemoteException;
    public Stuff getStuffsById(Stuff userAccounts) throws RemoteException;
    boolean validateUserLogin(String username, String password) throws RemoteException;
}
