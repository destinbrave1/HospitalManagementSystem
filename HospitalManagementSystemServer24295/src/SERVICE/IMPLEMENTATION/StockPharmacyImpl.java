/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;

import MODEL.StockPharmacy;
import SERVICE.PharmacyStockInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import DAO.DaoStockPharmacy;
/**
 *
 * @author destin
 */
public class StockPharmacyImpl extends UnicastRemoteObject implements PharmacyStockInterface{

    public StockPharmacyImpl() throws RemoteException{
        super();
    }
    public DaoStockPharmacy dao = new DaoStockPharmacy();
    @Override
    public String RegisterStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException {
       return dao.registerStockPharmacy(stockPharmacy);
    }

    @Override
    public String updateStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException {
       return dao.updateStockPharmacy(stockPharmacy);
    }

    @Override
    public String deleteStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException {
        return dao.deleteStockPharmacy(stockPharmacy);
    }

    @Override
    public List<StockPharmacy> allStockPharmacy() throws RemoteException {
        return dao.allStockPharmacys();
    }

    @Override
    public StockPharmacy getstockPharmacyById(StockPharmacy stockPharmacy) throws RemoteException {
        return dao.searchStockPharmacy(stockPharmacy);
    }
    
}
