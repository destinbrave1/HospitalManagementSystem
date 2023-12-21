/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE.IMPLEMENTATION;
import MODEL.Appointments;
import DAO.DaoAppointments;
import SERVICE.AppointmentsInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
/**
 *
 * @author destin
 */
public class AppointmentsImpl extends UnicastRemoteObject implements AppointmentsInterface{

    public AppointmentsImpl() throws RemoteException{
        super();
    }
    public DaoAppointments dao = new DaoAppointments();
    @Override
    public String RegisterAppointments(Appointments appointments) throws RemoteException {
        return dao.registerAppointments(appointments);
    }

    @Override
    public String updateAppointments(Appointments appointments) throws RemoteException {
        return dao.updateAppointments(appointments);
    }

    @Override
    public String deleteAppointments(Appointments appointments) throws RemoteException {
        return dao.deleteAppointments(appointments);
    }

    @Override
    public List<Appointments> allAppointments() throws RemoteException {
        return dao.allAppointmentss();
    }

    @Override
    public Appointments getappointmentsById(Appointments appointments) throws RemoteException {
        return dao.searchAppointments(appointments);
    }
    
}
