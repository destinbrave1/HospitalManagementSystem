/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Transfered;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface TransferedInterface {
     public String RegisterTransfered(Transfered transfered) throws RemoteException;
    public String updateTransfered(Transfered transfered) throws RemoteException;
    public String deleteTransfered(Transfered transfered) throws RemoteException;
    public List<Transfered> allTransfered()throws RemoteException;
    public Transfered gettransferedById(Transfered transfered) throws RemoteException;
    
}
