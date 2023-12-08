/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.TransactionPharmacy;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoTransactionPharmacy;
import SERVICE.PharmacyTransactionInterface;
/**
 *
 * @author destin
 */
public class TransactionPharmacyImpl extends UnicastRemoteObject implements PharmacyTransactionInterface{
    public TransactionPharmacyImpl()throws RemoteException{
        super();
    }
    public DaoTransactionPharmacy dao = new DaoTransactionPharmacy();
    @Override
    public String RegisterTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException {
       return dao.registerTransactionPharmacy(transactionPharmacy);
    }

    @Override
    public String updateTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException {
        return dao.updateTransactionPharmacy(transactionPharmacy);
    }

    @Override
    public String deleteTransactionPharmacy(TransactionPharmacy transactionPharmacy) throws RemoteException {
       return dao.deleteTransactionPharmacy(transactionPharmacy);
    }

    @Override
    public List<TransactionPharmacy> allTransactionPharmacy() throws RemoteException {
       return dao.allTransactionPharmacys();
    }

    @Override
    public TransactionPharmacy gettransactionPharmacyById(TransactionPharmacy transactionPharmacy) throws RemoteException {
        return dao.searchTransactionPharmacy(transactionPharmacy);
    }
   
    
}
