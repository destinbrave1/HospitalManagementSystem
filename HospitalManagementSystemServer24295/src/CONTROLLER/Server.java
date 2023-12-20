/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import SERVICE.IMPLEMENTATION.AppointmentsImpl;
import SERVICE.IMPLEMENTATION.DepartmentImpl;
import SERVICE.IMPLEMENTATION.DiagnosisImpl;
import SERVICE.IMPLEMENTATION.DischargedImpl;
import SERVICE.IMPLEMENTATION.InpatientImpl;
import SERVICE.IMPLEMENTATION.RoomImpl;
import SERVICE.IMPLEMENTATION.StockPharmacyImpl;
import SERVICE.IMPLEMENTATION.TransactionPharmacyImpl;
import SERVICE.IMPLEMENTATION.TransferedImpl;
import SERVICE.IMPLEMENTATION.StuffImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author destin
 */
public class Server {
    
    public AppointmentsImpl appointment;
    public DischargedImpl discharge;
    public InpatientImpl inpatient;
    public StockPharmacyImpl stockPharmacy;
    public TransactionPharmacyImpl transctionPharmacy;
    public TransferedImpl transfered;
    public StuffImpl stuffsAccounts;
    
    public RoomImpl rooms;
    public DepartmentImpl departmentsimpl;
    public DiagnosisImpl diagnosis;
    
    public Server() throws RemoteException 
    {
        this.appointment = new AppointmentsImpl();
        this.discharge = new DischargedImpl();
    
        this.inpatient = new InpatientImpl();
        this.stockPharmacy = new StockPharmacyImpl();
        this.transctionPharmacy = new TransactionPharmacyImpl();
        this.transfered = new TransferedImpl();
        this.stuffsAccounts = new StuffImpl();
        
        this.rooms = new RoomImpl();
        this.departmentsimpl = new DepartmentImpl();
        this.diagnosis = new DiagnosisImpl();
    }
    
    public static void main(String[] args) {
        try{
            Server server = new Server();
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("appointment", server.appointment);
            registry.rebind("discharge", server.discharge);
        
            registry.rebind("inpatient", server.inpatient);
            registry.rebind("stock", server.stockPharmacy);
            registry.rebind("transaction", server.transctionPharmacy);
            registry.rebind("transfered", server.transfered);
            registry.rebind("stuffs", server.stuffsAccounts);
            
            registry.rebind("rooms", server.rooms);
            registry.rebind("department", server.departmentsimpl);
            registry.rebind("diagnosis", server.diagnosis);
            
            System.out.println("the Server is running on port 6000");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
