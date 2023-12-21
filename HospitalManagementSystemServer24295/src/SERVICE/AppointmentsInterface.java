/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;
import MODEL.Appointments;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author destin
 */
public interface AppointmentsInterface extends Remote{
    
    public String RegisterAppointments(Appointments appointments) throws RemoteException;
    public String updateAppointments(Appointments appointments) throws RemoteException;
    public String deleteAppointments(Appointments appointments) throws RemoteException;
    public List<Appointments> allAppointments()throws RemoteException;
    public Appointments getappointmentsById(Appointments appointments) throws RemoteException;
}
