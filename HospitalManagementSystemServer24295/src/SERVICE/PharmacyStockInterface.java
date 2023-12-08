/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.StockPharmacy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author destin
 */
public interface PharmacyStockInterface extends Remote{
    
    public String RegisterStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException;
    public String updateStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException;
    public String deleteStockPharmacy(StockPharmacy stockPharmacy) throws RemoteException;
    public List<StockPharmacy> allStockPharmacy()throws RemoteException;
    public StockPharmacy getstockPharmacyById(StockPharmacy stockPharmacy) throws RemoteException;
}
