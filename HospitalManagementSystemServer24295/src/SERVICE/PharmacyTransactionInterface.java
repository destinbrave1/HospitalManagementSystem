/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.TransactionPharmacy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface PharmacyTransactionInterface extends Remote {
     public String RegisterTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException;
    public String updateTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException;
    public String deleteTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException;
    public List<TransactionPharmacy> allTransactionPharmacy()throws RemoteException;
    public TransactionPharmacy gettransactionPharmacyById(TransactionPharmacy transactionPharmacy) throws RemoteException;
}
